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
@WebServlet("/index.do")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                if("user".equals(name) && "passwd".equals(value)) {
                    req.setAttribute(name, value);
                    req.getRequestDispatcher("/user.view").forward(req, resp);
                    return;
                }
            }
        }

        resp.sendRedirect("login.html");
    }
}
