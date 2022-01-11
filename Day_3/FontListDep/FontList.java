import java.awt.*;
import java.applet.Applet;

public class FontList extends Applet{
    public void paint(Graphics g){
        String[] fontNames = Toolkit.getDefaultToolkit().getFontList();
        for (int i = 0; i < fontNames.length; i++) {
            Font font = new Font(fontNames[i], Font.PLAIN, 14);
            g.setFont(font);
            g.drawString(fontNames[i], 30, (100+(30*i)));
        }
    }
}