/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.CourseDetailDAO;
import Model.CourseDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
//String projectPath = System.getProperty("user.dir");
//@MultipartConfig(
//    location = System.getProperty("user.dir") + "/uploads"
//)

@MultipartConfig(
//        location = "D:\\G4_SWP391\\g4\\web\\image",
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class createCourseServlet extends HttpServlet {
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createCourseServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createCourseServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        request.getRequestDispatcher("createCourse.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String imageLocation = getServletContext().getInitParameter("ImageLocation");
//        processRequest(request, response);
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String routeType = request.getParameter("routeType");
        String level = request.getParameter("level");
        String detailCourseDes = request.getParameter("detailCourseDes");
        int pricee = 0;
        if(title.equals("")){
            request.setAttribute("error", "Bạn chưa nhập tiêu đề");
            request.getRequestDispatcher("createCourse.jsp").forward(request, response);
        }
        if(price.equals("")){
            request.setAttribute("error", "Bạn chưa nhập giá");
            request.getRequestDispatcher("createCourse.jsp").forward(request, response);
        }
        try {
            pricee = Integer.parseInt(price);
        } catch (Exception e) {
            request.setAttribute("error", "Giá không phải là 1 chuỗi");
            request.getRequestDispatcher("createCourse.jsp").forward(request, response);
        }
        if(routeType == null){
            request.setAttribute("error", "Bạn chưa nhập lộ trình");
            request.getRequestDispatcher("createCourse.jsp").forward(request, response);
        }
        if(level.equals("")){
            request.setAttribute("error", "Bạn chưa nhập mức độ");
            request.getRequestDispatcher("createCourse.jsp").forward(request, response);
        }
        if(detailCourseDes.equals("")){
            request.setAttribute("error", "Bạn chưa nhập chi tiết khóa học");
            request.getRequestDispatcher("createCourse.jsp").forward(request, response);
        }
        Part part = null;
        try {
            part = request.getPart("image");
            part.write(getFileName(part));
        } catch (Exception e) {
            request.setAttribute("error", "Bạn chưa nhập ảnh");
            request.getRequestDispatcher("createCourse.jsp").forward(request, response);
            System.out.println("Error");
        }
        CourseDetailDAO c = new CourseDetailDAO();
        ArrayList<CourseDetail> listCourse = c.getAllProCourseAndFreeCourse();
        for (CourseDetail courseDetail : listCourse) {
            if(title.equalsIgnoreCase(courseDetail.getTitle())){
                request.setAttribute("error", "Khóa học đã tồn tại");
                request.getRequestDispatcher("createCourse.jsp").forward(request, response);
            }
        }
        CourseDetail course = new CourseDetail(0+"", title, pricee, 0,routeType, 0+"",level, 0, 0+"", detailCourseDes, "./image/"+getFileName(part));
        c.insertCourse(course);
        c.insertCourseDetail(course);
        response.sendRedirect("home");
    }
    
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if(!contentDisposition.contains("filename=")){
            return null;
        }
        int beginIndex = contentDisposition.indexOf("filename=")+10;
        int endIndex = contentDisposition.length() - 1;
        
        return contentDisposition.substring(beginIndex, endIndex);
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
