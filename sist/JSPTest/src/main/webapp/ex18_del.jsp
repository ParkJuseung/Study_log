<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오전 10:43
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
    <h1>세션 삭제하기</h1>

    <%
        session.removeAttribute("date");
    %>

    <div><a href="ex18_session.jsp">돌아가기</a></div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

