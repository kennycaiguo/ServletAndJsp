package cc.openhome;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhuxinquan on 16-3-1.
 */
public class uploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] body = readBody(req);
//        System.out.println((new String("\n").length());
        String textBody = new String(body, "UTF-8");
        String filename = getFilename(textBody);
        System.out.println(filename);
        Position p = getFilePosition(req, textBody);
        writeTo(filename, body, p);
    }

    class Position {
        int begin;
        int end;

        Position(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    private byte[] readBody(HttpServletRequest request) throws IOException{
        int formDataLength = request.getContentLength();
        System.out.println(formDataLength);
        DataInputStream dataStream = new DataInputStream(request.getInputStream());
        byte body[] = new byte[formDataLength];
        int totalBytes = 0;
        while(totalBytes < formDataLength){
            int bytes = dataStream.read(body,totalBytes, formDataLength);
            totalBytes += bytes;
        }
        return body;
    }

    private Position getFilePosition(HttpServletRequest request, String textBody) throws IOException{
        String contentType = request.getContentType();
        System.out.println("contentType");
        System.out.println(contentType);
        System.out.println("contentType");
        String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());

        int pos = textBody.indexOf("filename=\"");
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
        int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
        int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;
        return new Position(begin, end);
    }

    private String getFilename(String reqBody){
        String filename = reqBody.substring(reqBody.indexOf("filename=\"") + 10);
        filename = filename.substring(0, filename.indexOf("\n"));
        filename = filename.substring(filename.lastIndexOf("\\") + 1, filename.indexOf("\""));
        return filename;
    }

    private void writeTo(String filename, byte[] body, Position p) throws FileNotFoundException, IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("/home/zhuxinquan/Download/" + filename);
        System.out.println("\\\\\\");
        System.out.println(new String(body));
        System.out.println("\\\\\\");
        fileOutputStream.write(body, p.begin, (p.end - p.begin));
        System.out.println("successed");
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
