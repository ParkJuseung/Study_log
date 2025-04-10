<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-05
  Time: 오후 4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>
    <h1>요청 관련 정보</h1>

    <div>요청 URL : <%= request.getRequestURI()%></div>
    <div>요청 서버 도메인 : <%= request.getServerName()%></div>
    <div>요청 포트 번호 : <%= request.getServerPort()%></div>
    <div>쿼리 문자열 : <%= request.getQueryString()%></div>
    <div>요청 메서드 : <%= request.getMethod()%></div>
    <div>컨텍스트 경로 : <%= request.getContextPath()%></div>


    <div>
        <a href="./ex12_form.jsp">12번 페이지(상대경로)</a>
    </div>

    <div>
        <a href="<%= request.getContextPath()%>/ex12_form.jsp">12번 페이지(절대경로)</a>
    </div>

    <div>
        클라이언트 주소 : <%= request.getRemoteAddr()%>
    </div>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

