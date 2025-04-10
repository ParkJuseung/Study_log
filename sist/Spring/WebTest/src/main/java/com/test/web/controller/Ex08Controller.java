package com.test.web.controller;

import com.test.web.model.AddressDTO;
import oracle.net.jdbc.TNSAddress.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class Ex08Controller {

    //1. String
    //- JSP 파일명
    //- ViewResolver 호출
//    @GetMapping("/ex08.do")
//    public String ex08(){
//
//        //요청 메서드의 반환값
//
//        return "ex08";
//    }

    //2. void
    //- Spring 4.3 이후 지원
    //- 요청 주소와 동일한 이름의 JSP 호출
    //- 추천하는 방식은 아님
//    @GetMapping("/ex08.do")
//    public void ex08(){
//
//    // /ex08.do ->가상 주소 유추 ->  ex08.jsp 자동 호출
//
//    }


//    //3. String + 키워드
//    //- redirect : URL
//    //- forward : URL
//    @GetMapping("/ex08.do")
//    public String ex08(){
//
//        //resp.sendRedirect("/ex07.do")랑 같은 기능
////        return "redirect:/ex07.do";
//
//        //pageContext.forward()랑 같은 기능
//        return "forward:/ex07.do";
//    }



    //4. String
    // RedirectAttributes
//    @GetMapping("/ex08.do")
//    public String ex08(RedirectAttributes rttr){
//        //RedirectAttributes는 쿼리 스트링을 만들어주는 애
//
//        String seq = "5";
//        String id = "hong";
//
//        rttr.addAttribute("seq", seq);
//        rttr.addAttribute("id", id);
//
//        return "redirect:/ex07.do";
//
//    }

    //5. JSON 반환
    //- @ResponseBody
    //- 요청 메서드의 반환값을 JSON으로 반환
//    @GetMapping("/ex08.do")
//    public @ResponseBody String ex08(){
//
//        String name= "test";
//
//        return name;
//    }

//    @GetMapping("/ex08.do")
//    public @ResponseBody AddressDTO ex08(){
//
//        AddressDTO dto = new AddressDTO();
//        dto.setName("홍길동");
//        dto.setAge(20);
//        dto.setAddress("서울시");
//
//        return dto;
//    }

    @GetMapping("/ex08.do")
    public @ResponseBody ArrayList<AddressDTO> ex08(){

        AddressDTO dto = new AddressDTO();
        dto.setName("홍길동");
        dto.setAge(20);
        dto.setAddress("서울시");

        AddressDTO dto2 = new AddressDTO();
        dto2.setName("아무개");
        dto2.setAge(21);
        dto2.setAddress("제주시");

        ArrayList<AddressDTO> list = new ArrayList<>();
        list.add(dto);
        list.add(dto2);

        return list;
    }
}
