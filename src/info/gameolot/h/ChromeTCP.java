package info.gameolot.h;

import java.io.*;
import java.net.*;

class ChromeTCP
{
    public static BufferedReader inFromClient = null;
    public static DataOutputStream outToClient = null;
    public static boolean init = false;
    static ServerSocket welcomeSocket;
    public static void initTCP() {

        String clientSentence;
        String capitalizedSentence;
        try {
			welcomeSocket = new ServerSocket(5840);
			init = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   public static void TCP() throws Exception
      {
	   if (init == true) {
            Socket connectionSocket = welcomeSocket.accept();
            inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      } }
}