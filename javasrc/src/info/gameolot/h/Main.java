package info.gameolot.h;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chrriis.dj.nativeswing.NativeSwing;

public class Main {
	static boolean go;
	static List<Element> elementList = new ArrayList<Element>();
	static List<Element> headElementList = new ArrayList<Element>();
	static boolean Web;
	public static void file(boolean cv, boolean isFileProvided, boolean isEndProvided, String fileLoc, String endLoc) {
		File file = null;
		String a = "";
		if(isFileProvided){
			file = new File(fileLoc);
			a = fileLoc;
		} else {
		System.out.println("Enter file location:");
		Scanner s = new Scanner(System.in);
		 a = s.next();
		file = new File(a);
		}
		Element[] heirarchy = new Element[100];
		try {
			Scanner s2 = new Scanner(file).useDelimiter(";");
			System.out.println("Reading and converting file...");
			int v = 1;
				boolean aa = false;
				int index = 0;
				while(s2.hasNext()){	
					String ah = s2.next().replaceAll("[\\r\\n]", "");
					String z = ah.replaceAll(";", "");
					String[] ac = z.split("\\(");

					if (z.replaceAll("\\)", "") != z) {
						String ag = z.replaceAll("\\)","");
						if (index > 1) {
							index = index - 1;
							heirarchy[index].subelements.add(Interpreter.interpretString(ag, v));
						} else {
							index = index - 1;
							elementList.add(Interpreter.interpretString(ag, v));
						}
					} else if(index == 0 && ac.length == 1) {
						elementList.add(Interpreter.interpretString(z, v));
					} else {
						if (index != 0 && ac.length == 1) {
							Element ae = Interpreter.interpretString(ac[0], v);
							heirarchy[index].subelements.add(ae);
						} if (index != 0 && ac.length != 1) {
							for(int i = 0; i < ac.length -1; i++) {
								Element af = Interpreter.interpretString(ac[i], v);
								heirarchy[index].subelements.add(af);
								heirarchy[index+1] = af;
								index++;
							}
							heirarchy[index].subelements.add(Interpreter.interpretString(ac[ac.length - 1], v));
						}
						if (index == 0 && ac.length != 1) {
							Element ad = Interpreter.interpretString(ac[0], v);
							heirarchy[index] = ad;
							elementList.add(ad);
							for (int i = 1; i < ac.length -1; i++) {
								Element af = Interpreter.interpretString(ac[i], v);
								heirarchy[index].subelements.add(af);
								heirarchy[index+1] = af;
								index++;
							}
							heirarchy[index].subelements.add(Interpreter.interpretString(ac[ac.length - 1], v));
						}
				v++;
				}
			}
			 go = true;
			
		 } catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.out.println(e);
			go = false;
			
		}
		PrintWriter writer = null;
		try {
			if (go) {
				for (int i = 0; i < elementList.size(); i++) {
					Element e = elementList.get(i);
					if (e == null) {
					elementList.remove(e);
					} else if(e.isHead) {
						elementList.remove(e);
						headElementList.add(e);
					}
				}
				String b;
			System.out.println("Saving new file...");
			if(cv) {
			b = a.replace(".hsf", ".html");
			} else
			{
				b = System.getProperty("java.io.tmpdir") + "/temp.html";
			}
			writer = new PrintWriter(b, "UTF-8");
			writer.println("<html><head>");
			for(int i = 0; i < headElementList.size(); i++) {
				writer.println(headElementList.get(i).returnHTML());
			}
			writer.println("</head><body>");
			for(int i = 0; i < elementList.size(); i++) {
			writer.println(elementList.get(i).returnHTML());
			}
			writer.println("</body></html>");
			writer.close();
			if (cv) {
			System.out.println("Done! HTML file saved to " + b);
			} else {
				try {
					InitGui.initGui(b);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static Element getLastElement(List<Element> l) {
		return l.get(l.size() - 1);
	}
	public static void main(String[] args) {
		NativeSwing.initialize();
		if(args.length != 0) {
			Main.file(true, true, false, args[0], "");
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Enter in function:");
		String c = s.next();
		if(c.equals("compile") || c.equals("c")) {
			Main.file(true, false, false, "", "");
		}else if (c.equals("view") || c.equals("v")) {
			Main.file(false, false, false, "", "");
		}
	}
}
