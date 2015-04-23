/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class CommandFactory {
    
    public CommandFactory(){
        
    }
    
    public PDU Register(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)2,(byte)1,(short)1,new ArrayList<String>());
        return command;
    }
    
     public PDU Hello(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)1,(byte)1,(short)1,new ArrayList<String>());
        return command;
    }
}
