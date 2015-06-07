package BusinessEntities;
 
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class GameBE  extends Entity {
 
    private String name;
    private List<Integer> users;
    private List<Integer> questions;
    private GregorianCalendar startDate;
    
    //TODO: create gets e sets e constructors
    private int currentQuestion;
    
    public GameBE(String name){
        this.name = name;
        this.questions = new ArrayList<Integer>();
        this.users = new ArrayList<Integer>();
    }
    
    public GameBE(String name, int n,List<Integer> lu, List<Integer> q, GregorianCalendar date){
        this.name = name;
        this.users = new ArrayList<Integer> (lu);
        this.questions = new ArrayList<Integer> (q);
        this.startDate = date;
    }
    
    //GETS
    public String getName(){
        return name;
    }
    
    //SETS
    public void setName(String n){
         this.name = n;
    }
    
    public void setStartDate(GregorianCalendar date){
        this.startDate = date;
    }
    
    //Add
    public boolean addUser(int userId){
        boolean result = false;
        if(!users.contains(userId)){
            users.add(userId);
            result = true;
        }
        return result;
    }
    
    public boolean addQuestion(int questionId){
        boolean result = false;
        if(!questions.contains(questionId)){
            questions.add(questionId);
            result = true;
        }
        return result;
    }
}
