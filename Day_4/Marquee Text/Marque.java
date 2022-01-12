/**
	Marquee text version 2
*/

import java.awt.*;
import java.applet.Applet;

public class Marque extends Applet implements Runnable{
    String toDraw;
    int pos = 0; //to check position
    int stringWidth;
	
	//start thread.
    public void init(){
        Thread th = new Thread(this);
        th.start();
        toDraw = "Marquee Action";
    }
	
	//Draw the string
    public void paint(Graphics g){
        g.drawString(toDraw, pos, 100);
        stringWidth = g.getFontMetrics().stringWidth(toDraw);
    }
	
	//move the string
    public void run(){
        while(true){
            if(pos < getWidth()){
                pos++;
            }else { 
                pos = 0 - stringWidth; 
            }
            repaint();
            try {
                th.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
