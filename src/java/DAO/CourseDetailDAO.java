/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CourseDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CourseDetailDAO {
    public ArrayList<CourseDetail> getAllCourse() {
        ArrayList<CourseDetail> listC = new ArrayList<>();
        String sql = "select * from Course c join CourseDetail cd on c.id = cd.courseID where c.price = 0";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                listC.add(new CourseDetail(rs.getString(1), rs.getString(2), 
                                            Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(3)), 
                                            rs.getString(5), rs.getString(6), rs.getString(7),
                                            Integer.parseInt(rs.getString(8)), rs.getString(9), 
                                            rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println("getAllCourse: "+e.getMessage());
        }
        return listC;
    }
    public ArrayList<CourseDetail> getAllProCourseAndFreeCourse() {
        ArrayList<CourseDetail> listC = new ArrayList<>();
        String sql = "select * from Course c join CourseDetail cd on c.id = cd.courseID";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                listC.add(new CourseDetail(rs.getString(1), rs.getString(2), 
                                            Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(3)), 
                                            rs.getString(5), rs.getString(6), rs.getString(7),
                                            Integer.parseInt(rs.getString(8)), rs.getString(9), 
                                            rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println("getAllCourse: "+e.getMessage());
        }
        return listC;
    }
    public ArrayList<CourseDetail> getAllCourseByTitle(String txt) {
        ArrayList<CourseDetail> listC = new ArrayList<>();
        String sql = "select * from Course c join CourseDetail cd on c.id = cd.courseID where c.title like ?";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            pstm.setString(1, "%"+txt+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                listC.add(new CourseDetail(rs.getString(1), rs.getString(2), 
                                            Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(3)), 
                                            rs.getString(5), rs.getString(6), rs.getString(7),
                                            Integer.parseInt(rs.getString(8)), rs.getString(9), 
                                            rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println("getAllCourse: "+e.getMessage());
        }
        return listC;
    }
    public ArrayList<CourseDetail> getAllProCourse() {
        ArrayList<CourseDetail> listC = new ArrayList<>();
        String sql = "select * from Course c join CourseDetail cd on c.id = cd.courseID where c.price > 0";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                listC.add(new CourseDetail(rs.getString(1), rs.getString(2), 
                                            Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(3)), 
                                            rs.getString(5), rs.getString(6), rs.getString(7),
                                            Integer.parseInt(rs.getString(8)), rs.getString(9), 
                                            rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println("getAllProCourse: "+e.getMessage());
        }
        return listC;
    }
        public ArrayList<CourseDetail> getAllCourseMinus0() {
        ArrayList<CourseDetail> listC = new ArrayList<>();
        String sql = "select * from Course c join CourseDetail cd on c.id = cd.courseID";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                listC.add(new CourseDetail(rs.getString(1), rs.getString(2), 
                                            Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(3)), 
                                            rs.getString(5), rs.getString(6), rs.getString(7),
                                            Integer.parseInt(rs.getString(8)), rs.getString(9), 
                                            rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println("getAllCourse: "+e.getMessage());
        }
        return listC;
    }
    public int getMaxCourseID() {
        int id = 0;
        ArrayList<CourseDetail> listC = getAllCourseMinus0();
        for (CourseDetail courseDetail : listC) {
            int idd = Integer.parseInt(courseDetail.getId());
            if(idd > id) id = idd;
        }
        return id;
    }
    public int getMaxCourseDetailID() {
        int id = 0;
        ArrayList<CourseDetail> listC = getAllCourseMinus0();
        for (CourseDetail courseDetail : listC) {
            int idd = Integer.parseInt(courseDetail.getCourseDetailID());
            if(idd > id) id = idd;
        }
        return id;
    }
    public void insertCourse(CourseDetail courseD) {
        String sql = "insert into Course(id, title, numOfPeopleJoin, price, routeID) Values(?, ?, ?, ?, ?);";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            pstm.setString(1, (getMaxCourseID()+1)+"");
            pstm.setString(2, courseD.getTitle());
            pstm.setString(3, courseD.getNumOfPeopleJoin()+"");
            pstm.setString(4, courseD.getPrice()+"");
            pstm.setString(5, courseD.getRouteID());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("insertCourse: "+e.getMessage());
        }
    }
    public void insertCourseDetail(CourseDetail courseD) {
        String sql = "insert into CourseDetail(id, level, sumLesson, time, detailCourseDes, image, courseID) Values(?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement pstm = DBContext.getConnection().prepareStatement(sql);
            pstm.setString(1, (getMaxCourseDetailID()+1)+"");
            pstm.setString(2, courseD.getLevel());
            pstm.setString(3, 0+"");
            pstm.setString(4, 0+"");
            pstm.setString(5, courseD.getDetailCourseDes());
            pstm.setString(6, courseD.getImage());
            pstm.setString(7, (getMaxCourseID()+1)+"");
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("insertCourseDetail: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        CourseDetailDAO c = new CourseDetailDAO();
        ArrayList<CourseDetail> l = c.getAllCourse();
        for (CourseDetail courseDetail : l) {
            System.out.println(courseDetail);
        }
    }
}
