package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorRMI {

    public static void main(String[] args) {
        try {
            //instanciamos o objeto remoto
            Calculadora calc = new Calculadora();
            //inicializa o RMIRegistry
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            //registramos o objeto calc em um endereço remoto
            Naming.bind("rmi://localhost/Calculadora", calc);

        } catch (RemoteException | AlreadyBoundException | MalformedURLException ex) {
            
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
