<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-05
  Time: 오후 12:05
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 5:17
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
    <h1>박스 만들기</h1>
    <hr>
    <table class="vertical">
        <tr>
            <th>너비</th>
            <td><input type="number" min="100" max="500" step="10" name="width" value="100"></td>
        </tr>
        <tr>
            <th>높이</th>
            <td><input type="number" min="100" max="500" step="10" name="height" value="100"></td>
        </tr>

        <tr>
            <th>배경색</th>
            <td><input type="color" name="color" value="#FFFFFF" style="height: 35px;"></td>
        </tr>
        <tr>
            <th>text</th>
            <td><input type="text" name="txt"></td>
        </tr>
        <tr>
            <th>개수</th>
            <td><input type="number" name="coutn" min="1" max="10" value="1"></td>
        </tr>
    </table>
    <div>
        <input type="submit" value="만들기">
    </div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

