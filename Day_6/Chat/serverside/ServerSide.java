package serverside;

import java.io.*;
import java.net.*;

public class ServerSide {

  ServerSocket myServerSocket;
  Socket sock;
  BufferedReader br;
  PrintStream ps;

  public ServerSide() throws IOException {
    try {
      myServerSocket = new ServerSocket(5005);
      sock = myServerSocket.accept();
      //dis = new DataInputStream(sock.getInputStream());
      br = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
      ps = new PrintStream(sock.getOutputStream());
      String msg = br.readLine();
      System.out.println(msg);
      ps.println("Data Sent");
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      try {
        ps.close();
        br.close();
        sock.close();
        myServerSocket.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}
