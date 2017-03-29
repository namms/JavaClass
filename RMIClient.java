



import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author mohammedsfaff
 */
public class RMIClient {
    
    public static void main(String []args){
        
        RMIClient client = new RMIClient();
        client.connectServer();
        
    }
    
    private void connectServer() {
        try{
            //Create an instance of the RMI
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
            RMI rmi =( RMI)reg.lookup("server");
            System.out.println("connected to server");
            System.out.println();
            
            rmi.open("//Users//mohammedsfaff//Desktop//test.txt");
            String line;
            
            while((line = rmi.readLine()) != null) {
                System.out.println(line);
            }
            
            
            System.out.println(rmi.readLine());
            rmi.close();
            
        }catch(Exception ConnectException){
            System.out.println(ConnectException);
        }
    }
    
    
    
}
