<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Memo</title>
    <%@ include file="/inc/asset.jsp" %>
    <style>

    </style>
</head>
<body>
<!-- add.jsp -->
<%@ include file="/inc/header.jsp" %>

<h1>Memo <small>쓰기</small></h1>
<%
    System.out.println("현재 Context Path: " + request.getContextPath());
%>
<form method="POST" action="${pageContext.request.contextPath}/addok.jsp">
    <table class="vertical">
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" required></td>
        </tr>
        <tr>
            <th>암호</th>
            <td><input type="password" name="pw" required></td>
        </tr>
        <tr>
            <th>메모</th>
            <td><textarea name="memo" class="full" required></textarea></td>
        </tr>
    </table>
    <div>
        <button type="submit" class="add">쓰기</button>
        <button type="button" class="back" onclick="location.href='${pageContext.request.contextPath}/list.jsp';">돌아가기</button>
    </div>
</form>

<script>

</script>
</body>
</html>






