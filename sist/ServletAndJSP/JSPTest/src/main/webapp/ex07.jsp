<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String name = "홍길동";
  int dan = 5;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>안녕하세요. <%= name%>님</h1>
    <hr>
    <% for(int i =0; i<=9; i++){%>
    <div><%=dan %> x <%= i%> = <%= dan * i%></div>
    <% } %>

</body>
</html>
