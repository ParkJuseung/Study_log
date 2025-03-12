<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-12
  Time: 오후 3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

        #tbl1 td:nth-child(1) {
            width: 30px;
            text-align: center;
            vertical-align: middle;
            font-size: 0;
        }

        #tbl1 td:nth-child(2) {
            cursor: pointer;
        }

        #tbl1 td:nth-child(2) > span {
            font-size: 12px;
            color: #999;

        }

        #tbl2 td:nth-child(1){
            width : 363px;
        }

        #tbl2 td:nth-child(2){

        }

    </style>
</head>
<body class="narrow">
    <h1 class="main">Todo List</h1>

    ${list}

    <table id="tbl1">
        <c:forEach items="${list}">
        <tr>
            <td><input type="checkbox"> </td>
            <td>컴퓨터 포맷하기 <span>2025-03-12 16:20:30</span></td>
        </tr>
        </c:forEach>
        <tr>
            <td><input type="checkbox"> </td>
            <td>컴퓨터 포맷하기 <span>2025-03-12 16:20:30</span></td>
        </tr>
        <tr>
            <td><input type="checkbox"> </td>
            <td>컴퓨터 포맷하기 <span>2025-03-12 16:20:30</span></td>
        </tr>
        <tr>
            <td><input type="checkbox"> </td>
            <td>컴퓨터 포맷하기 <span>2025-03-12 16:20:30</span></td>
        </tr>
        <tr>
            <td><input type="checkbox"> </td>
            <td>컴퓨터 포맷하기 <span>2025-03-12 16:20:30</span></td>
        </tr>
    </table>

    <hr>

    <form action="/todo/addok.do" method="POST">

        <table id="tbl2">
            <tr>
                <td><input type="text" name="todo" class="long" required></td>
                <td><input type="submit" value="등록하기"></td>
            </tr>

        </table>

    </form>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

