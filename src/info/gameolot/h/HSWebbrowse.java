package info.gameolot.h;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HSWebbrowse {
	static boolean go;
	static List<Element> elementList = new ArrayList<Element>();
	static boolean Web;
	public static void file() {
		System.out.println("Enter file location:");
		Scanner s = new Scanner(System.in);
		String a = s.next();
		File file = null;
		file = new File(a);
		Element[] heirarchy = new Element[100];
		try {
			Scanner s2 = new Scanner(file).useDelimiter(";");
			System.out.println("Reading and converting file...");
			int v = 1;{
				boolean aa = false;
				int index = 0;
				while(s2.hasNext()){	
					String z = s2.next().replaceAll("[\\r\\n]", "");
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
			
		} } catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.out.println(e);
			go = false;
			
		}
		PrintWriter writer = null;
		try {
			if (go) {
			System.out.println("Creating temp file...");
			String b = null;
			b = System.getProperty("java.io.tmpdir") + "/temp.html";
			writer = new PrintWriter(b, "UTF-8");
			writer.println("<html><head></head><body>");
			for (int i = 0; i < elementList.size(); i++) {
				Element e = elementList.get(i);
				writer.println(e.returnHTML());
			}
			writer.println("</body></html>");
			writer.close();
				InitGui.initGui(b);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void cleanup(String s) {

		File file1 = new File(s);
		 
		if(file1.delete()){
			System.out.println(file1.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}
	}
	public static File createTempDirectory()
		    throws IOException
		{
		    final File temp;

		    temp = File.createTempFile("temp", Long.toString(System.nanoTime()));

		    if(!(temp.delete()))
		    {
		        throw new IOException("Could not delete temp file: " + temp.getAbsolutePath());
		    }

		    if(!(temp.mkdir()))
		    {
		        throw new IOException("Could not create temp directory: " + temp.getAbsolutePath());
		    }

		    return (temp);
		}
}
