<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = application.getRealPath("/pic");


    File dir = new File(path);
    File[] list = dir.listFiles();

    Arrays.sort(list, new Comparator<File>(){
        public int compare(File o1, File o2){
            return Long.compare(o1.lastModified(), o2.lastModified());
        }
    });
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>


<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

