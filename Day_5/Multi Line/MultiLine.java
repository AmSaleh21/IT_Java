import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class MultiLine extends Applet {

    int currentXStart;
    int currentYStart;
    int currentXEnd;
    int currentYEnd;
    boolean mouseFlag;
    List<Shape> list;

    boolean flagForLine;
    boolean flagForOvalOrCircle;

    class Shape {
        int x1, y1, x2, y2;
        public void draw(int x1, int y1, int x2, int y2) {}
    }

    class SavedPoints extends Shape {

        public void draw(int x1, int y1, int x2, int y2) {
            Graphics g = MultiLine.this.getGraphics();
            g.drawLine(x1, y1, x2, y2);
        }
    }

    class SavedOval extends Shape {

        public void draw(int x1, int y1, int x2, int y2) {
            Graphics g = MultiLine.this.getGraphics();
            g.fillOval(x1, y1, x2, y2);
        }
    }

    public void init() {

        currentXStart = 0;
        currentYStart = 0;
        currentXEnd = 0;
        currentYEnd = 0;
        mouseFlag = false;

        flagForLine = true;
        flagForOvalOrCircle = false;
        list = new ArrayList<Shape>();

        this.addMouseListener(new MouseListener() {

            public void mousePressed(MouseEvent e) {

                mouseFlag = true;
                currentXStart = e.getX();
                currentYStart = e.getY();
                //System.out.println("Pressed!");
            }

            public void mouseReleased(MouseEvent e) {
                
                //System.out.println("Released!");

                currentXEnd = e.getX();
                currentYEnd = e.getY();
                if (currentXStart != currentXEnd && currentYStart != currentYEnd) {

                    mouseFlag = false;
                    Shape line = new Shape();
                    line.x1 = currentXStart;
                    line.y1 = currentYStart;
                    line.x2 = currentXEnd;
                    line.y2 = currentYEnd;
                    list.add(line);
                    repaint();

                }

            }

            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}

        });

        this.addMouseMotionListener(new MouseMotionListener() {

            public void mouseMoved(MouseEvent e) {}

            public void mouseDragged(MouseEvent e) {
                if (mouseFlag == true) {
                    currentXEnd = e.getX();
                    currentYEnd = e.getY();
                    //System.out.println("Dragged!");
                    if ((currentXStart != currentXEnd) && (currentYStart != currentYEnd)) {
                        repaint();
                    }
                }
            }
        });

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);

        for (Shape shape : list) {
            g.drawLine(shape.x1, shape.y1, shape.x2, shape.y2);
        }

        Shape shape = new Shape();

        if (flagForLine == true) {
            shape = new SavedPoints();
        } else if (flagForOvalOrCircle == true) {
            shape = new SavedOval();
        }

        shape.draw(currentXStart, currentYStart, currentXEnd, currentYEnd);

    }
}