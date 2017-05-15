package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        try {
            
            Resposta r = new Resposta();
            
            //busca uma referência do Metodos do servidor
            IMetodos referencia = (IMetodos) Naming.lookup("rmi://localhost/Metodos");
            //registra o cliente no servidor
            referencia.registraCliente(r);
            //invoca o cálculo no servidor
            referencia.calculo(5, 9);
            System.out.println("Teste");
            
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
