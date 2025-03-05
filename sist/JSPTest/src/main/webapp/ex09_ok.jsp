<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //JSP 페이지 코드 분리
    //1. 상단부 스크립틀릿
    // - 데이터 수신하는 코드
    // - 변수/객체 생성하기
    //2. 하단 HTML
    // - 페이지 내용
    // - 자바 데이터 활용 -> 표현식 -> 출력

    // 수신할 데이터의 인코딩 처리
    //getparameter 처리 전에 인코딩을 해야함
    request.setCharacterEncoding("UTF-8");

    //데이터 수신하기
    String txt = request.getParameter("txt");
    String num = request.getParameter("num");
    String txt2 = request.getParameter("txt2");

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
    <div>txt : <%=txt%></div>
    <div>num : <%=num%></div>
    <div>txt2: <%=txt2.length()%></div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>
