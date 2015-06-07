package BusinessEntities;

public class UserBE extends Entity {
    
    private String name;
    private String password;
    private int totalScore;
    private boolean hasGame;
    private boolean inGame;
    private boolean loggedIn;
    
    public UserBE(String name,String password){
        this.name = name;
        this.password = password;
        this.totalScore = 0;
        this.hasGame = false;
        this.inGame = false;
        this.loggedIn = false;  
    }
    
    //GETS
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public int getTotalScore(){
        return totalScore;
    }
    public boolean getHasGame(){
        return hasGame;
    }
    public boolean getInGame(){
        return inGame;
    }
    public boolean getLoggedIn(){
        return loggedIn;
    }
    
    //SETS
     public void setName(String n){
         this.name = n;
    }
    public void setPassword(String p){
        this.password = p;
    }
    public void setTotalScore(int n){
        this.totalScore = n;
    }
    public void setHasGame(boolean b){
        this.hasGame = b;
    }
    public void setInGame(boolean b){
        this.inGame = b;
    }
    public void setLoggedIn(boolean b){
        this.loggedIn = b;
    }

    public void update(UserBE o) {
        this.name = o.name;
        this.password = o.password;
        this.totalScore = o.totalScore;
        this.hasGame = o.hasGame;
        this.inGame = o.inGame;
        this.loggedIn = o.loggedIn;
    }
}
