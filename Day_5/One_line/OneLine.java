import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class OneLine extends Applet {

    int currentXStart;
    int currentYStart;
    int currentXEnd;
    int currentYEnd;
    boolean mouseFlag;

    public void init() {

        currentXStart = 0;
        currentYStart = 0;
        currentXEnd = 0;
        currentYEnd = 0;
        mouseFlag = false;

        this.addMouseListener(new MouseListener() {

            public void mousePressed(MouseEvent e) {
                mouseFlag = true;
                currentXStart = e.getX();
                currentYStart = e.getY();
                //System.out.println("Pressed!");
            }

            public void mouseReleased(MouseEvent e) {
                //System.out.println("Released!");
                mouseFlag = false;
                currentXEnd = e.getX();
                currentYEnd = e.getY();
                if (currentXStart != currentXEnd && currentYStart != currentYEnd) {
                    repaint();
                }

            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {

            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                if (mouseFlag == true) {
                    currentXEnd = e.getX();
                    currentYEnd = e.getY();
                    // System.out.println("Dragged!");
                    if ((currentXStart != currentXEnd) && (currentYStart != currentYEnd)) {
                        repaint();
                    }
                }
            }
        });
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.drawLine(currentXStart, currentYStart, currentXEnd, currentYEnd);

    }

}
