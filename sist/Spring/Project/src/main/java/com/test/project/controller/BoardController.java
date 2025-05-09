package com.test.project.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import com.test.project.mapper.BoardMapper;
import com.test.project.model.BoardDTO;
import com.test.project.model.TagDTO;
import com.test.project.model.TaggingDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

	private final BoardMapper mapper;
	private final ServletContext servletContext;

	@GetMapping("/list")
	public String list(Model model, HttpSession session, String column, String word, String page, String tag) {

		// 1. 목록보기: /list
		// 1. 목록보기: /list?column=subject&word=
		// 2. 검색하기: /list?column=subject&word=검색어
		// System.out.println("column: " + column);
		// System.out.println("word: " + word);

		String search = "n"; // 목록보기(n), 검색하기(y)

		if ((column == null && word == null) || word.equals("")) {
			search = "n";
			column = "";
			word = "";
		} else {
			search = "y";
		}
		

		// 페이징
		// - /list : 1페이지
		// - /list?page=1 : 1페이지
		// - /list?page=2 : 2페이지
		// - /list?page=5 : 5페이지

		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한 페이지 당 출력할 게시물 수
		int totalPage = 0; // 총 페이지 수
		int offset = 0; // offset
		int n = 0; // 페이지바
		int loop = 0; // 페이지바
		int blockSize = 10; // 페이지바

		if (page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}

		// offset 계산
		// - 1페이지: offset 0 rows fetch next 10 rows only
		// - 2페이지: offset 10 rows fetch next 10 rows only
		// - 3페이지: offset 20 rows fetch next 10 rows only
		// - offset ((nowPage - 1) * pageSize) rows
		offset = (nowPage - 1) * pageSize;

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("search", search);
		map.put("column", column);
		map.put("word", word);

		map.put("offset", offset + "");
		map.put("pageSize", pageSize + "");
		
		if (tag == null) tag = "";
		
		map.put("tag", tag);

		List<BoardDTO> list = mapper.list(map);

		for (BoardDTO bdto : list) {

			// DTO 조작
			String subject = bdto.getSubject();

			// 태그 이스케이프 처리
			subject = subject.replace("<", "&lt;").replace(">", "&gt;");

			// 긴 제목 자르기
			if (subject.length() > 20) {
				subject = subject.substring(0, 20) + "..";
			}

			bdto.setSubject(subject);

		}

		// 조회수 증가 방지
		session.setAttribute("isRead", 0);

		// 페이지바
		// - 총 게시물? 251
		// - 총 페이지수? 251 / 10 = 25.1 > 26
		totalCount = mapper.getTotalCount(map);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);

		// 페이지바 생성
		StringBuilder sb = new StringBuilder();

