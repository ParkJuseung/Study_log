<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-05
  Time: 오후 2:24
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

<%
    Random rnd = new Random();
    String[] stat = {"당첨" ,"꽝", "다시 한번 기회를 .."};
%>
<h1>당첨 결과</h1>
<div><%=stat[rnd.nextInt(stat.length)]%></div>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

