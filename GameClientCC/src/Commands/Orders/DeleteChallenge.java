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
        try {
            ArrayList<String> result = message.getFields();
            if(result.get(0) == "Challenge created"){
                System.out.println(result.get(0));
                //TODO: carregar Game
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteChallenge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
