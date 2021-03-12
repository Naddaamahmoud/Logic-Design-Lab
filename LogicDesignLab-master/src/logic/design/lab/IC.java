/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.design.lab;

import java.awt.Component;

/**
 *
 * @author abade
 */
public abstract class IC {
    protected IC[] input;
    protected IC[] output;
    public boolean[] out_connected;
    public int numberofinput;
    public int numberofoutput;
    public String id;
    Component gui;
    public abstract boolean  process();
    
}
