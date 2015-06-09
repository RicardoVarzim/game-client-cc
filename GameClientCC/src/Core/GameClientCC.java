package Core;
import UI.Menu;

public class GameClientCC {

    
    public static void main(String[] args) {
        
        ClientBusinessLayer business = ClientBusinessLayer.getInstance();
        business.hello();
        
        Menu menu = new Menu();
        menu.start();
       
        
    }
    
}
