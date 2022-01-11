import java.awt.*;
import java.applet.Applet;

public class Lamp extends Applet{
    public void paint(Graphics g){
        
        Color c = new Color(255,255,150); //to get the color of the ovals
        g.setColor(c);

        g.fillOval(100,75,300,50); //main oval colored
        

		g.fillOval(200,175,100,200); //center internal oval
        

        //left and right ovals and their shadows 
		g.fillOval(75,220,50,100);
		g.fillOval(375,220,50,100);
        
        
        g.setColor(Color.BLACK); //for the outline and lines

        g.drawOval(100,75,301,51); //main oval outer shadow
        g.drawOval(200,175,101,201); //center oval outer shadow
        g.drawOval(75,220,51,101);  //left oval
		g.drawOval(375,220,51,101); //right oval
    
        //lower lines
        g.drawLine(50,350,100,100);
		g.drawLine(450,350,400,100);

		g.drawArc(50,300,400,100,180,180); //Please don't edit

		g.drawLine(200,500,240,400); //left
		g.drawLine(290,500,250,400); //right

		g.drawRect(100,500,300,30); //bootom rectangle
    }
}