<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-06
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>
        div >a {
            display: block;
            margin-bottom : 5px;

        }
    </style>
</head>
<body>
    <h1>session</h1>

    <div>
        <a href="ex18_set.jsp">세션값 저장하기</a>
        <a href="ex18_del.jsp">세션값 삭제하기</a>
        <a href="ex18_reset.jsp">세션 초기화하기</a>
        <a href="ex18_interval.jsp">세션 만료 시간 초기화하기</a>
    </div>

    <hr>

    <h2>세션 정보</h2>
    <div>Session ID : <%=session.getId()%></div>
    <div>Session CreationTime : <%
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(session.getCreationTime());
        out.print(time.getTime());
    %></div>
    <div>Session Max Inactive Interval : <%=session.getMaxInactiveInterval()%></div>
    <div>Session isNew : <%=session.isNew()%></div>
    <div>Session Data : <%=session.getAttribute("data")%></div>



<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

