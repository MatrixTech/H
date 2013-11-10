package info.gameolot.h;

public class Attrs {
	public static String translAttr(String s)  {
		String a = s.replaceFirst("attr-", "");
		String[] b = a.split(":");
		String c = "";
		for(int i = 1; i < b.length; i++) {
			if (i != 1) {
			c = c + ":" + b[i];
			} else {
				c = c + b[i];
			}
		}
		return b[0] + "=\"" + c + "\"";
	}
}
