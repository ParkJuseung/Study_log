<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-07
  Time: 오후 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String cbRemember = request.getParameter("cbRemember");

    if ((id.equals("hong")) && pw.equals("1234") || (id.equals("test")) && pw.equals("1234")) {
        //로그인 성공
        session.setAttribute("result", true);
        if(cbRemember != null && cbRemember.equals("y")){
            Cookie cookie = new Cookie("id", id);

            cookie.setMaxAge(365 * 24 * 60 * 60);

            //서버에서 생성한 쿠키 객체 > 전달 > 클라이언트
            response.addCookie(cookie);
        }
    }else {
        //로그인 실패
        session.setAttribute("result", false);
    }

    response.sendRedirect("ex27_cookie.jsp");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
    <style>

    </style>
</head>
<body>


    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script src="js/cookie.js"></script>
    <script>

        //처음 방문
        $('input[name="id"]').focus();

        if(getCookie('id')){
            //저장된 아이디 존재
            $('input[name="id"]').val(getCookie('id')));
            $('input[name="pw"]').focus();
            $('input[name="pw"]').prop('checked, true');
        }else{
            //기억했던 아이디를 지우기 -> 쿠키 삭제
            Cookie[] cookies = request.getCookies();

            for(int i = 0; i<cookies.length; i++){
                if (cookies[i].getName.equals("id")) {
                    cookies[i].setMaxAge(-1);
                }
            }
        }
    </script>
</body>
</html>

