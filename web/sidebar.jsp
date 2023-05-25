<%-- 
    Document   : sidebar
    Created on : 19/05/2023, 5:13:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/base.css">
        <link rel="stylesheet" type="text/css" href="./css/sidebar.css">
        <link rel="stylesheet" href="./font/fontawesome-free-6.4.0-web/fontawesome-free-6.4.0-web/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="sideBar">
            <div class="header_right_task_writeblog">
                <div class="header_right_task_center">
                    <div class="header_right_task_writeblog_icon">
                        <i class="fa-solid fa-plus"></i>
                    </div>
                </div>  
            </div>
            <div class="header_right_task">
                <div class="header_right_task_home" onclick="goBackHome()">
                    <div class="header_right_task_center" style="background-color: <c:if test="${xemthem != null}">white</c:if>">
                        <div style="background-color: <c:if test="${xemthem != null}">white</c:if>">
                            <i class="fa-solid fa-house"></i>
                            <div style="background-color: <c:if test="${xemthem != null}">white</c:if>" class="header_right_task_text">Trang chủ</div>
                        </div>
                    </div>     
                </div>
                <div class="header_right_task_route">
                    <div class="header_right_task_center">
                        <div>
                            <i class="fa-solid fa-road"></i>
                            <div class="header_right_task_text">Lộ trình</div>
                        </div>
                    </div>  
                </div>
                <div class="header_right_task_learn">
                    <div class="header_right_task_center">
                        <div>
                            <i class="fa-solid fa-lightbulb"></i>
                            <div class="header_right_task_text">Học</div>
                        </div>
                    </div>  
                </div>
                <div class="header_right_task_blog">
                    <div class="header_right_task_center">
                        <div>
                            <i class="fa-solid fa-newspaper"></i>
                            <div class="header_right_task_text">Blog</div>
                        </div>
                    </div>  
                </div>
                <div class="header_right_task_course" style="display: none;">
                    <div class="header_right_task_center">
                        <div>
                            <i class="fa-solid fa-circle-plus"></i>
                            <div class="header_right_task_text">Tạo khóa học</div>
                        </div>
                    </div>  
                </div>
            </div>
        </div>
    </body>
    <script>
        function goBackHome() {
            window.location = 'home';
        }
    </script>
</html>
