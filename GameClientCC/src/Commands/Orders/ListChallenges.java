/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Orders;

import Commands.PDU;
import Commands.ClientOrder;
import Commands.Orders.*;
import Core.*;
import Core.ClientBusinessLayer;

/**
 *
 * @author Ricardo
 */
public class ListChallenges implements ClientOrder {

    private ClientBusinessLayer business;
    private PDU message;
    
    public ListChallenges(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        for(String item : message.getFields()){
            System.out.println(item);
        }
        
    }
    
}
