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
import UI.Menu;

/**
 *
 * @author Ricardo
 */
public class AcceptChallenge implements ClientOrder {

    private ClientBusinessLayer business;
    private PDU message;
    
    public AcceptChallenge(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        Menu menu = new Menu();
        String temp = message.getFields().get(0);
        if(temp.matches("0")){
            System.out.println("Desafio aceite!");
            

            //Pedido para obter jogo
            
            //business.retransmitGame(message.getFields().get(1));
            
            //menu.waitForGame();
        }
        else{
            System.out.println("Erro na aceitação do desafio!");
            menu.menu2();
        }
            
    }
    
}
