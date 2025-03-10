<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.jsptest.Student" %>
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-07
  Time: 오전 9:06
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


    <%
        HashMap<String, String> map = new HashMap<>();

        map.put("name", "홍길동");
        map.put("age", "20");
        map.put("address", "서울시");

        pageContext.setAttribute("map", map);
    %>

    <h3>객체 멤버 접근</h3>

    <div>이름 : <%= map.get("name")%></div>
    <div>나이 : <%= map.get("age")%></div>
    <div>주소 : <%= map.get("address")%></div>

    <div>${map}</div>
    <div>${map.get("name")}</div>
    <div>${map.["name"]}</div>
    <div>${map.name}</div>

    <%
        Student s1 =new Student();

        s1.setName("아무개");
        s1.setAge(21);
        s1.setAddress("서울시");

        pageContext.setAttribute("s1", s1);
    %>

    <div>이름 : <%=s1.getName()%></div>
    <div>나이 : <%=s1.getAge()%></div>
    <div>주소 : <%=s1.getAddress()%></div>

    <div>이름 : ${s1.getName()}</div>
<%--    <div>나이 : ${s1["age"]}</div>--%>
    <div>주소 : ${s1.address}</div>

    <%
        Student s2 = null;
        pageContext.setAttribute("s2", s2);

        String s3 = "";
        pageContext.setAttribute("s3", s3);

    %>

    <div>${s2 == null}</div>
    <div>${s2 == null}</div>

    <div>${empty s2}</div>
    <div>${empty s3}</div>

    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>

    </script>
</body>
</html>

