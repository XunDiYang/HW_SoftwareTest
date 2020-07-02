// package tem1;

public class RegTest {

	public static void main(String args[]) throws Exception {
		byte[] test1 = new byte[] { (byte) 0xfc, (byte) 0x80, (byte) 0x80, (byte) 0x8f, (byte) 0xbf, (byte) 0xbf };
		String str = new String(test1, "UTF8");
		
		System.out.println("");
		System.out.print("The line : ");
		System.out.print("Lines " + 7);
		System.out.println("-" + 7);
		System.out.println("@@Class: ");
		System.out.println("String");
		System.out.println("Call method: ");
		System.out.println("String");
		System.out.println("Input parameters: ");
		
		for(int i =0;i<test1.length;i++) {
			System.out.println(test1[i]);
		}
		
		System.out.println("UTF8");
		System.out.println("Return Value: ");
		System.out.println(str);
		
		String s1 = stringToHex(str);
		System.out.println(s1);
	}

	public static String stringToHex(String base) {
		StringBuffer buffer = new StringBuffer();
		int intValue;
		for (int x = 0; x < base.length(); x++) {
			intValue = base.charAt(x);
//			System.out.println("");
//			System.out.print("The line : ");
//			System.out.print("Lines " + 16);
//			System.out.println("-" + 16);
//			System.out.println("@@Class: ");
//			System.out.println("String");
//			System.out.println("Call method: ");
//			System.out.println("charAt");
//			System.out.println("Input parameters: ");
//			System.out.println(x);
//			System.out.println("Return Value: ");
//			System.out.println(intValue);

			String hex = Integer.toHexString(intValue);
//			System.out.println("");
//			System.out.print("The line : ");
//			System.out.print("Lines " + 17);
//			System.out.println("-" + 17);
//			System.out.println("@@Class: ");
//			System.out.println("Integer");
//			System.out.println("Call method: ");
//			System.out.println("toHexString");
//			System.out.println("Input parameters: ");
//			System.out.println(intValue);
//			System.out.println("Return Value: ");
//			System.out.println(hex);

			if (hex.length() == 1) {
				buffer.append("0" + hex + " ");
			} else {
				buffer.append(hex + " ");
			}
		}

//		System.out.println("");
//		System.out.print("The line : ");
//		System.out.print("Lines " + 24);
//		System.out.println("-" + 24);
//		System.out.println("@@Class: ");
//		System.out.println("StringBuffer");
//		System.out.println("Call method: ");
//		System.out.println("toString");
//		System.out.println("Input parameters: ");
//		System.out.println("Return Value: ");
//		System.out.println(buffer.toString());
		return buffer.toString();
	}
}
