import java.net.*;
import java.io.*;
import java.time.Clock;
public class UploadServerThread extends Thread {
   private Socket socket = null;
   public UploadServerThread(Socket socket) {
      super("DirServerThread");
      this.socket = socket;
   }
   public void run() {
      try {
         InputStream in = socket.getInputStream(); 
         HttpServletRequest req = new HttpServletRequest(in);  
         OutputStream baos = new ByteArrayOutputStream(); 
         HttpServletResponse res = new HttpServletResponse(baos); 
         HttpServlet httpServlet = new UploadServlet();
         httpServlet.doPost(req, res);
         OutputStream out = socket.getOutputStream(); 
         out.write(((ByteArrayOutputStream) baos).toByteArray());
         socket.close();
      } catch (Exception e) { e.printStackTrace(); }
   }
}
