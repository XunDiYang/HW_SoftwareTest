package tem1;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Java87String {

	public static void main(String[] args) throws UnsupportedEncodingException {

		byte[] b = { -5, -122, -28 };

		String input = Arrays.toString(b);
		
		System.out.println();
		System.out.println("Input Array :" + input);

		System.out.println("Array Length : " + b.length);

		String target = new String(b, StandardCharsets.UTF_8);

		byte[] targetByte = target.getBytes("UTF-8");
		
		String targetUTF8 = Arrays.toString(targetByte);


		System.out.println();
		System.out.println(targetUTF8);

		System.out.println("Final Key :" + target);

	}
}
