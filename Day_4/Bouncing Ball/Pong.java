
/**
	bouncing ball applet
*/

import java.applet.Applet;
import java.awt.*;

public class Pong extends Applet implements Runnable {
    int posX = 150, posY = 50, radius = 20;
    int directionX = 11, directionY = 9; // move directionX at posX axis and directionY at posY access

    Thread th;

    // start thread.
    public void init() {
        th = new Thread(this);
        th.start();
    }

    // Draw cicle from its present position.
    public void paint(Graphics g) {

        g.setColor(Color.RED);
        //g.fillOval(posX - radius, posY - radius, radius * 2, radius * 2);
		g.fillOval(posX % getWidth() , posY % getHeight() , radius * 2, radius * 2);
    }

    // move the image.
    public void run() {
        while (true) {
            // Bounce if we've hit an edge.
            if (posX - radius < 0) {
                directionX = 15;
                //System.out.println(" x ");
            }else if(posX + radius > getWidth()){
                directionX = -15;
                posX = getWidth() - radius;
                //System.out.println("else x");
            }
            if (posY - radius < 0) {
                //System.out.println(" y ");
                directionY = 15;
            }else if (posY + radius > getHeight()){
                directionY = -15;
                posY = getHeight() - radius;
                //System.out.println("else y");
            }
            
            // Move the circle.
            posX += directionX;
            posY += directionY;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
            repaint();
        }
    }
}
