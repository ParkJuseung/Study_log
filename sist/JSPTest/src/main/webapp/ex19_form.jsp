<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오후 12:28
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
    <h1>파일 업로드</h1>
    <form action="ex19_ok.jsp" method="post" enctype="multipart/form-data"></form>
    <table>
        <tr>
            <th>문자열</th>
            <td><input type="text" name="txt"></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td><input type="file" name="attach"></td>
        </tr>
    </table>

    <div><button type="submit">보내기</button></div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

