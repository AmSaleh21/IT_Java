package chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ChatServer {
  ServerSocket serverSocket;

  public ChatServer() {
    try {
      //open the server socket
      serverSocket = new ServerSocket(5000);
      System.out.println("Server is running on port: 5000"); //informative print
    } catch (IOException e) {
      e.printStackTrace();
    }

    while (true) {
      try {
        //accept the incoming data from the clients
        Socket socket = serverSocket.accept();
        new ChatHandler(socket); //create a new handler (client thread)
        System.out.println("New Client Connected!"); //informative print
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}