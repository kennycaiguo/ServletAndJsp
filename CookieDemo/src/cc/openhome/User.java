package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhuxinquan on 16-3-21.
 */
@WebServlet("/user.view")
public class User extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        if(req.getAttribute("user") == null) {
            resp.sendRedirect("login.html");
        }
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLC '-//W3C//DTD HTML 4.01" +
                " Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet User</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" +
                req.getAttribute("user") + "已登陆</h1>");
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
