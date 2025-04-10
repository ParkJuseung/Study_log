<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        fieldset {
            width: 250px;
            margin: 1rem;
        }

        fieldset > input {
            height: 35px;
            display: block;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<h1>첫번째 페이지</h1>
<div>
    <a href="ex26_cookie_1.jsp">첫번째 페이지</a>
    <a href="ex26_cookie_2.jsp">두번째 페이지</a>
    <a href="ex26_cookie_3.jsp">세번째 페이지</a>
</div>

<fieldset>
    <legend>Site options</legend>
    <input type="color" id="color">
    <input type="button" value="테마 적용하기" id="btnApply">
    <input type="button" value="테마 삭제하기" id="btnClear">
</fieldset>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="js/cookie.js"></script>

<script>
    if(getCookie('color') != ''){
        $('body').css('background-color', getCookie('color'));
        $('color').val(getCookie('color'));
    }

    $('#btnApply').click(() => {
        const color = $('#color').val();
        $('body').css('background-color', color); // 현재 페이지에 바로 적용
        setCookie("color", color, 7); // 7일 동안 유효한 쿠키 저장
    });

    $('#btnClear').click(() => {
        $('body').css('background-color', ''); // 초기화
        setCookie("color", "", -1); // 쿠키 삭제
    });

    // 페이지 로드 시 저장된 쿠키 색상 적용
    const savedColor = getCookie("color");
    if (savedColor) {
        $('body').css('background-color', savedColor);
    }
</script>

</body>
</html>