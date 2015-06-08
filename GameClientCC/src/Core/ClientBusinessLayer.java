package Core;

import BusinessEntities.GameBE;
import BusinessEntities.UserBE;
import BusinessObjects.*;
import Commands.*;
import UDPClient.UDPClient;

public class ClientBusinessLayer {
    
    //create an object of SingleObject
    private static ClientBusinessLayer instance = new ClientBusinessLayer();
    //staticClasses
    static UDPClient udpClient;
    //GlobalVars
    private GameBO _gameBO;
    private UserBE _userBE;
    private GameBE _nextGame;
 
    
    //make the constructor private so that this class cannot be instantiated
    private ClientBusinessLayer(){
        this._gameBO = new GameBO();
        this._userBE = new UserBE();
        this._nextGame = null;
    }

    //Get the only object available
    public static ClientBusinessLayer getInstance(){
        return instance;
    }
    
    public void setUser(UserBE user){
        this._userBE = user;
    }
    
    public UserBE getUser(){
        return _userBE;
    }
    
    public void setGame(GameBE game){
        this._nextGame = game;
    }
    
    public GameBE getGame(){
        return _nextGame;
    }
    
    
    //Lógica de Comandos a Enviar
    public void hello(){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Hello());
        new Thread(udpClient).start();
    }
    
    public void register(UserBE user){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Register(user));
        new Thread(udpClient).start();
    }
    
    public void login(UserBE user){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Login(user));
        new Thread(udpClient).start();
    }
    
    public void logout(){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Logout());
        new Thread(udpClient).start();
    }
    
    public void quit(){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Quit());
        new Thread(udpClient).start();
    }
    
    public void end(){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.End());
        new Thread(udpClient).start();
    }
	
    public void list_challenges(){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.List_challenges());
        new Thread(udpClient).start();
    }
    
    public void make_challenge(GameBE game){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Make_challenge(game));
        new Thread(udpClient).start();
    }
    
    public void accept_challenge(String game){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Accept_challenge(game));
        new Thread(udpClient).start();
    }
    
    public void delete_challenge(String game){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Accept_challenge(game));
        new Thread(udpClient).start();
    }
    
    public void answer(GameBE game, int answer){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Answer(game.id,game.getName(),answer));
        new Thread(udpClient).start();
    }
    
    public void retransmit(GameBE game, int answer, int packId){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.Retransmit(game.getName(),answer,packId));
        new Thread(udpClient).start();
    }
    
    public void list_ranking(){
        CommandFactory factory = new CommandFactory();
        udpClient = new UDPClient(factory.List_ranking());
        new Thread(udpClient).start();
    }
}
