package Commands.Orders;

import Commands.PDU;
import Commands.ClientOrder;
import Core.ClientBusinessLayer;
import UI.Menu;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MakeChallenge implements ClientOrder {
    
    private ClientBusinessLayer business;
    private PDU message;
    
    public MakeChallenge(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        ArrayList<String> result = message.getFields();
        if("0".equals(result.get(0))){
            System.out.println("Desafio criado!");
            
        }else
            System.out.println("ERRO: Desafio não foi criado!");
        
        Menu menu = new Menu();
        menu.menu2();
        
    }
    
}
