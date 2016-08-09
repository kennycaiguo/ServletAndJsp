package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by zhuxinquan on 16-3-10.
 */
public class Message extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("login") == null) {
            resp.sendRedirect("/login.do");
            return ;
        }

        req.setCharacterEncoding("UTF-8");
        String blabla = req.getParameter("blabla");
        if(blabla != null && blabla.length() != 0) {
            if(blabla.length() < 140) {
                String username = (String) req.getSession().getAttribute("login");
                addMessage(username, blabla);
                resp.sendRedirect("member.view");
            }else {
                req.getRequestDispatcher("member.view").forward(req, resp);
            }
        }else {
            resp.sendRedirect("member.view");
        }
    }

    private void addMessage(String username, String blabla) throws IOException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int uid ;
        String sql = "select uid from usersdata where username = ?";
        String sql1 = "insert into message(uid, message, datetime) values (?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                uid = rs.getInt("uid");
                ps = conn.prepareStatement(sql1);
                ps.setInt(1, uid);
                ps.setString(2, blabla);
                long date = new Date().getTime();
                ps.setLong(3, date);
                ps.executeUpdate();
                DBUtils.close(rs, ps, conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

