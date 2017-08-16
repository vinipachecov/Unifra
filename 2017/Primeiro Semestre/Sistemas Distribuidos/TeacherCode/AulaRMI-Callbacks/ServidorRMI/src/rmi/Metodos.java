package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos extends UnicastRemoteObject implements IMetodos {

    IResposta cliente = null;

    public Metodos() throws RemoteException {

    }

    @Override
    public void calculo(double x, double y) throws RemoteException {

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    //chamar um método no cliente para passar o resultado
                    cliente.enviaResposta(x + y);
                } catch (InterruptedException ex) {

                } catch (RemoteException ex) {
                    
                }
            }
        }.start();
    }

    @Override
    public void registraCliente(IResposta ref_cliente) throws RemoteException {
        this.cliente = ref_cliente;
    }
}
