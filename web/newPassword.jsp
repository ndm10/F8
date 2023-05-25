<%-- 
    Document   : newPassword
    Created on : May 24, 2023, 5:36:38 PM
    Author     : TIEN DAT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="newPassword" method="post">
       <div>Mật khẩu mới*</div> 
            <input class="input" type="password" name="newPassword" pattern=".{6,}[!@#$%^&*(),.?:{}|<>] required" > <br>
                  <div style="    font-weight: normal;font-size: 13px ;font-family: 'Montserrat',Arial,Helvetica,sans-serif" >Gợi ý: Mật khẩu cần có ít nhất 6 kí tự chữ số và 1 kí tự đặc biệt</div>

        <br>
   
            <div >Xác nhận mật khẩu mới*</div>
            <input class="input" type="password" name="confirmNewPassword"> <br>
            ${error2}
            <br>
            <input style="cursor: pointer" type="submit" name="changPassword" value="Đổi mật khẩu">
             </form>
    </body>
</html>
