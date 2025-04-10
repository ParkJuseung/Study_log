<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-05
  Time: 오전 9:46
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025-03-04
  Time: 오후 5:17
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
    <h1>폼 입력 태그 </h1>
    <form action="ex10_ok.jsp" method="post">
        <table class="vertical">
            <tr>
                <th></th>
                <td></td>
            </tr>
            <tr>
                <th>암호 상자</th>
                <td><input type="password" name="txt2"></td>
            </tr>
            <tr>
                <th>멀티 텍스트</th>
                <td><textarea name="txt3"></textarea> </td>
            </tr>
            <tr>
                <th>체크 박스</th>
                <td><input type="checkbox" name="cb1" value="java"></td>
            </tr>
            <tr>
                <th>check boxs</th>
                <td>
                    <h3>취미를 선택하세요</h3>
                    <label><input type="checkbox" name="cb5" value="독서">독서</label>
                    <label><input type="checkbox" name="cb5" value="운동">운동</label>
                    <label><input type="checkbox" name="cb5" value="코딩">코딩</label>
                </td>
            </tr>
            <tr>
                <th>셀렉트 박스</th>
                <td>
                    <h4>성별을 선택하세요</h4>
                    <label><input type="radio" name="rb" value="male" checked>남자</label>
                    <label><input type="radio" name="rb" value="female">여자</label>
                </td>
            </tr>
            <tr>
                <th></th>
                <td></td>
            </tr>
            <tr>
                <th></th>
                <td></td>
            </tr>
            <tr>
                <th></th>
                <td></td>
            </tr>
            <tr>
                <th>사용자 정의 컨트롤(Javascript, Jquery.. )</th>
                <td>
                    <img src=images/catty01.png id="cat1">
                </td>
            </tr>

        </table>
        <div>
            <button>보내기</button>
        </div>

        <input type="hidden" name="left">
        <input type="hidden" name="top">
    </form>


    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js" integrity="sha256-9zljDKpE/mQxmaR4V2cGVaQ7arF3CcXxarvgr7Sj8Uc=" crossorigin="anonymous"></script>
    <script src="https://bit.ly/4cMuheh"></script>
    <script>
        $('#cat1').draggable({
            stop : function (event, ui){
                $('input[name=left]').val(ui.position.left);
                $('input[name=top]').val(ui.position.top);
            }
        });
    </script>
</body>
</html>

/