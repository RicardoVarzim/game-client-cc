package Core;

import UDPClient.*;

public class GameClientCC {

    
    public static void main(String[] args) {
        
        UDPClient client = new UDPClient();
        new Thread(client).start();
    }
    
}
