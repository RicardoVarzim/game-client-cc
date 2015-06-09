package Commands.Orders;

import Commands.PDU;
import Commands.ClientOrder;
import Core.ClientBusinessLayer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteChallenge implements ClientOrder {
    
    private ClientBusinessLayer business;
    private PDU message;
    
    public DeleteChallenge(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        String temp = message.getFields().get(0);
        if(temp.matches("0"))
            System.out.println("Desafio eleminado!");
        else
            System.out.println("Erro desafio não foi eleminado!");
        
    }
    
}
