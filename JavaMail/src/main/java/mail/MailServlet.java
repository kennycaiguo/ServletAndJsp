package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zhuxinquan on 16-8-19.
 */

@WebServlet(
        urlPatterns = {"/mail.do"},
        initParams = {
                @WebInitParam(name = "mailHost", value = "smtp.163.com"),
                @WebInitParam(name = "mailPort", value = "465"),
                @WebInitParam(name = "username", value = "xiyoulinuxgroup"),
                @WebInitParam(name = "password", value = "linux2006"),
        }
)
public class MailServlet extends HttpServlet{
    private String mailHost;
    private String mailPort;
    private String username;
    private String password;
    private Properties props;

    @Override
    public void init() throws ServletException {
        mailHost  = getServletConfig().getInitParameter("mailHost");
        mailPort  = getServletConfig().getInitParameter("mailPort");
        username  = getServletConfig().getInitParameter("username");
        password  = getServletConfig().getInitParameter("password");

        props = new Properties();
        props.put("mail.smtp.host", mailHost);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", mailPort);
        props.setProperty("mail.smtp.socketFactory.port", mailPort);
        props.setProperty("mail.smtp.auth", "true");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String text = req.getParameter("text");

        Message message = getMessage(from, to, subject, text);
        try {
            Transport.send(message);
            resp.getWriter().println("mail send OK~");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Message getMessage(String from, String to, String subject, String text){
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }
}
