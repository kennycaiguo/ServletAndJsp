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
@WebServlet("/test.view")
public class Test extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response(req, resp);
    }

    private static void Response(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        int count = 2006;
        HttpSession session = req.getSession();
        if(session.getAttribute("count") != null) {
            int c = (int) session.getAttribute("count");
            count = c + 1;
            if(count == 2016){
                count = 2006;
            }
        }
        session.setAttribute("count", count);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Count</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Count  " + count + "</h1>");
        out.println("<a href='" + resp.encodeURL("test.view") + "'>递增</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
