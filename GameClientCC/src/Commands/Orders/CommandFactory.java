package Commands.Orders;

import BusinessEntities.GameBE;
import BusinessEntities.UserBE;
import Core.ClientBusinessLayer;
import java.util.ArrayList;
import java.util.Calendar;


public class CommandFactory {
    
    private int userID;
    
    public CommandFactory(){
        userID = ClientBusinessLayer.getInstance().getUser().id;
    }
    /**PRIVATE METHODS**/
    
    private byte[] parserToByte(ArrayList list) {
        String data = "";
        for (Object item : list) {
            data = data +";"+ (String) item;
        }
        return data.getBytes();
    }
    
    /**COMMAND GENERATOR**/
    
    public PDU Hello(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)1,(byte)1,(short)1, null);
        return command;
    }
    
    public PDU Register(UserBE user){
        ArrayList list = new ArrayList<>();
        list.add(user.getName());
        list.add(user.getPassword());
        byte[] listResult = parserToByte(list);
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)2,(byte)1,(short)listResult.length, listResult);
        return command;
    }
    
    
     public PDU Login(UserBE user){
        ArrayList list = new ArrayList<>();
        list.add(user.getName());
        list.add(user.getPassword());
        byte[] listResult = parserToByte(list);
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)3,(byte)2,(short)listResult.length, listResult);
        return command;
    }

    public PDU Logout() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)4,(byte)0,(short)0, null);
        return command;
    }

    public PDU Quit() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)5,(byte)0,(short)0, null);
        return command;
    }

    public PDU End() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)6,(byte)0,(short)0, null);
        return command;
    }

    public PDU List_challenges() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)7,(byte)0,(short)0, null);
        return command;
    }

    public PDU Make_challenge(GameBE game) {
        ArrayList list = new ArrayList<String>();
        list.add(game.getName());
        //TODO: MAKE PARSER
        Calendar gcalendar = game.getData();
        int year = gcalendar.get(Calendar.YEAR)*10000;
        int month = gcalendar.get(Calendar.MONTH)*100;
        int day = gcalendar.get(Calendar.DAY_OF_MONTH);
        String data=String.valueOf(year+month+day);
        list.add(data);
        int hora = gcalendar.get(Calendar.HOUR_OF_DAY)*10000;
        int minuto = gcalendar.get(Calendar.MINUTE)*100;
        int segundo = gcalendar.get(Calendar.SECOND);
        String hour = String.valueOf(hora+minuto+segundo);
        list.add(hour);
        
        byte[] listResult = parserToByte(list);
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)8,(byte)3,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Accept_challenge(String game) {
        ArrayList list = new ArrayList<String>();
        list.add(game);
        byte[] listResult = parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)9,(byte)1,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Delete_challenge(String game) {
        ArrayList list = new ArrayList<String>();
        list.add(game);
        byte[] listResult = parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)10,(byte)1,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Answer(int gameId, String game, int questionId){
        ArrayList list = new ArrayList<String>();
        list.add(String.valueOf(gameId));
        list.add(game);
        list.add(String.valueOf(questionId));
        byte[] listResult = parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)11,(byte)3,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Retransmit(String game, int questionId, int packageId){
        ArrayList list = new ArrayList<String>();
        list.add(game);
        list.add(String.valueOf(questionId));
        list.add(String.valueOf(packageId));
        
        byte[] listResult = parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)12,(byte)3,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU List_ranking() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)13,(byte)0,(short)0, null);
        return command;
    }

}
