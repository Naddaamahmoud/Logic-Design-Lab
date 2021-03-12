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
public class Decoder extends IC{
    
        private boolean[] inp=new boolean[numberofinput];
        private int out;
    public Decoder(String id,int x, int y) {
        gui=new DecoderGui(id,x,y);
        numberofinput=2;
        numberofoutput=4;
        this.id=id;
        input=new IC[numberofinput];
        output=new IC[numberofoutput];
        inp=new boolean[numberofinput];
        inp[0]=false;
        inp[1]=false;
        out=0;
     
    }

    public void setInp(boolean[] inp) {
        this.inp = inp;
    }
    
   

    @Override
    public boolean process() {
       int o=0;
       for(int i=0;i<numberofinput;i++){
           if(input[i].process()){
               o+=(int)Math.pow(2, i);
           }
       }
        return true;    
    }
    
     public int out_decoder() {
 
       for(int i=0;i<numberofinput;i++){
           if(inp[i]){
               out+=(int)Math.pow(2, i);
           }
       }
        return out;    
    }
   
  
}
