package info.gameolot.h;

import java.awt.Desktop;
import java.io.File;



public class InitGui {
	private static String tempurl;
		public static void initGui(String URL) throws Exception {
			File htmlFile = new File(URL);

			// open the default web browser for the HTML page
			Desktop.getDesktop().browse(htmlFile.toURI());

			// if a web browser is the default HTML handler, this might work too
			Desktop.getDesktop().open(htmlFile);
	}
}
