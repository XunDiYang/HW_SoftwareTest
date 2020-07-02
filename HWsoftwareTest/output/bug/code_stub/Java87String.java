// package tem1;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Java87String {

	public static void main(String[] args) throws UnsupportedEncodingException {

		byte[] b = { -5, -122, -28 };

		String input = Arrays.toString(b);
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 13);
		System.out.println("-" + 13);
		System.out.println("@@Class: ");
		System.out.println("Arrays");
		System.out.println("Call method: ");
		System.out.println("toString");
		
		System.out.println("Input parameters: ");
		for(int i =0;i<b.length;i++) {
			System.out.print(b[i]+" ");
		}
		System.out.println();
		
		System.out.println("Return Value: ");
		System.out.println(input);

		System.out.println();
		System.out.println("Input Array :" + input);

		System.out.println("Array Length : " + b.length);

		String target = new String(b, StandardCharsets.UTF_8);

		byte[] targetByte = target.getBytes("UTF-8");
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 22);
		System.out.println("-" + 22);
		System.out.println("@@Class: ");
		System.out.println("String");
		System.out.println("The object: ");
		System.out.println(target);
		System.out.println("Call method: ");
		System.out.println("getBytes");
		System.out.println("Input parameters: ");
		System.out.println("UTF-8");
		System.out.println("Return Value: ");
		for(int i =0;i<targetByte.length;i++) {
			System.out.print(targetByte[i]+" ");
		}
		System.out.println();

		String targetUTF8 = Arrays.toString(targetByte);
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 24);
		System.out.println("-" + 24);
		System.out.println("@@Class: ");
		System.out.println("Arrays");
		System.out.println("Call method: ");
		System.out.println("toString");
		
		System.out.println("Input parameters: ");
		for(int i =0;i<targetByte.length;i++) {
			System.out.print(targetByte[i]+" ");
		}
		System.out.println();
		
		System.out.println("Return Value: ");
		System.out.println(targetUTF8);

		System.out.println();
		System.out.println(targetUTF8);

		System.out.println("Final Key :" + target);

	}
}
