<%@ page import="java.io.File" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 업로드 설정
    String uploadPath = application.getRealPath("/files");
    int size = 1024 * 1024 * 100; // 100MB 제한

    String subject = "";
    ArrayList<String> filename = new ArrayList<>();
    ArrayList<String> orgfilename = new ArrayList<>();

    // 업로드 폴더가 존재하지 않으면 생성
    File uploadDir = new File(uploadPath);
    if (!uploadDir.exists()) {
        uploadDir.mkdir();
    }

    // 요청이 Multipart인지 확인
    if (ServletFileUpload.isMultipartContent(request)) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(size); // 메모리 사용 크기 지정
        factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); // 임시 저장소 설정

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(size); // 파일 크기 제한

        try {
            List<FileItem> formItems = upload.parseRequest(request);

            for (FileItem item : formItems) {
                if (item.isFormField()) {
                    // 일반 폼 데이터 처리
                    if (item.getFieldName().equals("subject")) {
                        subject = item.getString("UTF-8"); // UTF-8 인코딩 적용
                    }
                } else {
                    // 파일 처리
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);

                    item.write(storeFile); // 파일 저장
                    filename.add(fileName);
                    orgfilename.add(item.getName());
                }
            }
        } catch (Exception ex) {
            out.println("파일 업로드 중 오류 발생: " + ex.getMessage());
        }
    }
%>

<html>
<head>
    <title>파일 업로드 결과</title>
</head>
<body>
<h1>파일 업로드 완료</h1>
<p>제목: <%= subject %></p>
<h2>업로드된 파일 목록</h2>
<ul>
    <% for (int i = 0; i < filename.size(); i++) { %>
    <li>저장된 파일명: <%= filename.get(i) %> (원본 파일명: <%= orgfilename.get(i) %>)</li>
    <% } %>
</ul>
<a href="index.jsp">돌아가기</a>
</body>
</html>
