package Core;

import UDPClient.*;

public class GameClientCC {

    
    public static void main(String[] args) {
        
        
        //Start UDP
        UDPClient client = new UDPClient();
        new Thread(client).start();
    }
    
}
