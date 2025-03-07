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
    <h1>request 객체 사용하기</h1>

    <div><%= request%></div>

    <h2>폼태그 + POST 방식으로 보내기</h2>

    <form method="POST" action="ex09_ok.jsp">
        <div>문자 : <input type="text" name="txt"></div>
        <div>숫자 : <input type="number" name="num"></div>
        <div><input type="submit" value="보내기"></div>
    </form>
    <h2>폼태그 + GET 방식으로 보내기</h2>
    <form method="GET" action="ex09_ok.jsp">
        <div>문자 : <input type="text" name="txt"></div>
        <div>숫자 : <input type="number" name="num"></div>
        <div><input type="submit" value="보내기"></div>
    </form>

    <h2>폼태그 없이 데이터 전송하기 </h2>
    <div>
        <a href="ex09_ok.jsp?txt=hong&num=123">페이지 이동</a>
    </div>
    <div>
        <input type="button" value="클릭" id="btn1">
    </div>

    <h2>get 대량의 데이터</h2>
    <form method="GET" action="ex09_ok.jsp">
        <textarea name="txt2" class="full"></textarea>
        <button>보내기</button>
    </form>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>
    $('#btn1').click(() =>{
        location.href = `ex09_ok.jsp?txt=\${document.getElementById('btn1').value}&num=11`
    })
</script>
</body>
</html>
