package Count;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Counter extends Applet{
    int x = 0;
    //initiallizing the buttons and actions
    public void init(){
        Button increment = new Button("increment");
        increment.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    x++;
                    repaint();
                }
        });
        add(increment); //add the first button
        Button decrement = new Button("decrement");
        decrement.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ev){
                    x--;
                    repaint();
                }
            }
        );
        add(decrement); //add the second button
    }
    public void paint(Graphics g){
        g.drawString("Click count     " + x, 100, 200);
    }
}