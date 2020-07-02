// package tem1;

import java.io.PrintStream;
import java.util.zip.*;
import java.util.Date;

public class ZipEntryTest {

	private static String testString = "ZipEntryTest";

	public static void main(String argv[]) {
		ZipEntry ze = new ZipEntry("ZipEntryTest");
		Date date = new Date(10);

		ze.setTime(date.getTime());
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 15);
		System.out.println("-" + 15);
		System.out.println("@@Class: ");
		System.out.println("ZipEntry");
		System.out.println("Call method: ");
		System.out.println("setTime");
		System.out.println("Input parameters: ");
		System.out.println(date.getTime());
		System.out.println("Return Value: ");
		System.out.println(ze.getTime());
		

		long zeGetTime = ze.getTime();
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 18);
		System.out.println("-" + 18);
		System.out.println("@@Class: ");
		System.out.println("ZipEntry");
		System.out.println("Call method: ");
		System.out.println("getTime");
		System.out.println("Input parameters: ");
		System.out.println("Return Value: ");
		System.out.println(zeGetTime);
		
		long dGetTime = date.getTime();
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 16);
		System.out.println("-" + 16);
		System.out.println("@@Class: ");
		System.out.println("Date");
		System.out.println("Call method: ");
		System.out.println("getTime");
		System.out.println("Input parameters: ");
		System.out.println("Return Value: ");
		System.out.println(dGetTime);

		Date date1 = new Date(zeGetTime);

		System.out.println(date);
		System.out.println(date1);
	}
}
