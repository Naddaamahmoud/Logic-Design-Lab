/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.design.lab;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;

/**
 *
 * @author abade
 */
public class Xnor extends IC{
    
    
    

    public Xnor(String id, int x, int y){
        gui=new XnorGui(id,x,y);
        numberofinput=2;
        numberofoutput=1;
        this.id=id;
        input=new IC[numberofinput];
        output=new IC[numberofoutput];
        out_connected=new boolean[numberofoutput];
        input[0]=null;
        input[1]=null;
        output[0]=null;
        
        
        
        
    }
    void set_input(IC x,IC y)
    {
        input[0]=x;
        input[1]=y;
        process();
        
    }
    public boolean process()
    {
        if(input[0].process() && input[1].process()==false || input[1].process() && input[0].process()==false)
            return false;
        else 
            return true;
    }
    
    
}
