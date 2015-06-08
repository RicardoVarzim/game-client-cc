package Commands.Orders;

import Commands.PDU;
import Commands.ClientOrder;
import Core.ClientBusinessLayer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Answer implements ClientOrder {
    
    private ClientBusinessLayer business;
    private PDU message;
    
    public Answer(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        
        
    }
    
}
