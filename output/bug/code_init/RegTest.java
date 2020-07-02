package tem2;

public class RegTest {

	public static void main(String args[]) throws Exception {
		byte[] test1 = new byte[] { (byte) 0xfc, (byte) 0x80, (byte) 0x80, (byte) 0x8f, (byte) 0xbf, (byte) 0xbf };
		String str = new String(test1, "UTF8");
		String s1 = stringToHex(str);
		System.out.println(s1);
	}

	public static String stringToHex(String base) {
		StringBuffer buffer = new StringBuffer();
		int intValue;
		for (int x = 0; x < base.length(); x++) {
			intValue = base.charAt(x);
			String hex = Integer.toHexString(intValue);
			if (hex.length() == 1) {
				buffer.append("0" + hex + " ");
			} else {
				buffer.append(hex + " ");
			}
		}
		return buffer.toString();
	}
}
