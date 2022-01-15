package clientside;

import java.io.*;
import java.net.*;

public class ClientSide {

    Socket mySocket;
    BufferedReader br;
    PrintStream ps;

    public ClientSide(String[] data) {
        try {
            mySocket = new Socket(InetAddress.getLocalHost(), 5005);
            br = new BufferedReader(new InputStreamReader(this.mySocket.getInputStream()));
            ps = new PrintStream(mySocket.getOutputStream());
            for (String d : data) {
                ps.print(d + " ");
            }
            ps.println();
            String replyMsg = br.readLine();
            System.out.println(replyMsg);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                br.close();
                mySocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
