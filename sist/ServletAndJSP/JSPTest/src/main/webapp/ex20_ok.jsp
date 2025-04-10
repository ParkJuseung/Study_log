<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오후 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = application.getRealPath("/pic");
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

    <div>제목 : <%= subject %></div>

    <div>
        <div>첨부파일 : <%= filename.size() %>개</div>
        <%
            for(int i =0; i<filename.size(); i++){
        %>
        <div><a href="download.jsp?filename=<%org%>&orgfilename=bbb.txt"><%=orgfilename.get(i)%></a></div>
    </div>
    <%
        }
    %>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

