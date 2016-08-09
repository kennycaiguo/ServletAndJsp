package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhuxinquan on 16-3-6.
 */
public class Login extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;chatset=utf-8");
        String username = req.getParameter("username");
        String passwd = req.getParameter("passwd");
        String page = "/index.html";
        //验证用户名密码
        if(checkLogin(username, passwd)) {
//            req.getRequestDispatcher("member.view").forward(req, resp);
            req.getSession().setAttribute("login", username);
            page = "member.view";
        }
        resp.sendRedirect(page);
    }

    private boolean checkLogin(String username, String passwd) throws IOException {
        if(username != null && passwd != null) {
            try {
                String md5Passwd = MD5Util.md5Encode(passwd);
                String sql = "select username, passwd, email from usersdata where username=?";
                conn = DBUtils.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
                String sqlPasswd = null;
                if(rs.next()) {
                    sqlPasswd = rs.getString(2);
//                    System.out.println(sqlPasswd + "/" + passwd);
                    if(sqlPasswd.equals(md5Passwd)) {
                        DBUtils.close(rs, ps, conn);
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtils.close(rs, ps, conn);
            }
        }
        return false;
    }
}
