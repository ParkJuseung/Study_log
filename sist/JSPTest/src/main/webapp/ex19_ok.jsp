<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오후 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    String path = "C:\\Users\\user\\IdeaProjects\\Study_log\\sist\\JSPTest\\src\\main\\webapp\\files";
    String path = application.getRealPath("/files");
//    System.out.println(path);

    //업로드 파일의 최대 크기 지정
    int size = 1024 * 1024 * 100; // 100mb

    //변수 선언
    String txt = "";
    String filename = "";
    String orgfilename = "";

// 리터럴 값과 인코딩을 상수로 정의
    final int MAX_UPLOAD_SIZE = 1024 * 1024 * 10; // 최대 업로드 크기 10MB
    final String ENCODING_TYPE = "UTF-8"; // 파일 인코딩

// 변수로 매개변수 추출
    String uploadPath = path;
    FileRenamePolicy renamePolicy = new DefaultFileRenamePolicy();

// MultipartRequest 객체 생성
    // 객체 생성과 동시에 업로드
    MultipartRequest multipartRequest = new MultipartRequest(
            request,
            uploadPath,
            MAX_UPLOAD_SIZE,
            ENCODING_TYPE,
            renamePolicy
    );
    txt = multi.getParameter("txt");

//    System.out.println(multi.getparameter("attach"));
    filename = multi.getFilesystemName("attach");
    orgfilename = multi.getOriginalFileName("attach");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>
    <h1>결과</h1>

    <div> 문자열 : <%=txt%></div>
    <div> 첨부 파일 : <%=filename%></div>
    <div> 첨부 파일 : <%=orgfilename%></div>

    <h2>파일 다운로드 </h2>


    <div><a href="/jsp/files/<%=filename%>"><%= orgfilename %></a></div>
    <%--    모든 브라우저에 지원하지 않음, 파일명 보장이 안됨  --%>
    <div><a href="/jsp/files/<%=filename%>" download><%= orgfilename %></a></div>

    <%--  프로그램 구현 : 비용이 발생하지만 통제 가능  --%>
    <div>
        <a href="download.jsp?filename=<%= filename%>&orgfilename=<%= orgfilename%>"><%=orgfilename%></a>
    </div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

