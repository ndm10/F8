/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class CourseDetail {
    private String id;
    private String title;
    private int price;
    private int numOfPeopleJoin;
    private String routeID;
    private String courseDetailID;
    private String level;
    private int sumOfLesson;
    private String time;
    private String detailCourseDes;
    private String image;

    public CourseDetail() {
    }

    public CourseDetail(String id, String title, int price, int numOfPeopleJoin, String routeID, String courseDetailID, String level, int sumOfLesson, String time, String detailCourseDes, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.numOfPeopleJoin = numOfPeopleJoin;
        this.routeID = routeID;
        this.courseDetailID = courseDetailID;
        this.level = level;
        this.sumOfLesson = sumOfLesson;
        this.time = time;
        this.detailCourseDes = detailCourseDes;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumOfPeopleJoin() {
        return numOfPeopleJoin;
    }

    public void setNumOfPeopleJoin(int numOfPeopleJoin) {
        this.numOfPeopleJoin = numOfPeopleJoin;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getCourseDetailID() {
        return courseDetailID;
    }

    public void setCourseDetailID(String courseDetailID) {
        this.courseDetailID = courseDetailID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSumOfLesson() {
        return sumOfLesson;
    }

    public void setSumOfLesson(int sumOfLesson) {
        this.sumOfLesson = sumOfLesson;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetailCourseDes() {
        return detailCourseDes;
    }

    public void setDetailCourseDes(String detailCourseDes) {
        this.detailCourseDes = detailCourseDes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CourseDetail{" + "id=" + id + ", title=" + title + ", price=" + price + ", numOfPeopleJoin=" + numOfPeopleJoin + ", routeID=" + routeID + ", courseDetailID=" + courseDetailID + ", level=" + level + ", sumOfLesson=" + sumOfLesson + ", time=" + time + ", detailCourseDes=" + detailCourseDes + ", image=" + image + '}';
    }

    
    
}
