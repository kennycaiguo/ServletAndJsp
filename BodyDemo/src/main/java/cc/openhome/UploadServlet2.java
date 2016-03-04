package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created by zhuxinquan on 16-3-2.
 */
@MultipartConfig
public class UploadServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("photo");
        String filename = getFilename(part);
        writeTo(filename, part);
    }

    private String getFilename(Part part){
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        return filename;
    }

    private void writeTo(String filename, Part part) throws IOException, FileNotFoundException{
        InputStream in = part.getInputStream();
        OutputStream out = new FileOutputStream("/home/zhuxinquan/Download" + filename);
        byte[] buffer = new byte[1024];
        int length = -1;
        while((length = in.read(buffer)) != -1){
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
    }
}
