package Commands;

import Commands.Orders.*;
import Core.BusinessLayer;
import java.util.ArrayList;
import java.util.List;

public class CommandBroker {
    
    private List<Order> orderList = new ArrayList<Order>(); 

    public void takeOrder(Order order){
        orderList.add(order);		
    }

    //PDU to Order
    public void takeOrder(PDU p){
        
    }
    
    public void placeOrders(){
   
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    } 
    
    public Order PDUConverter(PDU message){
        Order result = null;
                
        if(message.type == (byte)0){
            result = new Hello(message);
        }
        if(message.type == (byte)1){
            result = new Register(message);
        }
             
        return result;
    }
}
