<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오전 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int dan = 5;

%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>
    <h1>구구단( 스크립틀릿 + 표현식)</h1>
    <%for(int i =0; i<=9; i++){%>
    <div><%=dan%>x<%=i%>=<%= dan * i %></div>
    <% } %>



    <h1>구구단( 스크립틀릿 + out객체)</h1>





<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

