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
public class Not extends IC{
    
    
    

    public Not(String id, int x, int y){
        gui=new NotGui(id,x,y);
        numberofinput=1;
        numberofoutput=1;
        this.id=id;
        input=new IC[numberofinput];
        output=new IC[numberofoutput];
        out_connected=new boolean[numberofoutput];
       
        out_connected=new boolean[numberofoutput];
        input[0]=null;
        output[0]=null;
        
        
        
        
    }
    void set_input(IC x)
    {
        input[0]=x;
        process();
        
    }
    public boolean process()
    {
        if(input[0].process())
            return false;
        else 
            return true;
    }
    
    
}
