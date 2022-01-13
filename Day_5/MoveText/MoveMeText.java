package MoveText;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MoveMeText extends Applet{
    int column, row;
    String text = "Move me around";
    int stringWidth;

    //initialize the events
    public void init(){
        column = getWidth()/2;
        row = getHeight()/2;
		
		setFocusable(true);
		requestFocusInWindow();

        this.addKeyListener(
            new KeyListener(){

                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                        if(column+10 < getWidth()-stringWidth){
                          column+=10;
                          repaint();
                        }
                      }
                      if(e.getKeyCode() == KeyEvent.VK_LEFT ){
                        if(column-10 > 10){
                          column-=10;
                          repaint();
                        }
                      }
                      if(e.getKeyCode() == KeyEvent.VK_UP){
                        if(row > 10){
                          row-=10;
                          repaint();
                        }
                      }
                      if(e.getKeyCode() == KeyEvent.VK_DOWN){
                        if(row < getHeight()-10){
                          row+=10;
                          repaint();
                        }
                      }
                }

                public void keyTyped(KeyEvent e) {}
                public void keyReleased(KeyEvent e) {}
                
            }
        );
    }

    //type the string
    public void paint(Graphics g){
        stringWidth = g.getFontMetrics().stringWidth(text);
        g.drawString(text, column, row);
    }

}
