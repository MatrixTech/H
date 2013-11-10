package info.gameolot.h;



public class Interpreter {
	public static Element interpretString(String s, int v) {
		String[] q = {""};
		try{
		if (s.equals(null) || s.equals("")) {
			Element e = null;
			return e;
		} else {
		String[] a = s.split("\\{");
		String k = a[0];
		String type;
		boolean head;
		if (k.startsWith("head.")) {
			type = k.replace("head.", "");
			head = true;
		} else {
			type = k;
			head = false;
		}
		String b = a[1];
		String c = b.replace(", ", ",");
		String d = c.replace("}", "");
		String e = d.replace("=", ":");
		String[] f = e.split(",");
		String con = "";
		for (int i = 0; i < f.length; i++) {
			if(f[i].startsWith(type + ":")) {
				String g = f[i].replace(type, "");
				String h = g.replace(": ", "");
				con = h.replace(":", "");
				f[i] = "";
			}
		}
		String j;
		if (type.startsWith("text")) {
			j = "p";
		}
		else if (type.startsWith("link")) {
			j = "a";
		}
		else {
			j = type;
		}
		return new Element(j, f, con, head);
		}} catch(Exception e) {
			System.out.println("Error on line " + v);
			e.printStackTrace(System.out);
			System.out.println(s);
			Main.go = false;
			return new Element("", q, "");
		}
	}
}
