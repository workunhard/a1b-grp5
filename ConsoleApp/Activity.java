import java.io.*;
public class Activity {
   private String dirName = null; 
   public static void main(String[] args) throws IOException {
      new Activity().onCreate();
   }
   public Activity() {
   }
   public void onCreate() {
      System.out.println(new UploadClient().uploadFile());
   }
}
