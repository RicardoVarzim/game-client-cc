package UDPClient;

import java.io.*; 
import java.net.*; 
  
public class UDPClient implements Runnable {

    protected String host;
    
    public UDPClient(){
        host = new String("127.0.0.1");
    }
    public UDPClient(String host){
        this.host = host;
    }
    
    @Override
    public void run() {
        try {
        
  
      BufferedReader inFromUser = 
        new BufferedReader(new InputStreamReader(System.in)); 
  
      DatagramSocket clientSocket = new DatagramSocket(); 
  
      InetAddress IPAddress = InetAddress.getByName(host); 
      System.out.println ("Attemping to connect to " + IPAddress + 
                          ") via UDP port 9876");
  
      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024]; 
  
      System.out.print("Enter Message: ");
      String sentence = inFromUser.readLine(); 
      sendData = sentence.getBytes();         

      System.out.println ("Sending data to " + sendData.length + 
                          " bytes to server.");
      DatagramPacket sendPacket = 
         new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
  
      clientSocket.send(sendPacket); 
  
      DatagramPacket receivePacket = 
         new DatagramPacket(receiveData, receiveData.length); 
  
      System.out.println ("Waiting for return packet");
      clientSocket.setSoTimeout(10000);

      try {
           clientSocket.receive(receivePacket); 
           String modifiedSentence = 
               new String(receivePacket.getData()); 
  
           InetAddress returnIPAddress = receivePacket.getAddress();
     
           int port = receivePacket.getPort();

           System.out.println ("From server at: " + returnIPAddress + 
                               ":" + port);
           System.out.println("Message: " + modifiedSentence); 

          }
      catch (SocketTimeoutException ste)
          {
           System.out.println ("Timeout Occurred: Packet assumed lost");
      }
  
      clientSocket.close(); 
     }
   catch (UnknownHostException ex) { 
     System.err.println(ex);
    }
   catch (IOException ex) {
     System.err.println(ex);
    }}
} 
