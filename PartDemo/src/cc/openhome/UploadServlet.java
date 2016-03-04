package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by zhuxinquan on 16-3-3.
 */
@MultipartConfig(location = "/home/zhuxinquan/")
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        for(Part part :req.getParts()) {
            if(part.getName().startsWith("file")){
                String filename = getFilename(part);
                part.write(filename);
            }
        }
//        Part part = req.getPart("photo");
//        String filename = getFilename(part);
//        part.write(filename);
//        writeTo(filename, part);
    }

    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        return filename;
    }

    private void writeTo(String filename, Part part) throws IOException, FileNotFoundException {
        InputStream in = part.getInputStream();
        OutputStream out = new FileOutputStream("/home/zhuxinquan/" + filename);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
    }
}
