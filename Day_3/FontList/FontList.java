import java.awt.*;

import javafx.scene.canvas.GraphicsContext;

import java.applet.Applet;

public class FontList extends Applet{
    public void paint(Graphics g){
        
        //GraphicsEnvironment object
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames(); //an array with the available fonts

        //to print
        for (int i = 0; i < fontNames.length; i++) {
            //set the font from the fontname array
            Font font = new Font(fontNames[i], Font.PLAIN, 14); 
            g.setFont(font); //set the draw string to be that selected font
            //finally draw the strig - the (100+(30*i) is to set space in the y axis
            g.drawString(fontNames[i], 20, (100+(30*i))); 
        }
    }
}