package mail;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zhuxinquan on 16-8-19.
 */

@MultipartConfig
@WebServlet(
        urlPatterns = {"/mail2.do"},
        initParams = {
                @WebInitParam(name = "mailHost", value = "smtp.163.com"),
                @WebInitParam(name = "mailPort", value = "994"),
                @WebInitParam(name = "username", value = "xiyoulinuxgroup"),
                @WebInitParam(name = "password", value = "linux2006"),
        }
)
public class MailServlet2 extends HttpServlet{
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
        Part part = req.getPart("file");

        Message message = getMessage(from, to, subject, text, part);
        try {
            Transport.send(message);
            resp.getWriter().println("mail send OK~");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Message getMessage(String from, String to, String subject, String text, Part part){
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
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(text, "text/html;charset=UTF-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);

            String filename = getFilename(part);
            if(! "".equals(filename)){
                MimeBodyPart filePart = new MimeBodyPart();
                filePart.setFileName(MimeUtility.encodeText(filename, "UTF-8", "B"));
                System.out.println(part.getContentType());
                filePart.setContent(getBytes(part), part.getContentType());
                multipart.addBodyPart(filePart);
            }

            message.setContent(multipart);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    private String getFilename(Part part){
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return filename;
    }

    private byte[] getBytes(Part part) throws IOException {
        InputStream in = part.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = -1;
        while((length = in.read(buffer)) != -1){
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
        return out.toByteArray();
    }
}
