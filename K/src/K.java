import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhuxinquan on 16-3-27.
 */
@WebServlet("/K")
public class K extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        if("key".equals(req.getParameter("key"))){
            resp.sendRedirect("Welcome.html");
        }else{
            resp.sendRedirect("index.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        if("key".equals(req.getParameter("key"))){
            resp.sendRedirect("Welcome.html");
        }else{
            resp.sendRedirect("index.html");
        }
    }
}
