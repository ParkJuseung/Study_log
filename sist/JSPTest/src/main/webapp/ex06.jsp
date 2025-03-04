<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Oracle -> select -> 회원 정보
    ArrayList<String> names = new ArrayList<>();

    names.add("홍길동");
    names.add("아무개");
    names.add("강아지");
    names.add("고양이");
    names.add("호랑이");

%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #tbl1{
        border : 1px solid black;
        border-collapse: collapse;
    }
    #tbl1 th, #tbl1 td{
        border : 1px solid black;
        padding : 5px;
    }
</style>
<body>
    <h1>회원 목록</h1>

    <table id="tbl1">
        <tr>
            <th>번호</th>
            <th>이름</th>
        </tr>
        <% for(int i=0; i<names.size(); i++){ %>
        <tr>
            <td><%= i+1 %></td>
            <td onclick="info('<%= names.get(i)%>')"><%= names.get(i)%></td>
        </tr>
        <% }%>
    </table>
    <hr>
    <div id="div1">선택된 회원 : <span>강아지</span></div>

    <script>
        function info(){
            document.querySelector('#div1 > span').textContent = name;
        }
    </script>
</body>
</html>
