package cc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhuxinquan on 16-3-7.
 */
public class NewPage extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String page = (String) req.getAttribute("page");
        System.out.println(page);
        PrintWriter out = resp.getWriter();
        req.setAttribute("page", page);
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Add1</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"add1.do\">\n" +
                "        <h1>Page = " + page + "</h1>\n" +
                "        <input type=\"submit\" value=\"+1\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }
}
