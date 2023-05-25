/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import Model.Account;
import Model.Setting;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class AccountController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Get list account */
        AccountDAO accountDAO = new AccountDAO();
        ArrayList<Account> listAccount = accountDAO.getListAccount();
        /* Get list actor */
        ArrayList<Setting> listActor = accountDAO.getListActor();
        
        /* Set data to JSP */
        req.setAttribute("listAccount", listAccount);
        req.setAttribute("listActor", listActor);
        req.getRequestDispatcher("UserList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Get user id and role id to update */
        String userId = req.getParameter("uid");
        String roleId = req.getParameter("role");
        
        /* Update actor by user id */
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.updateActor(userId, roleId);
        
        /* Back to UserList.jsp */
        doGet(req, resp);
    }
    
    
    
}
