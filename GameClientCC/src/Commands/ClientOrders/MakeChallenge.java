package Commands.ClientOrders;

import Commands.Orders.*;
import Core.*;
import Core.ClientBusinessLayer;
import java.io.IOException;
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
        try {
            ArrayList<String> result = message.getFields();
            if(result.get(0) == "Challenge created"){
                System.out.println(result.get(0));
                //TODO: carregar Game
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeChallenge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MakeChallenge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
