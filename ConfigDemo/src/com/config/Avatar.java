package com.config;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用getResourcePaths获取web应用程序目录中的文件列表
 * Created by zhuxinquan on 16-4-11.
 */
@WebServlet(
        urlPatterns = {"/avatar.view"},
        initParams = {
                @WebInitParam(name = "AVATAR_DIR", value = "/")
        }
)
public class Avatar extends HttpServlet{
    private String AVATAR_DIR;

    //用初始化参数初始化路径
    @Override
    public void init() throws ServletException {
        AVATAR_DIR = getInitParameter("AVATAR_DIR");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>头像显示</title>");
        out.println("</head>");
        out.println("<body>");
        //在web根目录下寻找以.jpg结尾的图片并显示
        for(String avatar : getServletContext()
                .getResourcePaths(AVATAR_DIR)){
//            avatar = avatar.replaceFirst("/", "");
            if(avatar.endsWith(".jpg")){
                out.println("<img src='"+ avatar + "'>");
            }
            out.println("<img src='"+ avatar + "'>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
