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
        if(year == 2015){
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title></title>\n" +
                    "<style>\n" +
                    "html{height:100%;}" +
                    "body{\n" +
                    "  background: url(\"http://xylinux-10028272.file.myqcloud.com/picture.jpg\") no-repeat;\n" +
                    "  position:center;\n" +
                    "  background-size: cover;\n" +
                    "}\n" +
                    "#content{\n" +
                    "  height: 500px;\n" +
                    "  font-size: 50px;\n" +
                    "}\n" +
                    "#num{\n" +
                    "  position: relative;\n" +
                    "  top: 50%;\n" +
                    "  width: 200px;\n" +
                    "  height: 200px;\n" +
                    "  margin: -100px auto;\n" +
                    "}\n" +
                    "a{\n" +
                    "  text-decoration: none;\n" +
                    "}\n" +
                    "a:link, a:visited{\n" +
                    "  color:#06B9D1;\n" +
                    "}\n" +
                    "</style>\n" +
                    "\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <div id=\"content\">\n" +
                    "    <div id=\"num\">     \n" +
                    "      <form name=\"test\" method=\"post\">\n" +
                    "        <h1><a href=\"javascript:document.test.action='year';document.test.target='_self';document.test.submit();\" >2015</a></h1>\n" +
                    "        <input type=\"hidden\" name=\"year\" value=\"2006\"></input>\n" +
                    "      </form>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>");
        }else if(year == 2016){
            resp.sendRedirect("http://www.zmrlinux.com/mianshi");
        }else if(year <= 2006 || year > 2016){
            year = 2006;
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title></title>\n" +
                    "<style>\n" +
                    "html{height:100%;}" +
                    "body{\n" +
                    "  background: url(\"http://xylinux-10028272.file.myqcloud.com/picture.jpg\") no-repeat;\n" +
                    "  position:center;\n" +
                    "  background-size: cover;\n" +
                    "}\n" +
                    "#content{\n" +
                    "  height: 500px;\n" +
                    "  font-size: 50px;\n" +
                    "}\n" +
                    "#num{\n" +
                    "  position: relative;\n" +
                    "  top: 50%;\n" +
                    "  width: 200px;\n" +
                    "  height: 200px;\n" +
                    "  margin: -100px auto;\n" +
                    "}\n" +
                    "a{\n" +
                    "  text-decoration: none;\n" +
                    "}\n" +
                    "a:link, a:visited{\n" +
                    "  color:#06B9D1;\n" +
                    "}\n" +
                    "</style>\n" +
                    "\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <div id=\"content\">\n" +
                    "    <div id=\"num\">     \n" +
                    "      <form name=\"test\"  method=\"post\">\n" +
                    "        <h1><a href=\"javascript:document.test.action='year';document.test.target='_self';document.test.submit();\" >2006</a></h1>\n" +
                    "        <input type=\"hidden\" name=\"year\" value=\"2007\"></input>\n" +
                    "      </form>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>");
        }else{
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title></title>\n" +
                    "<style>\n" +
                    "html{height:100%;}" +
                    "body{\n" +
                    "  background: url(\"http://xylinux-10028272.file.myqcloud.com/picture.jpg\") no-repeat;\n" +
                    "  position:center;\n" +
                    "  background-size: cover;\n" +
                    "}\n" +
                    "#content{\n" +
                    "  height: 500px;\n" +
                    "  font-size: 50px;\n" +
                    "}\n" +
                    "#num{\n" +
                    "  position: relative;\n" +
                    "  top: 50%;\n" +
                    "  width: 200px;\n" +
                    "  height: 200px;\n" +
                    "  margin: -100px auto;\n" +
                    "}\n" +
                    "a{\n" +
                    "  text-decoration: none;\n" +
                    "}\n" +
                    "a:link, a:visited{\n" +
                    "  color:#06B9D1;\n" +
                    "}\n" +
                    "</style>\n" +
                    "\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <div id=\"content\">\n" +
                    "    <div id=\"num\">     \n" +
                    "      <form name=\"test\" method=\"post\">\n" +
                    "        <h1><a href=\"javascript:document.test.action='year';document.test.target='_self';document.test.submit();\" >" + String.valueOf(year).toString() + "</a></h1>\n" +
                    "        <input type=\"hidden\" name=\"year\" value=\"" + String.valueOf(year + 1).toString() + "\"></input>\n" +
                    "      </form>\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>");
        }
        out.close();
    }
}
