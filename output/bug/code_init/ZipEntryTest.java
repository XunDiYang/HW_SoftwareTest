package tem1;

import java.io.PrintStream;
import java.util.zip.*;
import java.util.Date;

public class ZipEntryTest{

    private static String testString = "ZipEntryTest";
    public static void main(String argv[]) {
        ZipEntry ze = new ZipEntry("ZipEntryTest");
        Date date = new Date(10);
        
        ze.setTime(date.getTime());
        
        long dGetTime = date.getTime();
        
        long zeGetTime = ze.getTime();
 
        Date date1 = new Date(zeGetTime);
        
        System.out.println(date);
        System.out.println(date1);
    }
}