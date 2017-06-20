package trabalho.pkgfinal.sd;

/*
Implementação dos métodos remotos da interface IChat
que o cliente pode invocar no servidor
*/
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMImiddle extends UnicastRemoteObject implements IChat{

    ArrayList<ICallback>listaClientes = new ArrayList<>();
    
    public RMImiddle() throws RemoteException{
        
    }
    
    @Override
    public void enviaMensagem(String mensagem) throws RemoteException {
        //percorre a lista de clientes e repassa a mensagem
        //para cada um dos clientes da lista
        for(ICallback cliente: listaClientes){
            cliente.repassaMensagem(mensagem);
        }
    }

    @Override
    public void registraCliente(ICallback cliente) throws RemoteException {
        //se a listaClientes não contem o cliente em questão
        if(!listaClientes.contains(cliente)){
            listaClientes.add(cliente); //adiciona o cliente na lista
            System.out.println("Cliente se registrou: "+cliente);
        }
    }

    @Override
    public void removeCliente(ICallback cliente) throws RemoteException {
        //se a listaClientes contém o cliente em questão
        if(listaClientes.contains(cliente)){
            listaClientes.remove(cliente);//remove o cliente da lista
            System.out.println("Cliente removido: "+cliente);
        }
    }
    
}
