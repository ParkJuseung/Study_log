<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오전 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //세션에 데이터 추가하기
    session.setAttribute("a", 10); // 세션 변수
    application.setAttribute("b",20); // 어플리케이션 변수

    //방문 카운트
    if(session.getAttribute("count") == null){
        session.setAttribute("count", 1);
    }else{
        session.setAttribute("count", (int)session.getAttribute("count") + 1);
    }

    //방문 카운트
    if(application.getAttribute("count") == null){
        application.setAttribute("count", 1);
    }else{
        application.setAttribute("count", (int)application.getAttribute("count") + 1);
    }



%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>
    <h1>Session</h1>

    <div>a : <%= session.getAttribute("a")%></div>
    <div>b : <%= application.getAttribute("b")%></div>

    <div>count : <%= session.getAttribute("count")%></div>
    <div>count : <%= application.getAttribute("count")%></div>

    <div>
        <a href="ex17_session_2.jsp">다른 페이지로 이동</a>
    </div>



<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

