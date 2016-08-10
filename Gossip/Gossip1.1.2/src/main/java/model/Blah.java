package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuxinquan on 16-8-10.
 */
public class Blah implements Serializable{
    private int id;
    private String username;
    private Date date;
    private String txt;

    public Blah() {
    }

    public Blah(String username, Date date, String txt) {
        this.username = username;
        this.date = date;
        this.txt = txt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
