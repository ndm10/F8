<%-- 
    Document   : loginPhone
    Created on : May 26, 2023, 12:06:21 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="loginEmail.jsp">Đăng nhập với email</a>
        <form action="login" method="post">
            <input id="inputPhone" type="text" name="phone" placeholder="Số điện thoại" 
                   maxlength="10" onkeydown="validateNumber(event)" onchange="validatePhone()" required/><br/>
            <input type="text" name="verifyCode" placeholder="Nhập mã xác nhận" required/>
            <button id="btnSend" disabled>Gửi mã</button><br/>
            <input type="hidden" name="action" value="phoneLogin"/><br/>
            <div id="msg-Fail" style="color: red">
                <script>
                    var isSuccess = ${isSuccess};
                    if (!isSuccess) {
                        var x = document.getElementById("msg-Fail");
                        x.innerHTML += "Mã xác nhận không chính xác";
                    }
                </script>
            </div>
            <br/>
            <button id="btn-login" type="submit" disabled>Đăng nhập</button>
        </form>
    </body>
    <script>
        //cho phep nhap only so
        function validateNumber(event) {
            var keyCode = event.keyCode || event.which;
            var keyValue = String.fromCharCode(keyCode);
            // Allow Backspace (keyCode 8) to work even at maximum length
            if (keyCode === 8) {
                return;
            }
            // Only allow digits (0-9)
            var validDigits = /^[0-9]+$/;
            if (!validDigits.test(keyValue) || event.target.value.length >= 10) {
                event.preventDefault();
            }
        }
        //kiem tra dien thoai du 10 so chua
        function validatePhone() {
            var input = document.getElementById('inputPhone');
            var button = document.getElementById('btnSend');
            button.disabled = input.value.length !== 10;
        }
    </script>
</html>
