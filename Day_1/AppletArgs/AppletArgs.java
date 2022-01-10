import java.applet.Applet;
import java.awt.Graphics;

public class AppletArgs extends Applet {
    public void paint(Graphics g) {
		String str = getParameter("msg");
        g.drawString(str, 50, 25);
    }
}