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
 * Created by zhuxinquan on 16-3-7.
 */
@WebServlet("/test.view")
public class Test extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        int page = Integer.parseInt(req.getParameter("page"));
        if(page == 29 || page > 30) {
            page = 1;
        }
        if(page != 30){
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Add1</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<form action=\"test.view\" method=\"post\">\n" +
                    "        <input type=\"hidden\" name=\"page\" value="+ String.valueOf(page + 1) +">\n" +
                    "        <h2>page = "+ page +"</h2>\n" +
                    "        <input type=\"submit\" value=\"+1\">\n" +
                    "    </form>" +
                    "</body>\n" +
                    "</html>");
        }else {
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Add1</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<form action=\"test.view\" method=\"post\">\n" +
                    "        <input type=\"hidden\" name=\"page\" value="+ String.valueOf(page + 1) +">\n" +
                    "<a href='#'>next</a></br>" +
//                    "        <input type=\"submit\" value=\"+1\">\n" +
                    "    </form>" +
                    "</body>\n" +
                    "</html>");
        }

//        int count = 0;
//        HttpSession session = req.getSession();
//        if(session.getAttribute("count") != null) {
//            int c = (Integer) session.getAttribute("count");
//            count = c + 1;
//        }
//        session.setAttribute("count", count);
//
    }
}
