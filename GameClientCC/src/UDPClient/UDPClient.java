package UDPClient;

import Commands.ClientCommandBroker;
import Commands.PDU;

import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class UDPClient implements Runnable {
    
    static ClientCommandBroker broker ;
    protected String host;
    private PDU message;
    protected int port;
    protected int serverPort;
    
    public UDPClient(PDU message){
        this.host = "127.0.0.1";
        this.port = 9874;
        this.serverPort = 9875;
        this.message = message;
    }
    
    public UDPClient(String host, int port, PDU message){
        this.host = host;
        this.port = port;
        this.message = message;
    }
    
    @Override
    public void run() {
        try {
            
            // 
            DatagramSocket clientSocket = new DatagramSocket(port); 
            InetAddress IPAddress = InetAddress.getByName(host);           
            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(message);
            
            byte[] sendData = outputStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9875);

            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            System.out.println ("Waiting for return packet");
            clientSocket.setSoTimeout(100000);
            clientSocket.receive(receivePacket);
            
            byte[] data = receivePacket.getData();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            
            try {
                
                PDU message = (PDU) is.readObject();
                broker = ClientCommandBroker.getInstance();
        
                broker.takeOrder(message);
                broker.placeOrders();
                
                System.out.println("PDU object received = "+message.type);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            clientSocket.close(); 
        }
        catch (UnknownHostException ex) { 
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 
