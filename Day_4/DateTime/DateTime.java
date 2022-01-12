/**
	Live Date and time
*/

import java.util.*;
import java.awt.*;
import java.applet.Applet;

public class DateTime extends Applet implements Runnable {
    Thread th; 
    Date d;
    public void init() {
        th = new Thread(this) ;
        th.start () ;
        new Date() ;
    }
    public void paint (Graphics g) {
        g.drawString(d.toString() , 100, 200) ;
    }
    public void run(){
        while (true) {
            d = new Date () ;
            repaint ();
            try {
                th.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
