/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBContext.getConnection;
import Model.Account;
import Model.Setting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author TIEN DAT
 */
public class AccountDAO {

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> listA = new ArrayList<>();
        String sql = "select * from account";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listA.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
            }
        } catch (Exception e) {
            System.out.println("getAllCourse: " + e.getMessage());
        }
        return listA;
    }

    //Khai bao cac thanh phan xu ly DB
    Connection cnn;//Ket noi DB
    Statement stm;//Thuc thi cau lenh sql
    PreparedStatement pstm;
    ResultSet rs;//Luu tru va xu ly du lieu

    public String getPassWordByAccount(String username) {
        try {
            String strSelect = "select * from account where username = ?";
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(strSelect);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String password = rs.getString(3);
                return password;
            }
        } catch (Exception e) {
            System.out.println("getPassWordByAccount" + e.getMessage());
        }
        return "";
    }

    public void update(Account account) {
        String sql = "UPDATE Account SET password = ? WHERE userName = ?";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            pstm.setString(1, account.getPassword());
            pstm.setString(2, account.getUserName());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("update Account: " + e.getMessage());
        }
    }

    /* Dung */
 /* Get list account*/
    public ArrayList<Account> getListAccount() {
        ArrayList<Account> listAccount = new ArrayList<Account>();
        try {
            /* Select list account from Account table */
            String strSelect = "select * from Account";
            pstm = getConnection().prepareStatement(strSelect);
            rs = pstm.executeQuery();
            /* Loop to get data */
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                String bio = rs.getString(5);
                String avatar = rs.getString(6);
                String url = rs.getString(7);
                String verificationCode = "";
                /* Check verfication code is null */
                if (rs.getString(8) != null) {
                    verificationCode = rs.getString(8);
                }
                SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                String joinDate = date.format(rs.getDate(9));
                String firstAndLastName = rs.getString(10);
                String coverImage = rs.getString(11);
                String roleId = String.valueOf(rs.getInt(12));

                /* Add data to list account */
                listAccount.add(new Account(id, userName, password, email, bio,
                        avatar, url, verificationCode, joinDate,
                        firstAndLastName, coverImage, roleId));
            }
        } catch (Exception e) {
            System.out.println("getListAccount: " + e.getMessage());
        }
        return listAccount;
    }

    /*Get list actor */
    public ArrayList<Setting> getListActor() {
        ArrayList<Setting> listActor = new ArrayList<Setting>();
        try {
            /* Select list actor from Setting table */
            String strSelect = "select * from Setting";
            pstm = getConnection().prepareStatement(strSelect);
            rs = pstm.executeQuery();
            /* Loop to get data */
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String actor = rs.getString(2);

                /* Add data to list actor */
                listActor.add(new Setting(id, actor));
            }
        } catch (Exception e) {
            System.out.println("getListActor: " + e.getMessage());

        }
        return listActor;
    }

    /* Update actor by user id */
    public void updateActor(String userId, String roleId) {
        try {
            /* Update role id by user id */
            String strUpdate = "update Account\n"
                    + "set roleID = ?\n"
                    + "where id = ?";
            pstm = getConnection().prepareStatement(strUpdate);
            pstm.setString(1, roleId);
            pstm.setString(2, userId);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("updateActor: " + e.getMessage());
        }
    }

    /* Get information of user by user id */
    public Account getInforUser(String userId) {
        Account inforUser = new Account();
        try {
            String strSelect = "select * from Account where id = ?";
            pstm = getConnection().prepareStatement(strSelect);
            pstm.setString(1, userId);
            rs = pstm.executeQuery();
            /* Loop to get data */
            while (rs.next()) {
                inforUser.setId(String.valueOf(rs.getInt(1)));
                inforUser.setUserName(rs.getString(2));
                inforUser.setPassword(rs.getString(3));
                inforUser.setMail(rs.getString(4));
                inforUser.setBio(rs.getString(5));
                inforUser.setAvatar(rs.getString(6));
                inforUser.setUrl(rs.getString(7));
                inforUser.setVerificationCode("");
                /* Check verfication code is null */
                if (rs.getString(8) != null) {
                    inforUser.setVerificationCode(rs.getString(8));
                }
                /* Format date to dd-MM-yyyy */
                SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                inforUser.setRegistrationDate(date.format(rs.getDate(9)));
                inforUser.setFirstAndLastName(rs.getString(10));
                inforUser.setCoverImage(rs.getString(11));
                inforUser.setRoleID(rs.getString(12));
            }
        } catch (Exception e) {
            System.out.println("getInforUser: " + e.getMessage());

        }
        return inforUser;
    }

    /* Update cover image by usere id */
    public void updateCoverImg(String userId, String urlCoverImg) {
        try {
            String strUpdate = "update Account\n"
                    + " set coverImage = ?\n"
                    + " where id = ?";
            pstm = getConnection().prepareStatement(strUpdate);
            pstm.setString(1, urlCoverImg);
            pstm.setString(2, userId);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("updateCoverImg: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
//        ArrayList<Account> l = a.getAccout();
//            for (Account account : l) {
//                System.out.println(account);
//            }        
        System.out.println(a.checkUserPhone("undefined"));;
//         a.update(new Account("dat310", "1234"));
    }

    //Tri code
    //check mail exist
    public boolean checkUserEmail(String email) {
        try {
            String strSelect = "select * from account "
                    + "where mail=? ";
            pstm = getConnection().prepareStatement(strSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUserEmail:" + e.getMessage());
        }
        return false;
    }

    public void createEmail( String username, String pass,String email) {
        try {
            String strSelect = "insert into account(userName, password, mail)\n"
                    + "Values(?,?,?)";
            pstm = getConnection().prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            pstm.setString(3, email);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("createEmail:" + e.getMessage());
        }
    }
    public void createPhone( String username, String phone) {
        try {
            String strSelect = "insert into account(userName, phone)\n"
                    + "Values(?,?)";
            pstm = getConnection().prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, phone);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("createPhone:" + e.getMessage());
        }
    }

    //Tri code
    //check mail exist
    public boolean checkUserPhone(String phone) {
        try {
            String strSelect = "select * from account "
                    + "where phone=? ";
            pstm = getConnection().prepareStatement(strSelect);
            pstm.setString(1, phone);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUserPhone:" + e.getMessage());
        }
        return false;
    }
}
