package Commands;

import BusinessEntities.GameBE;
import BusinessEntities.UserBE;
import Core.*;
import java.util.ArrayList;
import java.util.Calendar;


public class CommandFactory {
    
    private int userID = 0;
    private DateParser dateParser = new DateParser();
    private ClientBusinessLayer business;
    
    public CommandFactory(){
        business = ClientBusinessLayer.getInstance();
        userID = business.getUser().getId();
    }
    
    public void setUserId(int id){
        this.userID = id;
    }
    
    /**COMMAND GENERATOR**/
    
    public PDU Hello(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)1,(byte)1,(short)1);
        return command;
    }
    
    public PDU Register(UserBE user){
        
        ArrayList<String> list = new ArrayList<>();
        list.add(user.getName());
        list.add(user.getPassword());
        byte[] listResult = dateParser.parserToByte(list);
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)2,(byte)1,(short)listResult.length, listResult);
        return command;
    }
    
    
     public PDU Login(UserBE user){
        ArrayList list = new ArrayList<>();
        list.add(user.getName());
        list.add(user.getPassword());
        byte[] listResult = dateParser.parserToByte(list);
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)3,(byte)2,(short)listResult.length, listResult);
        return command;
    }

    public PDU Logout() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)4,(byte)0,(short)0);
        return command;
    }

    public PDU Quit() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)5,(byte)0,(short)0);
        return command;
    }

    public PDU End() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)6,(byte)0,(short)0);
        return command;
    }

    public PDU List_challenges() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)7,(byte)0,(short)0);
        return command;
    }

    public PDU Make_challenge(GameBE game) {
        ArrayList list = new ArrayList<String>();
        list.add(game.getName());
        
        list.add(dateParser.calendarToString(game.getData()));
        
        byte[] listResult = dateParser.parserToByte(list);
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)8,(byte)2,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Accept_challenge(String game) {
        ArrayList list = new ArrayList<String>();
        list.add(game);
        byte[] listResult = dateParser.parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)9,(byte)1,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Delete_challenge(String game) {
        ArrayList list = new ArrayList<String>();
        list.add(game);
        byte[] listResult = dateParser.parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)10,(byte)1,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Answer(int gameId, String game, int questionId){
        ArrayList list = new ArrayList<String>();
        list.add(String.valueOf(gameId));
        list.add(game);
        list.add(String.valueOf(questionId));
        byte[] listResult = dateParser.parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)11,(byte)3,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU Retransmit(String game, int questionId, int packageId){
        ArrayList list = new ArrayList<String>();
        list.add(game);
        list.add(String.valueOf(questionId));
        list.add(String.valueOf(packageId));
        
        byte[] listResult = dateParser.parserToByte(list);
        
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)12,(byte)3,(short)listResult.length, listResult);
        return command;
    }
    
    public PDU List_ranking() {
        PDU command = new PDU((byte)0,(byte)0,(short)userID,(byte)13,(byte)0,(short)0);
        return command;
    }

}
