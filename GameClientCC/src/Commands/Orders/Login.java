/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Orders;

import BusinessEntities.UserBE;
import Commands.PDU;
import Commands.ClientOrder;
import Commands.Orders.*;
import Core.*;
import UI.Menu;

/**
 *
 * @author Ricardo
 */
public class Login implements ClientOrder {

    private ClientBusinessLayer business;
    private PDU message;
    
    public Login(PDU message){
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }
    
    @Override
    public void execute() {
        String temp = message.getFields().get(0);
        Menu menu = new Menu();
            
        if(temp.matches("0")){
            
            UserBE user = business.getUser();
            user.setId(message.label);
            user.setLoggedIn(true);
            business.setUser(user);
            
            System.out.println("Login efectuado!");
            menu.menu2();
        }
        else{
            System.out.println("Erro no Login!");
            menu.start();
        }
            
    }
    
}
