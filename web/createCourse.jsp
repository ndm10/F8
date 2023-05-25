<%-- 
    Document   : createCourse
    Created on : 20/05/2023, 10:10:36 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/createCourse.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="create_course">
            <div class="create_course_course">
                <h2 style="color: white;">${error}</h2>
                <h2>Thêm khóa học</h2>
                <form id="myform" action="createCourse" method="post" enctype="multipart/form-data">
                    <div>Tiêu đề: </div><input id="title" type="text" name="title"/><br>
                    <div>Giá: </div><input id="price" type="text" name="price"/><br>
                    <div>Loại lộ trình: </div>
                    <select name="routeType">
                        <option value="1">Front End</option>
                        <option value="2">Back End</option>
                    </select><br>
                    <div>Trình độ: </div>
                    <select name="level">
                        <option value="Easy">Dễ</option>
                        <option value="Medium">Bình thường</option>
                        <option value="Hard">Khó</option>
                        <option value="Super Hard">Siêu khó</option>
                    </select><br>
                    <div>Ảnh: </div><input id="image" type="file" name="image"/><br>
                    <div>Mô tả khóa học: </div><input id="detailCourseDes" type="text" name="detailCourseDes"/><br>
                    <div class="submit">
                        <input type="submit" value="Add"/>
                        <input type="button" value="Reset" onclick="reset()"/>
                    </div>
                </form>
            </div>
        </div>
        
        <script>
            function reset() {
                document.getElementById("myform").reset();
            }
        </script>
    </body>
</html>
