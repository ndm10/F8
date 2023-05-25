/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;

/**
 *
 * @author HP
 */
@MultipartConfig(
        location = "C:\\Users\\HP\\Desktop\\G4_SWP391\\SWP\\g4\\web\\image",
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Get parameter*/
//        String userId = req.getParameter("uid");
        String userId = "1";

        /* Get data */
        AccountDAO accountDAO = new AccountDAO();
        Account inforUser = accountDAO.getInforUser(userId);
        /* Set data to JSP */
        req.setAttribute("inforUser", inforUser);
        req.getRequestDispatcher("ViewProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDAO accountDAO = new AccountDAO();
        /* Get parameter */
//        String userId = req.getParameter("uid");
        String userId = "1";
        String btnSave = req.getParameter("save");
        /* Check if user click save img */
        Part part = null;
        if (btnSave != null) {
            try {
                part = req.getPart("file");
                part.write(getFileName(part));
            } catch (Exception e) {
                req.setAttribute("error", "Please input image");
                req.getRequestDispatcher("createCourse.jsp").forward(req, resp);
                System.out.println("Error");
            }
            /* Update cover image of user by user id */
            accountDAO.updateCoverImg(userId, "./image/" + getFileName(part));
        }
        /* Back to JSP */
        doGet(req, resp);

    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if (!contentDisposition.contains("filename=")) {
            return null;
        }
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;

        return contentDisposition.substring(beginIndex, endIndex);
    }

}
