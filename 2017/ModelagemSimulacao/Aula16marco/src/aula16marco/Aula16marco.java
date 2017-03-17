/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula16marco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


/**
 *
 * @author usrlab01
 */
public class Aula16marco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instancia 100 clientes
        ArrayList<Cliente> listClients = new ArrayList<Cliente>();
        for (int i = 0; i < 100; i++) {
            listClients.add(new Cliente());
        }
        
//        //testes Descomentar para testar
//        
//        System.out.println("Todos clientes e suas prioridades");
//        for (Cliente listClient : listClients) {
//            System.out.println("Cliente " + listClient.getID() + " Prioridade="
//                    + listClient.getPrioridade() + " Valor= " + 
//                    listClient.getValor()
//            );            
//        }
//        System.out.println("----------------------------");
//        System.out.println("----------------------------");
//        System.out.println("----------------------------");
                
        //Organiza os Clientes pela ordem de prioridade 
        // parte 1 adiciona os valores em vetores separados        
        
        
        Atendimento att = new Atendimento(listClients);
        //parte 2 faz um sort das prioridades        
        att.sort();
        
        // começa a atender os clientes
        att.atender(listClients);
    }
}
    