//		for (int i=1; i<=totalPage; i++) {
//			sb.append(String.format(" <a href='/project/board/list?page=%d'>%d</a> ", i, i));
//		}

		// list?page=1
		// [] 1 2 3 4 5 6 7 8 9 10 []

		// list?page=2
		// [] 1 2 3 4 5 6 7 8 9 10 []

		// list?page=10
		// [] 1 2 3 4 5 6 7 8 9 10 []

		// list?page=11
		// [] 11 12 13 14 15 16 17 18 19 20 []

		loop = 1;// 루프 변수(10바퀴)
		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 출력할 페이지 번호

		// 이전 10페이지
		if (n == 1) {
			sb.append(String.format(" <a href='#!'>[이전 %d페이지]</a> ", blockSize));
		} else {
			sb.append(
					String.format(" <a href='/project/board/list?page=%d&search=%s&column=%s&word=%s'>[이전 %d페이지]</a> ",
							n - 1, search, column, word, blockSize));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a> ", n));
			} else {
				sb.append(String.format(" <a href='/project/board/list?page=%d&search=%s&column=%s&word=%s'>%d</a> ", n,
						search, column, word, n));
			}

			loop++;
			n++;
		}

		// 다음 10페이지
		if (n > totalPage) {
			sb.append(String.format(" <a href='#!'>[다음 %d페이지]</a> ", blockSize));
		} else {
			sb.append(
					String.format(" <a href='/project/board/list?page=%d&search=%s&column=%s&word=%s'>[다음 %d페이지]</a> ",
							n, search, column, word, blockSize));
		}

		map.put("nowPage", nowPage + "");
		map.put("totalCount", totalCount + "");
		map.put("totalPage", totalPage + "");
		map.put("pagebar", sb.toString());

		model.addAttribute("list", list);
		model.addAttribute("map", map);
		

		return "board.list";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/add")
	public String add() {

		return "board.add";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/addok")
	public String addok(BoardDTO dto) {
		
		
		// System.out.println("attach: " + dto.getAttach().getOriginalFilename());

		String path = servletContext.getRealPath("/resources/files");
		System.out.println(path);

		if (!dto.getAttach().isEmpty()) {
			try {

				String fileName = dto.getAttach().getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				fileName = uuid + "_" + fileName;

				File file = new File(path + "\\" + fileName);
				dto.getAttach().transferTo(file);

				dto.setAttachName(fileName);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dto.setAttachName("");
		}

		// , Authentication auth
		// System.out.println(auth);
		// System.out.println(auth.getName()); //hong

		int result = mapper.add(dto);
		
		
		//태그 작업
		System.out.println("tag: " + dto.getTag());
		//tag: [{"value":"하나"},{"value":"둘"},{"value":"셋"}]
		
		try {
			JSONParser parser = new JSONParser();
			JSONArray arr = (JSONArray)parser.parse(dto.getTag());
			
			for (Object obj : arr) {
				
				//{"value":"하나"}
				JSONObject tag = (JSONObject)obj;
				String tagName = (String)tag.get("value");
				System.out.println(tagName);
				
				//태그 추가하기
				TagDTO tdto = new TagDTO();
				tdto.setTag(tagName);
				
				if (mapper.existTag(tagName)) {
					//기존에 존재하는 태그 > 추가(X) + 태그 PK 반환
					tdto = mapper.getTag(tagName);
				} else {
					//처음 추가하는 태그 > 추가(O) + 태그 PK 반환
					mapper.addTag(tdto);
				}
				
				//***
				TaggingDTO tgdto = new TaggingDTO();
				tgdto.setBseq(dto.getSeq());
				tgdto.setTseq(tdto.getSeq());
				
				mapper.addTagging(tgdto);
				
			}//for 
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		if (result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/add";
		}

	}

	@GetMapping("/view")
	public String view(Model model, String seq, HttpSession session, String search, String column, String word,
			String page) {

		// 조회수 증가시키기
		if ((int) session.getAttribute("isRead") == 0) {
			mapper.addReadcount(seq);
			session.setAttribute("isRead", 1);
		}

		// view?seq=5
		BoardDTO bdto = mapper.view(seq);

		// DTO 조작
		String subject = bdto.getSubject();
		// 태그 이스케이프 처리
		subject = subject.replace("<", "&lt;").replace(">", "&gt;");
		bdto.setSubject(subject);

		String content = bdto.getContent();
		// 태그 이스케이스 처리
		content = content.replace("<", "&lt;").replace(">", "&gt;");
		// 개행문자 처리
		content = content.replace("\r\n", "<br>");
		bdto.setContent(content);

		// 검색 + 내용 > 검색어를 표시하기
		// - "안녕하세요. 홍길동입니다."
		// - "안녕하세요. <span style="background-color:gold;color:tomato;">홍길동</span>입니다."
		// - 홍길동 >> <span style="background-color:gold;color:tomato;">홍길동</span>

		// view?seq=7&search=n&column=&word=
		// view?seq=7&search=y&column=content&word=하나

		if (search != null && search.equals("y") && column.equals("content")) {
			content = content.replace(word, "<span style=\"background-color:gold;color:tomato;\">" + word + "</span>");
			bdto.setContent(content);
		}

		// 첨부 파일 > 메타 데이터
		if (bdto.getAttachName() != null) {

			if (bdto.getAttachName().toLowerCase().endsWith(".jpg")
					|| bdto.getAttachName().toLowerCase().endsWith(".jpeg")
					|| bdto.getAttachName().toLowerCase().endsWith(".gif")
					|| bdto.getAttachName().toLowerCase().endsWith(".png")) {

				// 메타 데이터 접근
				try {
					String path = servletContext.getRealPath("/resources/files");
					File file = new File(path + "/" + bdto.getAttachName());

					Metadata metadata = ImageMetadataReader.readMetadata(file);
					
					//GPS
					GpsDirectory gps = metadata.getFirstDirectoryOfType(GpsDirectory.class);
					
					if (gps != null 
							&& gps.containsTag(GpsDirectory.TAG_LATITUDE) 
							&& gps.containsTag(GpsDirectory.TAG_LONGITUDE)) {
						System.out.println(">>>" + gps.getGeoLocation().getLatitude());
						System.out.println(">>>" + gps.getGeoLocation().getLongitude());
						
						model.addAttribute("lat", gps.getGeoLocation().getLatitude());
						model.addAttribute("lng", gps.getGeoLocation().getLongitude());
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		
		//해당 게시물에 달린 태그들 가져오기
		List<String> tags = mapper.getTags(seq);
		
		//[게시판, 태그, 스프링] > 게시판,태그,스프링
		System.out.println(tags.toString().substring(1, tags.toString().length() - 1).replace(" ", ""));

		model.addAttribute("bdto", bdto);
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("word", word);
		model.addAttribute("page", page);
		model.addAttribute("tags", tags.toString().substring(1, tags.toString().length() - 1).replace(" ", ""));

		return "board.view";
	}

	@PreAuthorize("isAuthenticated() and (principal.username == #id or hasRole('ROLE_ADMIN'))")
	@GetMapping("/edit")
	public String edit(Model model, String seq, String id) {

		// 현재 로그인한 id == 작성자의 id
		// auth.getName() == bdto.id

		// edit?seq=5
		BoardDTO bdto = mapper.view(seq);

		// model.addAttribute(bdto);
		model.addAttribute("bdto", bdto);

		return "board.edit";
	}

	@PreAuthorize("isAuthenticated() and (principal.username == #bdto.id or hasRole('ROLE_ADMIN'))")
	@PostMapping("/editok")
	public String editok(BoardDTO bdto) {

		int result = mapper.edit(bdto);

		if (result == 1) {
			return "redirect:/board/view?seq=" + bdto.getSeq();
		} else {
			return "redirect:/board/edit?seq=" + bdto.getSeq();
		}

	}

	@PreAuthorize("isAuthenticated() and (principal.username == #id or hasRole('ROLE_ADMIN'))")
	@GetMapping("/del")
	public String del(Model model, String seq, String id) {

		model.addAttribute("seq", seq);
		model.addAttribute("id", id);

		return "board.del";
	}

	@PreAuthorize("isAuthenticated() and (principal.username == #bdto.id or hasRole('ROLE_ADMIN'))")
	@PostMapping("/delok")
	public String delok(BoardDTO bdto) {

		//첨부 파일 삭제
		String fileName = mapper.view(bdto.getSeq()).getAttachName();
		
		if (fileName != null && !fileName.equals("")) {
			
			File file = new File(servletContext.getRealPath("/resources/files/" + fileName));
			
			file.delete();
			
		}
		
		
		// 댓글부터 삭제
		mapper.cbdel(bdto.getSeq());

		int result = mapper.del(bdto);

		if (result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/del?seq=" + bdto.getSeq();
		}

	}

}
