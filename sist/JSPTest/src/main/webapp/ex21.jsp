<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오후 3:40
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
    <h1>Image Gallery</h1>



    <div id="list">
        <div>사진</div>
        <div>사진</div>
        <div>사진</div>
    </div>

    <form action="ex21_ok.jsp" method="post" enctype="multipart/form-data"></form>

    <table class="vertical">
        <tr>
            <th>이미지</th>
            <td><input type="file" name="attach" required></td>
        </tr>
    </table>

    <div><button>이미지 업로드</button></div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

