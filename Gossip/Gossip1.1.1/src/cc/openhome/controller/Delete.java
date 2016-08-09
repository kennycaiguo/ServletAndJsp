package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.*;

/**
 * Created by zhuxinquan on 16-3-10.
 */
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("login") == null) {
            response.sendRedirect("index.html");
            return;
        }

        int id = Integer.parseInt(request.getParameter("message"));
        Connection conn  = DBUtils.getConnection();
        String sql = "delete from message where id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            DBUtils.close(null, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("member.view");
    }
}
