package model;

import controller.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhuxinquan on 16-8-10.
 */
public class UserService {
    public List<Blah> getBlahs(Blah blah){
        List<Blah> blahs = new ArrayList<Blah>();


        return blahs;
    }

    public List<Blah> readMessage(String username){
        List<Blah> list = new ArrayList<Blah>();
        Blah blah = null;
        String sql = "select message.id, username, message.uid, message, datetime from " +
                "message, usersdata where message.uid = usersdata.uid order by datetime desc";
        Connection conn =  null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtils.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                blah = new Blah();
                blah.setId(rs.getInt("message.id"));
                blah.setUsername(rs.getString("username"));
                blah.setDate(new Date(rs.getLong("datetime")));
                blah.setTxt(rs.getString("message"));
                list.add(blah);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addBlah(Blah blah){
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int uid ;
        String sql = "select uid from usersdata where username = ?";
        String sql1 = "insert into message(uid, message, datetime) values (?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, blah.getUsername());
            rs = ps.executeQuery();
            if(rs.next()){
                uid = rs.getInt("uid");
                ps = conn.prepareStatement(sql1);
                ps.setInt(1, uid);
                ps.setString(2, blah.getTxt());
                long date = new Date().getTime();
                ps.setLong(3, date);
                ps.executeUpdate();
                DBUtils.close(rs, ps, conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBlah(Blah blah){

    }
}
