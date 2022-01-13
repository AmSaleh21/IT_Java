import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class DragBall extends Applet{
    
  int  currentX ;
  int  currentY ;
  boolean mouseFlag;
  int radius = 50;


  public void init(){

    currentX = getWidth()/2 ;
    currentY = getHeight()/2 ;
	mouseFlag = false; //flag to check if the click is valid

      this.addMouseListener(new MouseListener(){
                    public void mousePressed(MouseEvent e){
						//check if the click is inside the border and set the flag to true
                      if(e.getX() >=  currentX   && e.getX() <  currentX+radius
                         && e.getY() >=  currentY   && e.getY() <   currentY+radius){
                         mouseFlag = true ;
                         //System.out.println(currentX + "<x  y>" + currentY);
                      }
                      if(e.getX() < getWidth() && e.getY() < getHeight()){ //make the ball center at the click
                          mouseFlag = true;
                          //System.out.println("width height if");
                          currentX = e.getX()-(radius/2);
                          currentY = e.getY()-(radius/2);
                          repaint();
                      }
                    }
                    
                    public void mouseReleased(MouseEvent e){ //leave when mouse release
                        //System.out.println("Released!");
                        mouseFlag = false ;
                    }

                    public void mouseClicked(MouseEvent e){}
                    public void mouseEntered(MouseEvent e){}
                    public void mouseExited(MouseEvent e){}
      });

      this.addMouseMotionListener(new MouseMotionListener(){
          public void mouseMoved(MouseEvent e){}
                    
					//if the said flag ^ is true then the ball is at the mouse pointer, start moving
                    public void mouseDragged(MouseEvent e){
                      if(mouseFlag == true){
                         currentX = e.getX()-(radius/2);
                         currentY = e.getY()-(radius/2);
                        //System.out.println("Dragged!");
                        if( currentX <= getWidth()-60 &&
                            currentY < getHeight()-60 &&
                            currentX > 0 && currentY >0){
                             repaint();
                        }
                      }
                    }
      });
    }

	//paint the ball (equal radius oval)
  public void paint(Graphics g){
      g.setColor(Color.BLUE);
      g.fillOval( currentX, currentY,radius,radius);

  }   
}