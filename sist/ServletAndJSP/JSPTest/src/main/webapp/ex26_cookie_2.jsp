<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>두번째 페이지</h1> <!-- 또는 세번째 페이지 -->
<div>
    <a href="ex26_cookie_1.jsp">첫번째 페이지</a>
    <a href="ex26_cookie_2.jsp">두번째 페이지</a>
    <a href="ex26_cookie_3.jsp">세번째 페이지</a>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="js/cookie.js"></script>
<script>
    const color = getCookie('color'); // 쿠키에서 색상 값 읽기
    if (color) {
        $('body').css('background-color', color); // 배경색 적용
    }
</script>
</body>
</html>