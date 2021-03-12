/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.design.lab;

import java.awt.*;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author abade
 */
public class Circutgui  extends javax.swing.JFrame {
    String numberofgates="0";
    JButton addgates=new JButton("add gate");
    JButton getoutput=new JButton("get output");
    JComboBox gateplacecb;
    JComboBox gateselctioncb;
    JComboBox inputoutput;
    ArrayList<IC> components;
    ArrayList wires;
    String lastaddedgate;
    boolean decoder_bln=false;
    
    

    public Circutgui(String startgate){
        
        this.getContentPane().setBackground(Color.white);
        components=new ArrayList<IC>();
        
        this.setSize(1000, 800);
        this.setLayout(null);
        
        if(startgate.equals("Decoder")){
            decoder_bln=true;
            Decoder decoder =new Decoder("0", 300, 200);
            this.add(decoder.gui);
            components.add(decoder);
            decoder.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
        
            Lamp lamp1=new Lamp("1",590,234);
            this.add(lamp1.gui);
            components.add(lamp1);
            lamp1.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
       
            Lamp lamp2=new Lamp("2",590,303);
            this.add(lamp2.gui);
            components.add(lamp2);
            lamp2.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
           
            Lamp lamp3=new Lamp("3",590,360);
            this.add(lamp3.gui);
            components.add(lamp3);
            lamp3.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            
            Lamp lamp4=new Lamp("4",590,423);
            this.add(lamp4.gui);
            components.add(lamp4);
            lamp4.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            
            
       JTextArea in1=new JTextArea("input 1:");
         this.add(in1);
        in1.setBounds(20, 600, WIDTH, HEIGHT);
        in1.setSize(100,50);  
        in1.setEditable(false);
        in1.setVisible(true); 
        
         JTextArea in2=new JTextArea("input 2:");
         this.add(in2);
        in2.setBounds(20, 650, WIDTH, HEIGHT);
        in2.setSize(100,30);  
        in2.setEditable(false);
        in2.setVisible(true); 
        
        String gateselctioncbstrs[]={"choose gate","Input 0","Input 1"};
        
         JComboBox in1_cbx;
        in1_cbx=new JComboBox(gateselctioncbstrs);
        in1_cbx.setBounds(140,600,100,25);
        in1_cbx.setVisible(true);
        this.add(in1_cbx);
         
        JComboBox in2_cbx;
         in2_cbx=new JComboBox(gateselctioncbstrs);
        in2_cbx.setBounds(140,650,100,25);
        in2_cbx.setVisible(true);
        this.add(in2_cbx);

        
        this.add(addgates);
        addgates.setBounds(20, 700, WIDTH, HEIGHT);
        addgates.setSize(100,50);  
        addgates.setVisible(true);
        
       

        
        addgates.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             
                String inp1=in1_cbx.getSelectedItem().toString();
                String inp2=in2_cbx.getSelectedItem().toString();
                boolean[] inp=new boolean [2];
                if(inp1.equals("Input 1")){
                
            add_gatefn(null,inp1,230,265,"input");
            inp[0]=true;
                  
                }
                else{
                    add_gatefn(null,inp1,230,265,"input");
                   inp[0]=false;
                }
                
                if(inp2.equals("Input 1")){
                
            add_gatefn(null,inp2,230,375,"input");
                    inp[1]=true;
                }
                else{
                    add_gatefn(null,inp2,230,375,"input");
                    inp[1]=false;
                }
                
                decoder.setInp(inp);
                 int out=decoder.out_decoder();
                System.out.print(out);
                
             
                System.out.println(out);
                switch (out) {
                    case 0:
                        lamp1.set_onff(true);
                        repaint();
                        break;
                    case 1:
                        lamp2.set_onff(true);
                        repaint();
                        break;
                    case 2:
                        lamp3.set_onff(true);
                        repaint();
                        break;
                    case 3:
                        lamp4.set_onff(true);
                        repaint();
                        break;
                    default:
                        break;
                }
                
           
                
            }});
        
           
      
        
        }
        else{
        this.add(addgates);
        addgates.setBounds(20, 700, WIDTH, HEIGHT);
        addgates.setSize(100,50);  
        addgates.setVisible(true);
        this.add(getoutput);
        getoutput.setBounds(400, 700, WIDTH, HEIGHT);
        getoutput.setSize(100,50);  
        getoutput.setVisible(true);
        
        String gatesidstrs[]={"gate id"};
        gateplacecb=new JComboBox(gatesidstrs);
        gateplacecb.setBounds(20,610,100,25);
        gateplacecb.setVisible(true);
        this.add(gateplacecb);
        
        
        String gateselctioncbstrs[]={"choose gate","And Gate","Input 0","Input 1","Or Gate", "Not Gate", "Xor Gate", "Nand Gate", "Nor Gate", "Xnor Gate","lamp"};
        gateselctioncb=new JComboBox(gateselctioncbstrs);
        gateselctioncb.setBounds(20,640,100,25);
        gateselctioncb.setVisible(true);
        this.add(gateselctioncb);
        
        String inout[]={"choose place","input","output"};
        inputoutput=new JComboBox(inout);
        inputoutput.setBounds(20,670,100,25);
        inputoutput.setVisible(true);
        this.add(inputoutput);
        add_gatefn(null,startgate,400,350,null);
        
        
        addgates.addActionListener(new ActionListener(){
            private Component Circutgui;
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String placeid=gateplacecb.getSelectedItem().toString();
                String gatesel=gateselctioncb.getSelectedItem().toString();
                String pos=inputoutput.getSelectedItem().toString();
                IC parent=getgate(placeid);
                int x=0,y=0;
                if(pos.equals("input"))
                {
                    
                    
                     x=parent.gui.getX()-145;
                     try
                    {
                      IC temp=getgate(placeid);   
                     if(temp.getClass().equals(Input.class)||temp.getClass().equals(Input.class)){
                         throw new InvalidDataException("Can't add input to inputs 1 and 0");
                     }
                     if(gatesel=="lamp")
                     {
                         throw new InvalidDataException("Can't add lamp as input");
                     }
                     if(temp.getClass().equals(Lamp.class)||temp.getClass()==Not.class&&parent.input[0]!=null){
                          throw new InvalidDataException("Can't add another input");
                     }
                     if(parent.input[0]==null)
                        {
                            y=parent.gui.getY()+50+65;
                            if(gatesel.equals("Input 0")||gatesel.equals("Input 1")||gatesel.equals("Not Gate")){
                                x=parent.gui.getX()-90;
                                y=parent.gui.getY()-14+65+34;
                                
                            }
                            if(parent.getClass()==Not.class)
                            {
                                y-=85;
                            }
                            
                            add_gatefn(parent,gatesel,x,y,"input");
                            
                        }
                     else if(parent.input[1]==null)
                        {
                             y=parent.gui.getY()-50-65;
                             if(gatesel.equals("Input 0")||gatesel.equals("Input 1")||gatesel.equals("Not Gate")){
                                x=parent.gui.getX()-90;
                               y=parent.gui.getY()-14;
                            }
                              add_gatefn(parent,gatesel,x,y,"input");
                        }
                     
                     else if(parent.input[0]!=null && parent.input[1]!=null)
                     {
                         throw new InvalidDataException("All inputs are used for this gate");
                     }
                     }
                     catch(InvalidDataException inv){
                        JOptionPane.showMessageDialog(Circutgui,inv.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                     }
                           
                }
                if(pos.equals("output"))
                {
                    try{
                    IC temp=getgate(placeid);
                    if(temp.getClass().equals(Lamp.class)||temp.getClass().equals(Lamp.class)){
                         throw new InvalidDataException("Can't add outputs to lamps");
                     }
                    if("Input 0".equals(gatesel) || "Input 1".equals(gatesel))
                     {
                         throw new InvalidDataException("Can't add input as output");
                     }
                    if(parent.output[0]==null)
                    {
                        
                        if(gatesel.equals("Not Gate")||gatesel.equals("lamp")){
                            x=parent.gui.getX()+149;
                            y=parent.gui.getY()+37;
                            if(gatesel.equals("lamp"))
                            {
                                x-=3;
                                y-=4;
                                       
                            
                            }
                        }
                        else{
                        x=parent.gui.getX()+140;
                        y=parent.gui.getY()-50;
                     
                        }
                        add_gatefn(parent,gatesel,x,y,"output");
                    }
                    else{
                        throw new InvalidDataException("Output for this gate is already used");
                    }
                    }
                    catch(InvalidDataException inv){
                        JOptionPane.showMessageDialog(Circutgui,inv.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
                
               
                
                
            }
    
        });
        
        getoutput.addActionListener(new ActionListener()
        {
            private Component Circutgui;
            boolean flag=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                for(int i=0;i<components.size();i++)
                {
                    if(components.get(i).getClass()==Lamp.class)
                    {
                        components.get(i).process();
                        repaint();
                        flag=true;
                    }
                } 
                if(flag==false){
                    throw new InvalidDataException("Please add a lamp");
                }
                }
                catch(InvalidDataException inv){
                    JOptionPane.showMessageDialog(Circutgui,inv.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
        }
    
        });
       
         
        
    }   
    }
    private void add_gatefn(IC parent,String gatename,int x,int y,String io)
    {
        if(gatename.equals("And Gate"))
        {   
           
            And and=new And(numberofgates,x,y);
            
            
            this.add(and.gui);
            
            components.add(and);
            and.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=and;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=and;
                    and.input[0]=parent;
                }
            }
            

        }
       else if(gatename=="Input 0")
        {   
           
            Input in=new Input(numberofgates,x,y,0);
            
            
            this.add(in.gui);
            
            components.add(in);
            in.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=in;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=in;
                    in.input[0]=parent;
                }
            }
            
            
        
        }
        else if(gatename=="Input 1")
        {   
           
            Input in=new Input(numberofgates,x,y,1);
            
            
            this.add(in.gui);
            
            components.add(in);
            in.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=in;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=in;
                    in.input[0]=parent;
                }
            }
            
            
        
        }
        else if(gatename.equals("Or Gate")){
            
            Or or=new Or(numberofgates,x,y);
            
            
            this.add(or.gui);
            
            components.add(or);
            or.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=or;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=or;
                    or.input[0]=parent;
                }
            }
        }
        else if(gatename.equals("Not Gate")){
            Not not=new Not(numberofgates,x,y);
            this.add(not.gui);
            
            components.add(not);
            not.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=not;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=not;
                    not.input[0]=parent;
                }
            }
        }
        else if(gatename.equals("Xor Gate")){
            Xor xor=new Xor(numberofgates,x,y);
            this.add(xor.gui);
            
            components.add(xor);
            xor.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=xor;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=xor;
                    xor.input[0]=parent;
                }
            }
        }
        else if(gatename.equals("Nand Gate")){
            Nand nand=new Nand(numberofgates,x,y);
            this.add(nand.gui);
            
            components.add(nand);
            nand.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=nand;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=nand;
                    nand.input[0]=parent;
                }
            }
        }
        else if(gatename.equals("Nor Gate")){
            Nor nor=new Nor(numberofgates,x,y);
            this.add(nor.gui);
            
            components.add(nor);
            nor.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=nor;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=nor;
                    nor.input[0]=parent;
                }
            }
        }
        else if(gatename.equals("Xnor Gate")){
            Xnor xnor=new Xnor(numberofgates,x,y);
            this.add(xnor.gui);
            
            components.add(xnor);
            xnor.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                if(io=="input")
                {
                    for(int i=0;i<parent.numberofinput;i++)
                    {
                        if(parent.input[i]==null)
                        {
                            parent.input[i]=xnor;
                            break;
                        }
                    }
                }
                else if(io=="output")
                {
                    parent.output[0]=xnor;
                    xnor.input[0]=parent;
                }
            }
        }
        else if(gatename.equals("lamp")){
            Lamp lamp=new Lamp(numberofgates,x,y);
            this.add(lamp.gui);
            
            components.add(lamp);
            lamp.gui.setVisible(true);
            this.setVisible(true);
            this.repaint();
            if(parent!=null)
            {
                
                
                    parent.output[0]=lamp;
                    lamp.input[0]=parent;
                
            }
        }
   
        if(!decoder_bln){
        int num=Integer.parseInt(numberofgates);
        gateplacecb.addItem(numberofgates);
        lastaddedgate=numberofgates;
        num++;
        numberofgates=Integer.toString(num);
        }  
      
        
        
    }
    
    private IC getgate(String id)
    {
        
        for(int i=0;i<components.size();i++)
        {
           if(components.get(i).id.equals(id))
           {
              
               return components.get(i);
           }
        }
        
        return null;
    }
    
    
}
