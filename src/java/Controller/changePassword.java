/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.DBContext;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TIEN DAT
 */
public class changePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changePassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changePassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         AccountDAO a = new AccountDAO();
        // Lấy thông tin cần thiết từ form
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

//            1. ten nguoi dung gui tu jsp ve .
        String username = "dat310";
        String password = a.getPassWordByAccount(username);

//            2. check oldpassword trung password co ten gui ve tu jsp
        if(!password.trim().equals(oldPassword.trim())) {
            request.setAttribute("error1", "Không đúng mật khẩu");
            request.setAttribute("oldPassword", oldPassword);
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
        else {
            request.setAttribute("oldPassword", oldPassword);
        
            
            //3. check new password == confirmNewPassword 
            if(!newPassword.equals(confirmNewPassword)) {
                request.setAttribute("error2", "Mật khẩu xác thực sai");
                request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            }
            else {
                  a.update(new Account(username, newPassword));
//                  request.getRequestDispatcher("home").forward(request, response);
                    response.sendRedirect("home");
            }
        }
        //     4. goi ham update --> changepassword
          
          
        //            // Kiểm tra tính hợp lệ của dữ liệu
        //            if (!isValid(oldPassword, newPassword, confirmNewPassword)) {
        //                request.setAttribute("errorMessage", "Thông tin không hợp lệ");
        //                request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
        //                return;
        //            }
        //
        //            // Thực hiện đổi mật khẩu cho người dùng
        //            String username = request.getSession().getAttribute("username").toString();
        //            if (!changePassword(username, oldPassword, newPassword)) {
        //                request.setAttribute("errorMessage", "Đổi mật khẩu không thành công");
        //                request.getRequestDispatcher("/changepassword.jsp").forward(request, response);
        //                return;
        //            }
        //
        //            // Điều hướng người dùng về trang chủ hoặc trang thông báo kết quả
        //            response.sendRedirect(request.getContextPath() + "/changepassword.jsp");
        //        }
        //
        //        private boolean isValid(String oldPassword, String newPassword, String confirmNewPassword) {
        //            // TODO: Kiểm tra tính hợp lệ của dữ liệu
        //            return true;
        //        }
        //
        //        private boolean changePassword(String username, String oldPassword, String newPassword) {
        //            // Lấy kết nối đến cơ sở dữ liệu
        //            Connection connection = DBContext.getConnection();
        //
        //            try {
        //                // Kiểm tra tính hợp lệ của mật khẩu hiện tại
        //                PreparedStatement checkPasswordStatement = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
        //                checkPasswordStatement.setString(1, username);
        //                checkPasswordStatement.setString(2, oldPassword);
        //                ResultSet resultSet = checkPasswordStatement.executeQuery();
        //                if (!resultSet.next()) {
        //                    return false;
        //                }
        //
        //                // Thực hiện đổi mật khẩu mới
        //                PreparedStatement updatePasswordStatement = connection.prepareStatement("UPDATE users SET password=? WHERE username=?");
        //                updatePasswordStatement.setString(1, newPassword);
        //                updatePasswordStatement.setString(2, username);
        //                updatePasswordStatement.executeUpdate();
        //            } catch (SQLException e) {
        //                e.printStackTrace();
        //                return false;
        //            } finally {
        //                // Đóng kết nối sau khi thực hiện xong
        //                try {
        //                    connection.close();
        //                } catch (SQLException e) {
        //                    e.printStackTrace();
        //                }
        //            }
//        {
//            return true;
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
