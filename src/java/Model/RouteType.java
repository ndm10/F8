/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class RouteType {
    private String id;
    private String name;
    private String indexx;

    public RouteType() {
    }

    public RouteType(String id, String name, String indexx) {
        this.id = id;
        this.name = name;
        this.indexx = indexx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndexx() {
        return indexx;
    }

    public void setIndexx(String indexx) {
        this.indexx = indexx;
    }

    @Override
    public String toString() {
        return "RouteType{" + "id=" + id + ", name=" + name + ", indexx=" + indexx + '}';
    }
    
}
