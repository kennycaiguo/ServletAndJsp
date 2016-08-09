package cc.openhome.view;

import cc.openhome.controller.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 登陆成功显示success
 * Created by zhuxinquan on 16-3-6.
 */
public class Member extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("login") ==null) {
            resp.sendRedirect("login.do");
            return;
        }
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = (String) req.getSession().getAttribute("login");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html PUBLIC" +
                "'-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta content='text/html;charset=UTF-8'" +
                "http-euqiv='coneten-type'>");
        out.println("<title>Gossip</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='leftPanel'>");
        out.println("<img src='caterpillar.jpg' alt='Gossip 微网志' /><br><br>");
        out.println("<a href='logout.do?username=" + username + "'>注销" + username + "</a>");
        out.println("</div>");

        //新消息输入框
        out.println("<form method='post' action='message.do'>");
        out.println("分享新鲜事...<br>");
        String blabla = req.getParameter("blabla");
        if(blabla == null) {
            blabla = "";
        }else {
            out.println("140字以内<br>");
        }
        out.println("<textarea cols='60' rows='4' name='blabla'>" +
                blabla + "</textarea>");
        out.println("<br>");
        out.println("<button type='submit'>送出</button>");
        out.println("</form>");


        out.println("<table style='text-align: left; width: 510px; height: 88px;' border='0' cellpadding='2' cellspacing='2'>");
        out.println("<thead>");
        out.println("<tr><th><hr></th></tr>");
        out.println("</thead>");
        out.println("<tbody>");

        //读取历史记录并显示
        Connection conn =  null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn1 = DBUtils.getConnection();
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        //只显示本人的微博
//        String sql = "select uid from usersdata where username=?";
//        String sql1 = "select id, message, datetime from message where uid=? order by datetime desc";
//        int uid = -1;
//        try {
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, username);
//            rs = ps.executeQuery();
//            if(rs.next()){
//                uid = rs.getInt(1);
//            }
//            DBUtils.close(rs, ps, conn);
//            conn = DBUtils.getConnection();
//            ps = conn.prepareStatement(sql1);
//            ps.setInt(1, uid);
//            rs = ps.executeQuery();
//            while(rs.next()) {
//                out.println("<tr><td style='vertical-align:top;'>");
//                out.println(username + "<br>");
//                out.println(rs.getString("message") + "<br>");
//                out.println(new Date((long)rs.getLong("datetime")).toString());
//                out.println("<a href='delete.do?message=" + rs.getInt("id") + "'>删除</a>");
//                out.println("<hr></td></tr>");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String sql = "select username from usersdata where uid=?";
        String sql1 = "select id, uid, message, datetime from message order by datetime desc";
        int uid = -1;
        try {
            conn1 = DBUtils.getConnection();
            ps1 = conn1.prepareStatement(sql);
            String user = null;
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();
            while(rs.next()) {
                uid = rs.getInt("uid");
                ps1 = conn1.prepareStatement(sql);
                ps1.setInt(1, uid);
                rs1 = ps1.executeQuery();
                if(rs1.next()) {
                    user = rs1.getString("username");
                }
                out.println("<tr><td style='vertical-align:top;'>");
                out.println(user + "<br>");
                out.println(rs.getString("message") + "<br>");
                out.println(new Date((long)rs.getLong("datetime")).toString());
                out.println("<a href='delete.do?message=" + rs.getInt("id") + "'>删除</a>");
                out.println("<hr></td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<hr style='width: 100%; height: 1px;'>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
