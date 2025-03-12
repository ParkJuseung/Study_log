<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>
    <h1>EL</h1>

    <%
        //자바 변수 (데이터) 출력
        int a = 10;

//
//        //내장 객체
//        pageContext.setAttribute("b", Integer.valueOf(20));
//        request.setAttribute("c", 30);
//        session.setAttribute("d", 40);
    %>

    <h2>표현식</h2>
    <div>a: <%=a%></div>


    <h2>EL</h2>

    <div>a : ${a}</div>
    <div>b : ${b}</div>

    <%
        pageContext.setAttribute("n1", 10);
        pageContext.setAttribute("n2", 20);
    %>


    <h2>기능</h2>

    <div>n1 + 10 = <%= (int)pageContext.getAttribute("n1") + 10 %></div>
    <div>n1 + 10 = ${n1} + 10</div>
    <div>n1 + 10 = ${n1 + 10}</div>

    <div>n1 + n2 = <%= (int)pageContext.getAttribute("n1") + (int)pageContext.getAttribute("n2") %></div>

    <div>n1 + n2 = ${n1 + n2}</div>
    <div>n1 - n2 = ${n1 - n2}</div>
    <div>n1 * n2 = ${n1 * n2}</div>
    <div>n1 / n2 = ${n1 / n2}</div>
    <div>n1 % n2 = ${n1 % n2}</div>

    <hr>

    <div>n1 > n2 = ${n1 > n2}</div>
    <div>n1 &gt; n2 = ${n1 gt n2}</div>

    <div>n1 < n2 = ${n1 < n2}</div>
    <div>n1 &lt n2 = ${n1 lt n2}</div>

    <div>n1 >= n2 = ${n1 >= n2}</div>
    <div>n1 &gt;= n2 = ${n1 ge n2}</div>


    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>

    </script>
</body>
</html>

