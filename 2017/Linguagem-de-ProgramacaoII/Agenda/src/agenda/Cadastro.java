/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class Cadastro {
    File f;
    BufferedWriter writer;
    ArrayList<String> valores;
    String nome;
    
    public Cadastro(ArrayList<String> valores){                
        this.valores = valores;        
    }
    
    public Cadastro(String nome){                               
        this.nome = nome;
        this.valores = new ArrayList<String>();
    }
    
    public void guardaCadastro(){
        f = new File(System.getProperty("user.dir")  +"/" +"contatos/" + valores.get(0)+".txt" );            
        System.out.println(System.getProperty("user.dir")  +"/" +"contatos/" + valores.get(0)+".txt"); 
        if(f.exists())
            JOptionPane.showMessageDialog(null, "Arquivo já existente na base de dados");
        else
            try {
                //tenta criar novo arquivo
                f.createNewFile();        
                estruturaCadastro(f,writer,valores);                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao criar novo arquivo");
            }    
    }
    
    public void estruturaCadastro(File f, BufferedWriter writer, ArrayList<String> valores){
        try{            
            writer = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < valores.size() ; i++) {
                switch(i){
                    case 0: 
                        writer.write("Nome = " + valores.get(i) +"\n");
                        break;
                    case 1:
                        writer.write("Email = " + valores.get(i)+ "\n") ;
                        break;
                    case 2:                        
                        writer.write("Cidade = " + valores.get(i) + "\n");
                        break;
                    case 3:
                        writer.write("Estado Civil = " + valores.get(i)+ "\n");
                        break;
                        
                }                
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {                
                    writer.close();
            } catch (Exception e) {
            }
        }        
    }
    
    public ArrayList<String> findCadastro(){
        String path = System.getProperty("user.dir") + "/contatos/" + nome +".txt";
        File f = new File(path);
        if(f.exists()){
            System.out.println("Achou o cadastro");
            resgataCadastro(path);                        
        }else{
            JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo com esse nome[Verifique e tente novamente]");
            return null;
        }
        return valores;
                        
    }
    
    public void resgataCadastro(String path){
        try {                        
            for (String line : Files.readAllLines(Paths.get(path))) {                 
                String conteudo = line.substring(line.indexOf("=")+2,line.length());
                valores.add(conteudo);                        
            }                
        }
        catch (Exception e) {
                        
        }                
        
    }

    
}
