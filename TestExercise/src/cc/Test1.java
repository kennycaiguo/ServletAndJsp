package cc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhuxinquan on 16-3-10.
 */
@WebServlet("/test1.view")
public class Test1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        int count = 0;
        HttpSession session = req.getSession();
        if(session.getAttribute("count") != null) {
            int c = (int) session.getAttribute("count");
            count = c + 1;
        }
        session.setAttribute("count", count);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Count</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Count" + count + "</h1>");
        out.println("<a href='" + resp.encodeURL("test1.view") + "'>递增</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
