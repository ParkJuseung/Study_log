<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-05
  Time: 오전 9:46
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
<%
    String txt2 = request.getParameter("txt2");
    String txt3 = request.getParameter("txt3");
    txt3 = txt3.replace("\r\n", "<br>");

    String cb1 = request.getParameter("cb1");

    String cb2 = request.getParameter("cb2");
    String cb3 = request.getParameter("cb3");
    String cb4 = request.getParameter("cb4");

    String temp = "";
    temp += cb2 + ",";
    temp += cb3 + ",";
    temp += cb4 + ",";

    for(int i = 2; i<=4; i++){
        temp += request.getParameter("cb" + i) + ",";
    }

//    String cb5 = request.getParameter("cb5");
//    System.out.println(cb5);

    String[] cb5 = request.getParameterValues("cb5");

    //라디오 버튼
    String rb = request.getParameter("rb");

    String left = request.getParameter("left");
    String top = request.getParameter("top");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>



    <h1>텍스트 박스</h1>
    <div><%=txt2%></div>

    <h1>멀티 텍스트</h1>
    <div><%=txt3%></div>

    <h1>체크 박스</h1>
    <div><%=cb1%></div>

    <h1>체크 박스들</h1>
    <div><%=Arrays.toString(cb5)%></div>

    <h1>라디오 박스 </h1>
    <div><%=rb%></div>

    <h1>현재 고양이 위치  </h1>
    <div><%=left%>, <%=top%></div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script src="https://bit.ly/4cMuheh"></script>
<script>

</script>
</body>
</html>

