package Core;

import Commands.CommandFactory;
import Commands.PDU;
import UDPClient.*;

public class GameClientCC {

    
    public static void main(String[] args) {
        
        CommandFactory maker = new CommandFactory();
        
        //SendPDU
        UDPClient client = new UDPClient(maker.Register());
        new Thread(client).start();
    }
    
}
