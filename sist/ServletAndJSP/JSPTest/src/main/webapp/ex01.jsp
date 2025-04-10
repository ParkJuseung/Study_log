<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
    <h1>제목입니다</h1>

    <%
        //자바 영역
        Calendar now = Calendar.getInstance();

    %>

    <div>현재 시각은 <%= String.format("%tT", now) %> 입니다.</div>

    <%@include file="./inc/copyright.jsp"%>
</body>
</html>
