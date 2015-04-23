package BusinessEntities;
 
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class gameBE  extends Entity {
 
    private String name;
    private int nUsers;
    private List<Integer> users;
    private List<Integer> questions;
    private GregorianCalendar startDate;
    
    //TODO: create gets e sets e constructors
    private int currentQuestion;
    
    public gameBE(String name, int n){
        this.name = name;
        this.nUsers = n;
    }
    
    public gameBE(String name, int n,List<Integer> lu, List<Integer> q, GregorianCalendar date){
        this.name = name;
        this.nUsers = n;
        this.users = new ArrayList<Integer> (lu);
        this.questions = new ArrayList<Integer> (q);
        this.startDate = date;
    }
    
    //GETS
    public String getName(){
        return name;
    }
    
    public int getNUsers(){
        return nUsers;
    }
    
    //SETS
     public void setName(String n){
         this.name = n;
    }
    
}
