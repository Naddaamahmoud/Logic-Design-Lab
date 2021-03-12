/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.design.lab;
import java.awt.*;

import java.awt.Component;

/**
 *
 * @author abade
 */
public class Lampgui extends Component {
    String id;
    int x;
    int y;
    protected boolean onof;

    public Lampgui(String id, int x, int y) {
        
        this.id = id;
        this.x = x;
        this.y = y;
        this.setBounds(x, y, 92, 55);
        this.setSize(180,155);
        
    }
    
    
    @Override
    public void paint(Graphics g)
    {
        Toolkit t=Toolkit.getDefaultToolkit(); 
        Image img;
        if(onof)
            img = t.getImage("lampon.png");
        else
            img = t.getImage("lampof.png");
            
        g.drawImage(img,0,0,this);
        g.drawString(id, 20, 20);
        
        
        
        
        
    }
    
}
