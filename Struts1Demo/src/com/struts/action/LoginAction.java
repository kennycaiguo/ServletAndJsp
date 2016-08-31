package com.struts.action;

import com.struts.form.LoginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhuxinquan on 16-8-30.
 */

public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm)form;
        String userName = loginForm.getUserName();
        String userPassword = loginForm.getUserPassword();

        if("admin".equals(userName) && "admin".equals(userPassword)) {
            return new ActionForward("/success.jsp");
        }
        return new ActionForward("/fail.jsp");
    }
}
