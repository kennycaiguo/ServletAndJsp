import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuxinquan on 16-4-12.
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
    private Map<String, String> users;

    public Login(){
        users = new HashMap<String, String>();
        users.put("admin", "passwd");
        users.put("user", "userpasswd");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");

        String page = "form.html";
        if(users.containsKey(name) && users.get(name).equals(passwd)) {
            User user = new User(name);
            req.getSession().setAttribute("user", user);
//            req.getSession().setAttribute("user", name);
            user = null;
            System.gc();
            page = "welcome.view";
        }
        resp.sendRedirect(page);
    }
}
