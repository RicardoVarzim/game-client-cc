/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Ricardo
 */
public class DateParser {
    
    public DateParser(){
        
    }
    
    public byte[] calendarToByte(Calendar gcalendar) {
        
        ArrayList list = new ArrayList<String>();
        
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
        return listResult;
    }
    
    public Calendar byteToCalendar(byte[] dados){
        String temp = new String(dados);
        String data = temp.substring(0,6);
        String hora = temp.substring(7,13);
        int ano, mes, dia, hour, min, seg;

        Integer.parseInt(data);
        ano = 2000 + Integer.parseInt(data.substring(0, 2));
        mes = Integer.parseInt(data.substring(2, 4));
        dia = Integer.parseInt(data.substring(4));
        Integer.parseInt(hora);
        hour = Integer.parseInt(hora.substring(0, 2));
        min = Integer.parseInt(hora.substring(2, 4));
        seg = Integer.parseInt(hora.substring(4));
        
        GregorianCalendar gcalendar = new GregorianCalendar(ano+2000, mes, dia, hour, min, seg);
        
        return gcalendar;
    }
    
     public GregorianCalendar stringToCalendar(String temp){
        String data = temp.substring(0,6);
        String hora = temp.substring(7,13);
        int ano, mes, dia, hour, min, seg;

        Integer.parseInt(data);
        ano = 2000 + Integer.parseInt(data.substring(0, 2));
        mes = Integer.parseInt(data.substring(2, 4));
        dia = Integer.parseInt(data.substring(4));
        Integer.parseInt(hora);
        hour = Integer.parseInt(hora.substring(0, 2));
        min = Integer.parseInt(hora.substring(2, 4));
        seg = Integer.parseInt(hora.substring(4));
        
        GregorianCalendar gcalendar = new GregorianCalendar(ano+2000, mes, dia, hour, min, seg);
        
        return gcalendar;
    }
     
    public byte[] parserToByte(ArrayList<String> list) {

        String data = "";
        for (Object item : list) {
            data = data + (String) item + ";";
        }
        return data.getBytes();
    }
    
}
