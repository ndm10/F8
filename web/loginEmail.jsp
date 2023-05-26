<%-- 
    Document   : login
    Created on : May 25, 2023, 11:10:30 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="loginPhone.jsp">Đăng nhập với SDT</a>
        <form action="login" method="post">
            <input type="email" name="email" placeholder="Địa chỉ email" required/><br/>
            <input type="password" name="pwd" placeholder="Mật khẩu" required/><br/>
            <input type="hidden" name="action" value="emailLogin"/><br/>
            <div id="msg-Fail" style="color: red">
                <script>
                    var isSuccess = ${isSuccess};
                    if (!isSuccess) {
                        var x = document.getElementById("msg-Fail");
                        x.innerHTML += "Tài khoản hoặc mật khẩu không chính xác";
                    }
                </script>
            </div>
            <br/>
            <button type="submit">Đăng nhập</button>
        </form>
    </body>
</html>

