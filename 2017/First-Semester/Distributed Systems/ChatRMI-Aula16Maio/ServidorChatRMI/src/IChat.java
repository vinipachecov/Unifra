/*
Interface que descreve os métodos que o cliente
pode invocar no servidor
*/
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChat extends Remote{
    
    //Cliente envia mensagem para o servidor
    public void enviaMensagem(String mensagem) throws RemoteException;
    //Cliente se registra e é colocado na lista no servidor
    public void registraCliente(ICallback cliente) throws RemoteException;
    //Cliente é removido da lista do servidor
    public void removeCliente(ICallback cliente) throws RemoteException;
}
