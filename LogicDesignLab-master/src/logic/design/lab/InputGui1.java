/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.design.lab;

import java.awt.*;

/**
 *
 * @author Nad
 */
public class InputGui1 extends Component{
    String id;
    int x;
    int y;

    public InputGui1(String id, int x, int y) {
        
        this.id = id;
        this.x = x;
        this.y = y;
        this.setBounds(x, y, 92, 55);
        this.setSize(92,55);
        
    }
    
    
    @Override
    public void paint(Graphics g)
    {
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image img = t.getImage("in-1.png");
        g.drawImage(img,0,0,this);
        g.drawString(id, 20, 20);     
    }
}
