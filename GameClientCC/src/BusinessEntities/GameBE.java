package BusinessEntities;
 
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class GameBE  extends Entity {
 
    private String name;
    private ArrayList<QuestionBE> questions;
    private GregorianCalendar startDate;
    
    //TODO: create gets e sets e constructors
    private int currentQuestion;
    
    public GameBE(String name){
        this.name = name;
        this.questions = new ArrayList<QuestionBE>();
        this.startDate = GregorianCalendar.from(ZonedDateTime.now());
        currentQuestion = 0;
    }
    
    public GameBE(String name, ArrayList<QuestionBE> q, GregorianCalendar date){
        this.name = name;
        this.questions = q;
        this.startDate = date;
        currentQuestion = 0;
    }
    
    //GETS
    public String getName(){
        return name;
    }
    
    //SETS
    public void setName(String n){
         this.name = n;
    }
    
    public GregorianCalendar getData() {
        return startDate;
    }
    
    public void setStartDate(GregorianCalendar date){
        this.startDate = date;
    }
    
    //Add
    public boolean addQuestion(QuestionBE q){
        boolean result = false;
        if(!questions.contains(q)){
            questions.add(q);
            result = true;
        }
        return result;
    }
    
    public ArrayList<QuestionBE> getPerguntas() {
        return questions;
    }
    public QuestionBE getPergunta(int numero) {
        return this.questions.get(numero - 1);
    }
}   
