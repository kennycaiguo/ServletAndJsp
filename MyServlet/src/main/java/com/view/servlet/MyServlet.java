package com.view.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhuxinquan on 16-2-29.
 */
//@WebServlet("/servlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        setCharacterEncoding方法对于Get发送的请求没有影响
//        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("nameGet");
//        name = java.net.URLDecoder.decode(name, "UTF-8");
//        System.out.println(name);
        name = new String(name.getBytes("UTF-8"), "GBK");
        System.out.println(name);
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter out = resp.getWriter();
////        System.out.println("GET: " + name);
////        name = new String(name.getBytes("GBK"), "UTF-8");
//        out.write("GEt: " + name);
//        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("BIG5");
        String name = req.getParameter("namePost");
        System.out.println("POST: " + name);
    }

}

