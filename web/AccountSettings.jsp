<%-- 
    Document   : AccountSettings
    Created on : May 17, 2023, 8:40:30 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thiết lập về tôi tại F8</title>
        <!--Css-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/settings.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
            <!--Content-->
            <div class="content">
                <!--Content left-->
                <div class="content_left">
                    <h1>Cài đặt</h1> <br>
                    <h2> <a href="AccountSettings.jsp"><i class='bx bx-user'></i> Cài đặt tài khoản </a></h2>
                    <h2> <a href="#"> <ion-icon name="shield-half-outline"></ion-icon> Bảo mật và đăng nhập </a></h2>
                    <h2> <a href="#"> <i class='bx bx-bell'></i> Thông báo </a></h2>
                </div>
                <!--Content right-->
                <form action="action">
                    <div class="content_right">
                        <div>     
                            <h1>Thông tin cá nhân </h1>
                        </div>
                        <hr><br>
                        <h2>Họ tên</h2>
                        <input type="text" name="full_name" class="input_infor" maxlength="50" placeholder="Thêm tên của bạn" value="Dinh Tien Dung (K16_HL)" required="" >
                        <p>Tên của bạn xuất hiện trên trang cá nhân và bên cạnh các bình luận của bạn.</p> <br>
                        <h2>Bio</h2>
                        <input type="text" name="bio" class="input_infor" maxlength="100" placeholder="Thêm giới thiệu" value="" >
                        <p>Bio hiển thị trên trang cá nhân và trong các bài viết (blog) của bạn.</p> <br>
                        <div class="avatar">
                            <div>
                                <h2>Avatar</h2>
                                <p>Nên là ảnh vuông, chấp nhận các tệp: JPG, PNG hoặc GIF.</p>
                            </div>
                            <div>
                                <img id="image" src="image/f8_logo.png" height="50px">
                                <!--Button change avatar-->
                                <input type="file" name="file" id="file" class="input_img" value="">
                                <label for="file" ><i class='bx bxs-camera'></i> Change</label>
                            </div>
                        </div> <br>
                        <h2>Email</h2>
                        <input type="text" name="email" class="input_infor" readonly="" value="dungdthe163862@fpt.edu.vn">
                        <br>
                        <h2>User Name</h2>
                        <input type="text" name="username" class="input_infor" readonly="" value="dinhtiendungk16hl"> 
                        <br>
                        <!--URL of User-->
                        <p><b>URL:</b>https://fullstack.edu.vn/@dinhtiendungk16hl</p> <br>
                        <h2>Số điện thoại</h2>
                        <input type="text" name="phone_number" class="input_infor" value="" placeholder="Thêm số điện thoại" readonly="">
                        <br>
                        <p>Điện thoại liên kết với F8</p>
                        <button type="submit" class="btn">Save</button>
                    </div>
                </form>
            </div>




            <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="js/profile.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    </body>
</html>
