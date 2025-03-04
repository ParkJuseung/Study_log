<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  int dan =5;
%>
<head>
    <title>Title</title>
</head>
<style>
  <%=dan%>
</style>
<body>
  <%
    for(int i=1; i<=9; i++){
  %>
    <div><%= dan %> x <%=i%> = <%= dan * i %></div>
  <%
    }
  %>

</body>
</html>
