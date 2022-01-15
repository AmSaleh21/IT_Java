package chat;

import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.awt.*;
import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.ConnectException;

public class ChatApp extends JFrame implements Runnable {
  Socket socket;
  JTextArea textarea = new JTextArea(20, 50); //the broadcasted messages text area
  JScrollPane scrollPane = new JScrollPane(textarea); //scrollbar if the messages is longer
  JTextField textField = new JTextField(40); //text field to write the message in
  JButton sendButton = new JButton("Send"); //button to send the messages
  PrintStream printStream;
  BufferedReader dataInputStream;

  public ChatApp() {
    /**create the socket on local_host:5000 
      buffer to send the messages
      and print stream out to receive from the broadcast
    */
    try {
      socket = new Socket(InetAddress.getLocalHost(), 5000);
      dataInputStream = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      printStream = new PrintStream(socket.getOutputStream());
    } catch (ConnectException ce) { // if the client tried to run and no server is up
      System.out.println("Server isn't running can't instantiate the connection, closing");
      System.exit(1);
    }catch (IOException e) {
      e.printStackTrace();
    }

    setLayout(new FlowLayout()); //layout of the app
    
    sendButton.addActionListener((ActionEvent event) -> {
      sendMessage();
    }); 

    //to send the text if 'ENTER/RETURN' is pressed on the text field
    textField.addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          sendMessage();
        }
      }

      //has to be here from the abstract override keyListener
      public void keyTyped(KeyEvent e) {
      }

      public void keyReleased(KeyEvent e) {
      }
    });

    //add the elements
    add(scrollPane);
    add(textField);
    add(sendButton);
    new Thread(this).start(); //create and start the thread
  }

  // Send the message from the text field (TF)
  public void sendMessage() {
    String message = textField.getText(); //get the message from the TF
    printStream.println(message); //send to the server
    textField.setText(""); //clear the TF after the data is sent
  }

  //this is to find which window has closed, see main and handler (ignored till later release)
  public void sendMessage(String message){
    printStream.print(message);
  }

  //run the thread
  public void run() {
    while (true) {
      try {
        //read the incoming data from the server broadcast
        String message = dataInputStream.readLine();
        textarea.append(message + "\n");
      } catch (SocketException se) {
        System.out.println("server closed, closing ");
        System.exit(1); // if server closed while client is running
        break;
      }catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
