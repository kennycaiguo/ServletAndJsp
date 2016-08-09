package com.servlet.asyn;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zhuxinquan on 16-4-22.
 */
public class AsynServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet开始：" + new Date());
        AsyncContext context = req.startAsync();
        new Thread(new Excutor(context)).start();
        System.out.println("servlet完毕：" + new Date());
    }

    public class Excutor implements Runnable{

        private AsyncContext context;



        public Excutor(AsyncContext context) {
            this.context = context;
        }

        @Override
        public void run() {
            //执行相关复杂业务
            try {
                Thread.sleep(1000*10);
//                context.getRequest();
//                context.getResponse();
                System.out.println("执行完毕" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
