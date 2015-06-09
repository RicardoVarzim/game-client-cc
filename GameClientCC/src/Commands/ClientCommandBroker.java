package Commands;

import Commands.Orders.AcceptChallenge;
import Commands.Orders.End;
import Commands.Orders.Hello;
import Commands.Orders.ListChallenges;
import Commands.Orders.Login;
import Commands.Orders.Logout;
import Commands.Orders.MakeChallenge;
import Commands.Orders.Quit;
import Commands.Orders.Register;
import Commands.Orders.RetransmitGame;
import java.util.ArrayList;
import java.util.List;

public class ClientCommandBroker {
    //create an object of SingleObject
    private static ClientCommandBroker instance = new ClientCommandBroker();
    
    private List<ClientOrder> _orderList ; 

    private ClientCommandBroker(){
        this._orderList = new ArrayList<ClientOrder>();
    }

    //Get the only object available
    public static ClientCommandBroker getInstance(){
        return instance;
    }
    
    public synchronized void takeOrder(ClientOrder order){
        _orderList.add(order);		
    }

    //PDU to Order
    public synchronized void takeOrder(PDU p){
        _orderList.add(PDUConverter(p));
    }
    
    public synchronized void placeOrders(){
   
        for (ClientOrder order : _orderList) {
            order.execute();
        }
        _orderList.clear();
    } 
    
    public ClientOrder PDUConverter(PDU message){
        ClientOrder result = null;
                
        if(message.type == (byte)1){
            result = new Hello(message);
        }
        if(message.type == (byte)2){
            result = new Register(message);
        }
        if(message.type == (byte)3){
            result = new Login(message);
        }
             
        //TODO: check bytes
        if(message.type == (byte)4){
            result = new Logout(message);
        }
        if(message.type == (byte)5){
            result = new Quit(message);
        }
        if(message.type == (byte)6){
            result = new End(message);
        }
        if(message.type == (byte)7){
            result = new ListChallenges(message);
        }
        if(message.type == (byte)8){
            result = new MakeChallenge(message);
        }
        if(message.type == (byte)9){
            result = new AcceptChallenge(message);
        }
        if(message.type == (byte)14){
            result = new RetransmitGame(message);
        }
        return result;
    }
}
