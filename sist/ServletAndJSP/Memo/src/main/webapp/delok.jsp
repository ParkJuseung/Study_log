<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.test.java.DBUtil"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //1. 데이터 가져오기
    //1.5 권한 확인
    //2. DB 작업 > 메모 삭제하기(insert)
    //3. 실행 결과 처리

    //1.
    request.setCharacterEncoding("UTF-8");

    String pw   = request.getParameter("pw");
    String seq  = request.getParameter("seq");

    //2.
    DBUtil util = new DBUtil();
    Connection conn = null;
    PreparedStatement stat = null;

    conn = util.open("localhost", "server", "java1234");

    String sql = "update tblMemo set name = ?, memo = ? where seq = ?";
    stat = conn.prepareStatement(sql);

    stat.setString(1, name);
    stat.setString(2, memo);
    stat.setString(3, seq);

    int result = stat.executeUpdate();

    stat.close();
    conn.close();

    if (result == 1) {
        response.sendRedirect("${pageContext.request.contextPath}/list.jsp");
    } else {
        System.out.println("<script>alert('failed'); history.back();</script>");
        System.out.close();
    }

%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Memo</title>
    <%@ include file="/inc/asset.jsp" %>
    <style>

    </style>
</head>
<body>
<!-- editok.jsp -->
<%@ include file="/inc/header.jsp" %>

<h1>Memo <small>수정하기</small></h1>

<script>

</script>
</body>
</html>
















