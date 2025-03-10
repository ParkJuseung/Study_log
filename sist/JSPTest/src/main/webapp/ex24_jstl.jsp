<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://example.com/path/to/styles.css">
    <style>
        /* 스타일 선언 */
    </style>
</head>
<body>
<h1>JSTL</h1>

<h2>변수 선언</h2>

<!-- JSTL을 사용한 변수 선언 -->
<%--<c:set var="a" value="10" />--%>
<%--<c:set var="b" value="20" />--%>
<%--<c:set var="c" value="30" />--%>

<%--<!-- 변수 출력 -->--%>
<%--<div>a: ${a}</div>--%>
<%--<div>b: ${b}</div>--%>
<%--<div>c: ${c}</div>--%>
    <h2>조건문</h2>
    <c:set var="num" value="10" />
    <c:if test="${num > 0}">
        <div>${num}은 양수입니다.</div>
    </c:if>



<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://example.com/path/to/script.js"></script>
</body>
</html>