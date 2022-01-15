package chat;

import java.net.Socket;
import java.net.SocketException;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.Vector;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatHandler extends Thread {
  Socket socket;
  BufferedReader dataInputStream;
  PrintStream printStream;
  static Vector<ChatHandler> clients = new Vector<ChatHandler>(); // vector to hold the clients

  public ChatHandler(Socket socket) {
    // make a new client
    this.socket = socket;
    try {
      dataInputStream = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      printStream = new PrintStream(this.socket.getOutputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
    clients.add(this);
    start();
  }

  public void run() { // run the handler thread
    while (true) {
      try {
        String message = dataInputStream.readLine(); // read the incoming message from the client
        System.out.println("Received: " + message); // informative print
        broadcast(message);
      } catch (SocketException se) { // when a client is removed
        try {
          if (dataInputStream != null)
            dataInputStream.close(); // close it's buffer
          if (printStream != null)
            printStream.close(); // close it's stream
          clients.remove(this); // remove the client object from the vector
          System.out.println("client removed"); // informative print
          break;
        } catch (IOException e) {
          e.printStackTrace();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (clients.size() == 0) {
          System.exit(0); //close the server when no clients are running
        }
      }
    }
  }

  // to ways to broadcast choose what you like

  // lambda loop on the vector of the clients to send the message
  public void broadcast(String message) {
    clients.forEach((ChatHandler client) -> {
      client.printStream.println(message);
    });
  }

  /*
   * //enhanced loop to send the message to the clients
   * public void broadcast(String message){
   * for(ChatHandler cl : clients){
   * cl.printStream.println(message);
   * }
   * }
   */
}
