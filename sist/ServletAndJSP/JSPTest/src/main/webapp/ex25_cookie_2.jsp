<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-07
  Time: 오후 2:45
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
    <div id="result">

    </div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script src="js/cookie.js"></script>
<script>
    $('#result').append('<div>' + getCookie('name') + '</div>');
    $('#result').append('<div>' + getCookie('kor') + '</div>');
    $('#result').append('<div>' + getCookie('eng') + '</div>');
    $('#result').append('<div>' + getCookie('math') + '</div>');

</script>
</body>
</html>

