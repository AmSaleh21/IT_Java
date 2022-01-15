import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import serverside.ServerSide;

public class Server{
    public static void main(String[] args) {
        try {
            new ServerSide();
        } catch (IOException ex) {
            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}