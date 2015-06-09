/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Orders;

import BusinessEntities.GameBE;
import BusinessEntities.QuestionBE;
import Commands.PDU;
import Commands.ClientOrder;
import Commands.Orders.*;
import Core.*;
import Core.ClientBusinessLayer;
import UI.Menu;
import java.util.ArrayList;


/**
 *
 * @author Ricardo
 */
public class RetransmitGame implements ClientOrder {
    
    private ClientBusinessLayer business;
    private PDU message;
    
    public RetransmitGame(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        ArrayList<String> fields = message.getFields();
        ArrayList<QuestionBE> question;
        int i;
        for(i=1;i<=10;i++)
            question=fields.get(i);
       business.retransmitGame(question);
              
        
    }
    
}
