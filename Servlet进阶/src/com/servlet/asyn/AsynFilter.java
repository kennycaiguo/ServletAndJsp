package com.servlet.asyn;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by zhuxinquan on 16-4-22.
 */
@WebFilter(filterName = "AsynFilter", asyncSupported = true, value = {"/com/servlet/AsynServlet"}, dispatcherTypes = {DispatcherType.ASYNC, DispatcherType.REQUEST})
public class AsynFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("asyn....start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("sayn....end");
    }

    @Override
    public void destroy() {

    }
}
