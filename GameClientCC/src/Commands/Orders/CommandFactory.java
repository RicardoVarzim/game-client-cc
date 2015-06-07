/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Orders;

import BusinessEntities.GameBE;
import BusinessEntities.UserBE;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class CommandFactory {
    
    public CommandFactory(){
        
    }
    
    public PDU Hello(){
        
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)1,(byte)1,(short)1,new ArrayList<>());
        return command;
    }
    
    public PDU Register(UserBE user){
        ArrayList list = new ArrayList<String>();
        list.add(user.getName());
        list.add(user.getPassword());
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)2,(byte)1,(short)1, list);
        return command;
    }
    
    
     public PDU Login(UserBE user){
        ArrayList list = new ArrayList<String>();
        list.add(user.getName());
        list.add(user.getPassword());
        //TODO:
        int size = 10;
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)3,(byte)2,(short)size, list);
        return command;
    }

    public PDU Logout() {
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)4,(byte)0,(short)0, null);
        return command;
    }

    public PDU Quit() {
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)5,(byte)0,(short)0, null);
        return command;
    }

    public PDU End() {
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)6,(byte)0,(short)0, null);
        return command;
    }

    public PDU List_challenges() {
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)7,(byte)0,(short)0, null);
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
        //TODO: sizeof(list)
        int size = 10;
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)8,(byte)3,(short)size, list);
        return command;
    }
    
    public PDU Accept_challenge(String game) {
        ArrayList list = new ArrayList<String>();
        list.add(game);
         //TODO: sizeof(list)
        int size = 10;
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)9,(byte)1,(short)size, list);
        return command;
    }
    
    public PDU Delete_challenge(String game) {
        ArrayList list = new ArrayList<String>();
        list.add(game);
         //TODO: sizeof(list)
        int size = 10;
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)10,(byte)1,(short)size, list);
        return command;
    }
    
    public PDU Answer(int gameId, String game, int questionId){
        ArrayList list = new ArrayList<String>();
        list.add(String.valueOf(gameId));
        list.add(game);
        list.add(String.valueOf(questionId));
         //TODO: sizeof(list)
        int size = 10;
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)11,(byte)3,(short)size, list);
        return command;
    }
    
    public PDU Retransmit(String game, int questionId, int packageId){
        ArrayList list = new ArrayList<String>();
        list.add(game);
        list.add(String.valueOf(questionId));
        list.add(String.valueOf(packageId));
        
         //TODO: sizeof(list)
        int size = 10;
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)12,(byte)3,(short)size, list);
        return command;
    }
    
    public PDU List_ranking() {
        PDU command = new PDU((byte)0,(byte)0,(short)1,(byte)13,(byte)0,(short)0, null);
        return command;
    }
}
