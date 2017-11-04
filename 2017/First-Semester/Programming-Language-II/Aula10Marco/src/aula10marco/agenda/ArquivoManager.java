/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10marco.agenda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class ArquivoManager {
    File database = null;
    PrintWriter writer = null;
    String path = "/home/vinicius/Unifra/2017/Linguagem-de-ProgramacaoII/Aula10Marco/src/aula10marco/agenda/database.txt";

    public ArquivoManager() {
        database = new File(path);
        if(database.isFile()){
                        
        }else{
            //primeira vez
            try {
            writer = new PrintWriter(database);            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "[Escritor]Arquivo não encontrado");
            }            
            writer.println("Nome:" + "\n"
                    + "Email:" + "\n"
                    + "Colega":");
        }        
                
    }
    
    public void write(){
        
    }
    
    
    
}
