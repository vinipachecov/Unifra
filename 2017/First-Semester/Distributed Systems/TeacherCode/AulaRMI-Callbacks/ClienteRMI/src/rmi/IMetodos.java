package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMetodos extends Remote{
    
    public void calculo(double x, double y) throws RemoteException;
    
    public void registraCliente(IResposta ref_cliente) throws RemoteException;
}
