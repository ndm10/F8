<%-- 
    Document   : header
    Created on : 14/05/2023, 8:22:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/base.css">
        <link rel="stylesheet" type="text/css" href="./css/header.css">
        <link rel="stylesheet" href="./font/fontawesome-free-6.4.0-web/fontawesome-free-6.4.0-web/css/all.min.css">
        <title>Document</title>
    </head>
    <body>
        <form id="myform" action="searchCourse">
            <div class="header">
                <div class="header_left">
                    <div class="header_left_logo">
                        <a href="/g4/home">
                            <img src="./image/f8_logo.png" alt="F8">
                        </a>
                        <h4 style="display: <c:if test="${xemthem != null}">none</c:if>" class="header_left_logo_text">Học Lập Trình Để Đi Làm</h4>
                        <div style="display: <c:if test="${xemthem == null}">none</c:if>" class="header_left_logo_back" onclick="goBackHome()">
                                <i class="fa-solid fa-angle-left"></i>
                                <div>QUAY LẠI</div>
                            </div>
                        </div>
                        <div style="display: <c:if test="${xemthem != null}">none</c:if>" class="header_left_search">
                            <div id="ipfc" class="header_left_search_wrap">
                                <div class="header_left_search_icon">
                                </div>
                                <input name="searchtxt" class="header_left_search_input" spellcheck="false" placeholder="Tìm kiếm khóa học, bài viết, video, ..." value="${txt}" onfocus="inputFocus()" onblur="inputBlur()" onkeydown="search(e)">
                        </div>
                        <div class="header_left_search_popup">
                            <c:if test="${listCourseDetailTitle != null}">
                                <div class="header_left_search_popup_wrap">
                                    <div class="header_left_search_popup_result">
                                        <i class="fa-solid fa-magnifying-glass"></i>
                                        <div>
                                            <c:if test="${empty listCourseDetailTitle}">
                                                Không có kết quả cho '${txt}'
                                            </c:if>
                                            <c:if test="${!empty listCourseDetailTitle}">
                                                Kết quả cho '${txt}'
                                            </c:if>
                                        </div>
                                    </div>
                                    <c:if test="${!empty listCourseDetailTitle}">
                                        <div class="header_left_search_popup_head">
                                            <div>KHÓA HỌC</div>
                                            <div onclick="moreDetail()">Xem thêm</div>
                                        </div>
                                    </c:if>

                                    <div class="header_left_search_popup_content">
                                        <c:forEach items="${listCourseDetailTitle}" var="c">
                                            <div class="header_left_search_popup_content_course">
                                                <img src="${c.image}" alt="F8">
                                                <div>${c.title}</div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="header_right_register" style="display: none">
                        <div class="header_right_register_login">
                            <span>ĐĂNG NHẬP</span>
                        </div>
                        <div class="header_right_register_register" onclick="redirect_register()">
                            <span>ĐĂNG KÝ</span>
                        </div>
                    </div>
                    <div class="header_right_login">
                        <div class="my_course_wrap">
                            <h4 onclick="mycoursePopup()">Khóa học của tôi</h4>
                            <div class="my_course_wrap_popup" style="display: none">
                                <div class="my_course_wrap_popup_wrap">
                                    <div class="my_course_wrap_popup_wrap_head">
                                        <div>Khóa học của tôi</div>
                                        <div>Xem tất cả</div>
                                    </div>
                                    <div class="my_course_wrap_popup_wrap_content">
                                        <div>Bạn chưa đăng ký khóa học nào</div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="bell_wrap">
                            <div><i class="fa-solid fa-bell" onclick="rellPopup()"></i></div>
                            <div class="bell_wrap_popup" style="display: none">
                                <div class="bell_wrap_popup_wrap">
                                    <div class="bell_wrap_popup_wrap_head">
                                        <div>Thông báo</div>
                                    </div>
                                    <div class="bell_wrap_popup_wrap_content">
                                        <div>Chưa có thông báo nào</div>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div class="header_right_login_logo_wrap">
                            <img src="./image/mylogo.jpg" class="header_right_login_logo" onclick="showPopupAvatar()"/>
                            <div class="header_right_login_logo_popup">
                                <div class="header_right_login_logo_popup_content" style="display: none">
                                    <div class="header_right_login_logo_popup_logo">
                                        <img src="./image/mylogo.jpg" class="header_right_login_logo"/>
                                        <div>
                                            <div>Đại Còi Vlogs</div>
                                            <div>@daicoivlogs</div>
                                        </div>
                                    </div><hr>
                                    <div class="header_right_login_logo_popup_detail">
                                        <div>Trang cá nhân</div><hr>
                                        <div>Viết blog</div>
                                        <div>Bài viết của tôi</div><hr>
                                        <div>Bài viết đã lưu</div>
                                        <div>Danh sách người dùng</div><hr>
                                        <div>Cài đặt</div>
                                        <div onclick="changePassword()">Thay đổi mật khẩu</div>
                                        <div>Đăng xuất</div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <script>
            function changePassword() {
                window.location.href = "/g4/changePassword.jsp";
            }
            function inputFocus() {
                document.getElementById("ipfc").style.border = 'solid 2px #444444'
            }
            function inputBlur() {
                document.getElementById("ipfc").style.border = '2px solid #e8e8e8'
            }
            function showPopupAvatar() {
                var popLogo = document.querySelector(".header_right_login_logo_popup_content");
                var popRell = document.querySelector(".bell_wrap_popup");
                var popMyCourse = document.querySelector(".my_course_wrap_popup");
                if (popLogo.style.display === "none") {
                    popLogo.style.display = "block";
                    popRell.style.display = "none";
                    popMyCourse.style.display = "none";
                } else {
                    popLogo.style.display = "none";
                }
            }
            function rellPopup() {
                var popLogo = document.querySelector(".header_right_login_logo_popup_content");
                var popRell = document.querySelector(".bell_wrap_popup");
                var popMyCourse = document.querySelector(".my_course_wrap_popup");
                if (popRell.style.display === "none") {
                    popRell.style.display = "block";
                    popLogo.style.display = "none";
                    popMyCourse.style.display = "none";
                } else {
                    popRell.style.display = "none";
                }
            }
            function mycoursePopup() {
                var popLogo = document.querySelector(".header_right_login_logo_popup_content");
                var popRell = document.querySelector(".bell_wrap_popup");
                var popMyCourse = document.querySelector(".my_course_wrap_popup");
                if (popMyCourse.style.display === "none") {
                    popMyCourse.style.display = "block";
                    popLogo.style.display = "none";
                    popRell.style.display = "none";
                } else {
                    popMyCourse.style.display = "none";
                }
            }
            function search(e) {
                if (event.key === 'Enter') {
                    document.getElementById("myform").submit();
                }
            }
            window.addEventListener('click', function (e) {
                document.querySelector(".header_left_search_popup").style.display = 'none';
            });
            function moreDetail() {
                var form = document.getElementById("myform");
                form.method = 'post';
                form.submit();
            }
            function goBackHome() {
                window.location = 'home';
            }
            function redirect_register() {
                window.location.href = "/g4/registerPhone.jsp";
            }
        </script>
    </body>
</html>
