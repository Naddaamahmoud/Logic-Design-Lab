/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.design.lab;

/**
 *
 * @author Nad
 */
public class Input extends IC {

    int val;
    public Input(String id,int x, int y,int in) {
        val=in;
        if(in==1)
            gui=new InputGui1(id,x,y);
        else if(in==0)
            gui=new InputGui0(id,x,y);
        numberofinput=0;
        numberofoutput=1;
        this.id=id;
        input=new IC[numberofinput];
        output=new IC[numberofoutput];
    }
    @Override
    public boolean process() {
        
        return (val==1);
    }

}
 
  
