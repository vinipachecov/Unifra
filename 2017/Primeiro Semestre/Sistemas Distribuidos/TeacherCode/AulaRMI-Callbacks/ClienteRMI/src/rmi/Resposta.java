package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Resposta extends UnicastRemoteObject implements IResposta {

    public Resposta() throws RemoteException{
        
    }
    
    @Override
    public void enviaResposta(double resposta) throws RemoteException {
        System.out.println("Resultado = "+resposta);
    }
    
}
