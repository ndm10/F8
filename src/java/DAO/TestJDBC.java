/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TestJDBC {

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> listA = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listA.add(new Account(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11),
                        rs.getString(12)));
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return listA;
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path: " + projectPath);
    }
}
