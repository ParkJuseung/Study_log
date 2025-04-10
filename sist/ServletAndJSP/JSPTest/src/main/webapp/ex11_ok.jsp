<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-05
  Time: 오후 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String width = request.getParameter("width");
    String height = request.getParameter("height");

    String color = request.getParameter("color");
    String txt = request.getParameter("txt");

    int count = Integer.parseInt(request.getParameter("count"));


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
    <% for(int i=0; i<count; i++){ %>
        <div style="border:1px solid black; width:<%=width%>px; height: <%=height%>px; background-color: <%=color%>"><%=txt%></div>

    <% } %>


<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

