package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IResposta extends Remote{
    
    public void enviaResposta(double resposta) throws RemoteException;
}
