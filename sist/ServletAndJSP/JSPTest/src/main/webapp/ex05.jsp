<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = "홍길동";
    int age = 20;
    String color = "cornflowerblue";
    String css = "font-size: 3rem";
    String tag = "<input type='text'>";
%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    h1{
        color : <%= color %>
    }

    div{
        <%=css %>
    }
</style>
<body>
    <h1>스크립틀릿 + 표현식</h1>

    <div>이름 : <%=name%></div>
    <div>나이 : <%=age%></div>

    <div style="background-color: <%=color%>;"><%=color%></div>

    <script>
        window.onclick = function(){
            alert('<%= name %>');
        }
    </script>
</body>
</html>
