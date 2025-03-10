<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-07
  Time: 오후 4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>
    <h1>로그인</h1>

    <form action="ex27_ok.jsp" method="POST">
        <table class="vertical content">
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id" class="short" required></td>
            </tr>
            <tr>
                <th>암호</th>
                <td><input type="password" name="pw" class="short" required></td>
            </tr>
        </table>

        <div>
            <div>
                <label>
                    <input type="checkbox" id="cbRemember" name="cbRemember" value="y">아이디 기억하기
                </label>
            </div>
            <div><input type="submit" value="로그인"></div>
        </div>
    </form>


    <hr>

    <c:if test="${result}">
        <div class="message">인증O</div>
    </c:if>

    <c:if test="${not result}">
    <div class="message"> 인증 x</div>
    </c:if>

    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script src="js/cookie.js"></script>
    <script>

    </script>
</body>
</html>

