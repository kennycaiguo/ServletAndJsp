package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhuxinquan on 16-3-5.
 */
//@WebServlet("/pet")
public class Pet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

//        System.out.println(req.getParameter("user"));
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>感谢填写</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("联系人： <a href='maolto:" +
                req.getParameter("email") + "'>" +
                req.getParameter("user") + "</a>");
        out.println("<br>喜欢的宠物类型");
        out.println("<ul>");
        for(String type: req.getParameterValues("type")) {
            out.println("<li>" + type + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
