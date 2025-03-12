<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-11
  Time: 오전 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%



%>

<html>
<head>
    <title>Memo</title>
    <%@ include file ="/inc/asset.jsp" %>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>
<%@ include file="/inc/header.jsp"%>

<h1>Memo <small>목록보기</small></h1>

<div id="list">
    <div class="item">
        <div>메모입니다.</div>
        <div>
            <span>홍길동</span> / <span> 2025-03-01 12:33:00</span>
        </div>
        <div>
            <button type="button" class="edit" onclick="">수정하기</button>
            <button type="button" class="del" onclick="">삭제하기</button>
        </div>
    </div>
</div>
<script>

</script>
</body>
</html>

