<%@ page import="com.test.java.Item" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-12
  Time: 오전 9:04
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
<h1>주소록</h1>

<!-- list1은 이미 하드코딩된 HTML 데이터 -->
<ul id="list1">
    <li><span>홍길동</span><span>(서울시)</span></li>
    <li><span>강아지</span><span>(부산시)</span></li>
    <li><span>고양이</span><span>(인천시)</span></li>
    <li><span>아무개</span><span>(제주시)</span></li>
    <li><span>김이박</span><span>(광주시)</span></li>
</ul>

<hr>

<!-- list2는 자바스크립트 코드로 동적으로 추가할 데이터 -->
<ul id="list2">

</ul>

<hr>

<!-- list3는 JSP 서버에서 Item.generate()로 생성된 데이터 -->
<ul id="list3">
    <% for(Item item : Item.generate()) { %>
    <li>
        <span><%= item.getName()%></span>
        <span>(<%= item.getAddress()%>)</span>
    </li>
    <% } %>
</ul>

<!-- 자바스크립트 추가 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script>
    // list2에 아이템 데이터를 추가하는 자바스크립트 코드
    $(document).ready(() => {
        const list = [
            {name : "사자", address : "부천시"},
            {name : "토끼", address : "강릉시"},
            {name : "고라니", address : "대전"},
            {name : "호랑이", address : "성남시"},
            {name : "거북이", address : "대구"},
        ];

        $(list).each((index, item) => {
            $('#list2').append(`
                    <li>
                        <span>${item.name}</span>
                        <span>(${item.address})</span>
                    </li>
                `);
        });
    });
</script>
</body>
</html>