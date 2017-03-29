


import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;


/**
 *
 * @author mohammedsfaff
 */
public class RMIServer extends UnicastRemoteObject implements RMI  {
    
    BufferedReader readFile;
    
    int count = 0;
    
    public RMIServer() throws RemoteException{
        super();
    }
    
    
    //Open the remote file
    
    public void open(String fileName) throws RemoteException {
        
        try {
            readFile = new BufferedReader(new FileReader(fileName));
            System.out.println("file is read");
        }catch (FileNotFoundException fnfe) {
            throw new RemoteException ("File Not Found" , fnfe);
        }
    }
    
    /**
     * Read a line from the remote file.
     */
    public String readLine() throws RemoteException {
        try {
            return readFile.readLine();
        }
        catch (java.io.IOException ioe) {
            throw new RemoteException ("IOException", ioe);
        }
    }
    
    /**
     * Close the remote file.
     */
    public void close() throws RemoteException {
        try {
            readFile.close();
        }
        catch (java.io.IOException ioe) {
            throw new RemoteException ("IOException", ioe);
        }
    }
    
    
    
    
    public static void main(String []args){
        
        try{
            
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server",new RMIServer());
            System.out.println("server started");
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
}
