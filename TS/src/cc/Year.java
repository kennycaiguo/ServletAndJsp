package cc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhuxinquan on 16-3-18.
 */
@WebServlet("/year")
public class Year extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        int year = 2006;
        if(req.getParameter("year") != null){
            year = Integer.parseInt(req.getParameter("year"));
        }
        System.out.println(year);
        if(year == 2015){
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>TS</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div style=\"Text-align:center;width:100%;\">\n" +
                    "    <h1>" + String.valueOf(year).toString() + "</h1>\n" +
                    "<form action=\"year\" method=\"post\">\n" +
                    "        <input type=\"hidden\" name=\"year\" value="+ 2006 +">\n" +
                    "        <input type=\"submit\" value=\"go to 2016\">\n" +
                    "    </form>" +
                    "</div>"+
                    "</body>\n" +
                    "</html>");
        }else if(year == 2016){
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>TS</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "Welcome Next Level<br>" +
                    "<a href='#'>Next</a>" +
                    "</body>\n" +
                    "</html>");
        }else if(year < 2006 || year > 2016){
            year = 2006;
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>TS</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div style=\"Text-align:center;width:100%;\">\n" +
                            "    <h1>" + String.valueOf(year).toString() + "</h1>\n" +
                    "<form action=\"year\" method=\"post\">\n" +
                    "        <input type=\"hidden\" name=\"year\" value="+ String.valueOf(year) +">\n" +
                    "        <input type=\"submit\" value=\"go to 2016\">\n" +
                    "    </form>" +
                            "</div>"+

                    "</body>\n" +
                    "</html>");
        }else{
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>TS</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div style=\"Text-align:center;width:100%;\">\n" +
                    "    <h1>" + String.valueOf(year).toString() + "</h1>\n" +
                    "<form action=\"year\" method=\"post\">\n" +
                    "        <input type=\"hidden\" name=\"year\" value="+ String.valueOf(year + 1).toString() +">\n" +
                    "        <input type=\"submit\" value=\"go to 2016\">\n" +
                    "    </form>" +
                    "</div>"+
                    "</body>\n" +
                    "</html>");
        }
        out.close();
    }
}
