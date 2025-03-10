<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-07
  Time: 오후 3:38
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
    <h1>세번째 페이지</h1>
    <div>
        <a href="ex26_cookie_1.jsp">첫번째 페이지</a>
        <a href="ex26_cookie_2.jsp">두번째 페이지</a>
        <a href="ex26_cookie_3.jsp">세번째 페이지</a>
    </div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
    <script src="js/cookie.js"></script>
<script>
    const color = getCookie('color'); // 쿠키에서 색상 값 읽기
    if (color) {
        $('body').css('background-color', color); // 배경색 적용
    }
</script>
</body>
</html>

