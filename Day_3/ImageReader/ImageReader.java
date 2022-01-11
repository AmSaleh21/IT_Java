import java.awt.*;
import java.applet.Applet;

public class ImageReader extends Applet{
    Image myImage;
    public void init(){
        myImage = getImage(getDocumentBase(), "myImage.png");
    }
    public void paint(Graphics g){
        g.drawImage(myImage, 0, 0, getWidth(), getHeight(), this);
    }
}