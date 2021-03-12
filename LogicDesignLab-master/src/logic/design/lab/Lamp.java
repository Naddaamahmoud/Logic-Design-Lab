/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.design.lab;

/**
 *
 * @author abade
 */
public class Lamp extends IC {
    Lampgui lampgu;
    

    public Lamp(String id,int x,int y) {
        gui=new Lampgui(id,x,y);
        lampgu=(Lampgui)gui;
        numberofinput=1;
        numberofoutput=1;
        this.id=id;
        input=new IC[numberofinput];
        output=new IC[numberofoutput];
        
        out_connected=new boolean[numberofoutput];
        input[0]=null;
        
        output[0]=null;
    }

    public void setInput(IC input) {
        this.input[0] = input;
    }
    
    public void set_onff(boolean st){
        lampgu.onof=st;
    }
    
    public boolean process()
    {
        if(input[0].process())
        {
            
            lampgu.onof=true;
            return true;
        }
            
        else
        {
            lampgu.onof=false;
            return false;
        }
    }
    
    
}
