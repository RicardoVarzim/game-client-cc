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
import UDPClient.UDPClient;
import UI.Menu;

/**
 *
 * @author Ricardo
 */
public class Register implements ClientOrder {

    private ClientBusinessLayer business;
    private PDU message;
    
    public Register(PDU message){
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }
    
    @Override
    public void execute() {
        String temp = message.getFields().get(0);
        if(temp.matches("0"))
            System.out.println("Registo efectuado!");
        else
            System.out.println("Erro no Registo!");
        
        Menu menu = new Menu();
        menu.start();
        
    }
    
}
