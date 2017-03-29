
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammedsfaff
 */
public interface RMI extends Remote{
    
    
    public abstract void open(String fileName)
    throws RemoteException;
    
    public abstract String readLine()
    throws RemoteException;
    
    public abstract void close()
    throws RemoteException;
}
