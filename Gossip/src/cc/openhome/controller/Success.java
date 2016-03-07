package cc.openhome.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注册成功
 * Created by zhuxinquan on 16-3-6.
 */
public class Success extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html PUBLIC" +
                "'-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta content='text/html;charset=UTF-8'" +
                "http-euqiv='coneten-type'>");
        out.println("<body>");
        out.println("<h1>会员 " +
                req.getParameter("username") + " 注册成功</h1>");
        out.println("<a href='index.html'>回首页登陆</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
