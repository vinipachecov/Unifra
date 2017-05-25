/*
Interface que descreve os métodos que o servidor
pode invocar nos clientes
*/
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICallback extends Remote{
    public void repassaMensagem(String mensagem) throws RemoteException;
}