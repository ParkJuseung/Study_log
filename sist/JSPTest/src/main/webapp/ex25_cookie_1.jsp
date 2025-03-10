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
    <h1>쿠키<small>Javascript</small></h1>

    <div>
        <input type="button" value="쿠키에 데이터 저장" id="btn1">
        <input type="button" value="쿠키에 있는 데이터 읽기" id="btn2">
    </div>
    <div><%=session.getId()%></div>

    <hr>

    <div><a href="ex25_cookie_2.jsp">두번째 페이지</a></div>


<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
    <script src="js/cookie.js"></script>
<script>
    $('#btn1').click(() => {
        //쿠키 쓰기
        // console.log(document.cookie);
        //
        // console.log(typeof document.cookie); // string
        //
        // document.cookie = 'hong';
        // document.cookie = 'name=홍길동$kor=100&eng=900&math=80'

        setCookie('name', '홍길동');
        setCookie('kor', 100);
        setCookie('eng', 80);
        setCookie('math', 90);
    })

    $('#btn2').click(()=>{
        // console.log(document.cookie);
        console.log(getCookie('name'))
    })
</script>
</body>
</html>

