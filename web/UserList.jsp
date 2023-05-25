<%-- 
    Document   : UserList
    Created on : May 19, 2023, 9:05:32 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <link rel="stylesheet" href="css/header.css"/>
        <!--<link rel="stylesheet" href="css/footer.css"/>-->
        <link rel="stylesheet" href="css/user_list.css"/>

    </head>
    <body style="background-image: url('image/anhnen.png')">
        <jsp:include page="header.jsp"></jsp:include>
            <h2>DANH SÁCH NGƯỜI DÙNG</h2>
            <div class="table-wrapper">

                <table class="fl-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>USER NAME</th>
                            <th>EMAIL</th>
                            <th>URL</th>
                            <th>DATE JOIN</th>
                            <th>ROLE</th>
                            <th>BUTTON</th>
                        </tr>
                    </thead>

                    <tbody>           
                    <c:forEach items="${listAccount}" var="itemAccount">   
                    <form action="account" method="post">

                        <tr>

                        <td id="${itemAccount.getId()}">${itemAccount.getId()}</td> 
                        <input type="text" name="uid" value="${itemAccount.getId()}" readonly="" style="display: none">
                        <td>${itemAccount.getUserName()}</td>
                        <td>${itemAccount.getMail()}</td>
                        <td>${itemAccount.getUrl()}</td>
                        <td>${itemAccount.getRegistrationDate()}</td>
                        <td>
                            <select name="role">
                                <c:forEach items="${listActor}" var="itemActor"> 
                                    <c:choose>
                                        <c:when test="${itemAccount.getRoleID() == itemActor.getId()}">
                                            <option selected value="${itemActor.getId()}">${itemActor.getActor()}</option>                       
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${itemActor.getId()}">${itemActor.getActor()}</option>                       
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td><button type="submit" style="text-decoration: none;color: black">Save</button></td>
                        </tr>
                    </form>
                </c:forEach>

                <tbody>
            </table>
        </div>
        <%--<jsp:include page="footer.jsp"></jsp:include>--%>
    </body>
</html>
