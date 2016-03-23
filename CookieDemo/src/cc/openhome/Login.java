package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhuxinquan on 16-3-21.
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter( "username");
        String passwd = req.getParameter("passwd");
        if("user".equals(user) && "passwd".equals(passwd)) {
            String login = req.getParameter("auto");
            if("yes".equals(login)) {
                Cookie cookie = new Cookie("user", user);
                cookie.setMaxAge(60*30);
                resp.addCookie(cookie);
            }
            req.setAttribute("user", user);
            req.getRequestDispatcher("user.view").forward(req, resp);
        }else {
            resp.sendRedirect("login.html");
        }
    }
}
