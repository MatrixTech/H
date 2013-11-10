package info.gameolot.h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Element {

	String[] addElement(String[] org, String added) {
		String[] result = Arrays.copyOf(org, org.length + 1);
		result[org.length] = added;
		return result;
	}

	public boolean isHead;
	String type;
	String[] args;
	String child;
	List<Element> subelements = new ArrayList<Element>();
	String in;
	String[] htmlargs = { "" };
	private String htmlAttrString = "";
	private String cssString = "";

	public Element(String typ, String[] css, String contents, boolean head) {
		this.type = typ;
		this.args = css;
		this.in = contents;
		formatElement(this);
		this.isHead = head;
	}

	public Element(String typ, String[] css, String contents) {

		this.type = typ;
		this.args = css;
		this.in = contents;
		this.isHead = false;
		formatElement(this);
	}
	public void formatElement(Element e) {
		if (e.type.equals("rect")) {
			e.type = "div";
			for (int i = 0; i < e.args.length; i++) {
				if (e.args[i].startsWith("x")) {
					e.args[i] = e.args[i].replaceFirst("x", "left");
				}
				if (e.args[i].startsWith("y")) {
					e.args[i] = e.args[i].replaceFirst("y", "top");
				}
			}
			e.args = e.addElement(e.args, "position:absolute");
		}
		boolean xyused = false;
		for (int i = 0; i < e.args.length; i++) {
			if (e.args[i].startsWith("x")) {
				e.args[i] = e.args[i].replaceFirst("x", "left");
				xyused = true;
			}
			if (e.args[i].startsWith("y")) {
				e.args[i] = e.args[i].replaceFirst("y", "top");
				xyused = true;
			}
		}
		if (xyused) {
			e.args = e.addElement(e.args, "position:absolute");
		}
		if (e.type.equals("script")) {
			for (int i = 0; i < e.args.length; i++) {
				if (e.args[i].startsWith("\"")) {
					e.args[i] = e.args[i].replace("\"", "");
					e.in = e.args[i];
					e.args[i] = "";
				}
			}
		}

		for (int i = 0; i < e.args.length; i++) {
			if (e.args[i].startsWith("attr-")) {
				e.htmlargs = e.addElement(htmlargs,
						Attrs.translAttr(e.args[i]));
				e.args[i] = "";
			}
		}
	}
	public Element(String typ, String[] css) {
		this.type = typ;
		this.args = css;
		this.in = "";
	}

	public String returnSubHTML() {
		String q = "";
		if (this.subelements.size() != 0) {
			q = System.getProperty("line.separator");
		}
		for (int i = 0; i < this.subelements.size(); i++) {
			q = q + this.subelements.get(i).returnHTML()
					+ System.getProperty("line.separator");
		}
		return q;
	}

	public String returnArgs() {
		return args.toString();
	}

	public String returnHTML() {
		for (int i = 0; i < this.args.length; i++) {
			if (this.args[i] != "")
				this.cssString = this.cssString + this.args[i] + ";";
		}
		if (this.htmlargs.equals(null) != true || this.type.equals("") != true
				|| this.type.equals(null) != true) {
			for (int i = 0; i < this.htmlargs.length; i++) {
				if (this.htmlargs[i] != "") {
					this.htmlAttrString = this.htmlAttrString + " "
							+ this.htmlargs[i];
				}
			}
		}
		return "<" + this.type + this.htmlAttrString + " style=\""
				+ this.cssString + "\">" + this.in + this.returnSubHTML()
				+ "</" + this.type + ">";
	}
}
