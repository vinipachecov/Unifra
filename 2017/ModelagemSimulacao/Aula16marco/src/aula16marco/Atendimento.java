/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula16marco;

import aula16marco.Cliente;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usrlab01
 */
public class Atendimento {
    public ArrayList<Integer> prioridades;
    public ArrayList<String> ids;
    public int atendimentos = 0;    
    public Integer contadorAtendimentos = 1;
    
    
    public Atendimento(ArrayList<Cliente> clientes){
        prioridades = new ArrayList<Integer>();
        ids = new ArrayList<String>();        
        
         for (Cliente clientesCliente : clientes) {
            this.ids.add(clientesCliente.getID());
            this.prioridades.add(clientesCliente.getPrioridade());            
        }        
    }
    
    public void sort(){
        Collections.sort(this.prioridades);        
    }
    
    public void atender(ArrayList<Cliente> listClients){
        while(this.prioridades.size() > 1){
            for (int i = 0; i < listClients.size(); i++) {
                if(listClients.get(i).getPrioridade() == this.prioridades.get(0)){
                    System.out.println("Número do atendimento " + contadorAtendimentos + " ID do Cliente " + listClients.get(i).getID() + 
                            " Prioridade = " + listClients.get(i).getPrioridade() + 
                            "  Valor = " + listClients.get(i).getValor()
                    );
                    listClients.remove(listClients.get(i));
                    this.prioridades.remove(this.prioridades.get(0));
                    this.contadorAtendimentos++;
                }            
            }            
        }
    }    
}