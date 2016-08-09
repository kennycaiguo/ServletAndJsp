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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-3-6.
 */
//@WebServlet("/register.do")
public class Register extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
//        System.out.println(username);
        String passwd = req.getParameter("passwd");
        String confirmedPasswd = req.getParameter("confirmedPasswd");
        List<String> errors = new ArrayList<>();
        if(isInvalidEmail(email)) {
            errors.add("邮件格式不正确");
        }
        if(isInvalidUsername(username)) {
            errors.add("用户名为空或已存在");
        }
        if(isInvalidPasswd(passwd, confirmedPasswd)) {
            errors.add("请确认密码符合格式并确保两次输入的密码相同");
        }
        String resultPage = "error.view";
        if(!errors.isEmpty()) {
            //如果注册信息有错误，则设置错误参数
            req.setAttribute("errors", errors);
        }else {
            resultPage = "success.view";
            createUserDate(email, username, passwd);
        }
        req.getRequestDispatcher(resultPage).forward(req, resp);
    }

    private boolean isInvalidEmail(String email) {
        return email == null || !email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    }

    private boolean isInvalidUsername(String username){
        if(username == null) {
            return true;
        }
        String sql = "select username from usersdata where username=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                DBUtils.close(rs, ps, conn);
                return true;
            }else {
                DBUtils.close(rs, ps, conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isInvalidPasswd(String passwd, String confirmedPasswd) {
        return passwd == null
                || passwd.length() < 6
                || confirmedPasswd.length() < 6
                || !passwd.equals(confirmedPasswd);
    }

    private void createUserDate(String email, String username, String passwd) {
        String sql = "insert into usersdata(username, passwd, email) values(?, ?, ?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, MD5Util.md5Encode(passwd));
            ps.setString(3, email);
            int num = ps.executeUpdate();
            if(num != 1){
                System.out.println("用户数据写入数据库失败");
            }
            DBUtils.close(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
