package cc.openhome;

import javafx.geometry.Pos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Position;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by zhuxinquan on 16-3-1.
 */
public class uploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] body = readBody(req);
        String textBody = new String(body, "ISO-8859-1");
        String filename = getFilename(textBody);
        Position p =
    }
}
