/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.DefaultListModel;

/**
 *
 * @author vinipachecov
 */
public class listaUsuarios implements Serializable{
    DefaultListModel<String> nomes;
    
     private void writeObject(ObjectOutputStream out) throws IOException {


        out.defaultWriteObject();
        nomes = new DefaultListModel<String>();
        nomes.addElement("João123");
        nomes.addElement("João888");
        nomes.addElement("João1555");
        nomes.addElement("João142");          
       // out.defaultWriteObject(nomes);  
     }
    private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException {
        in.defaultReadObject();  
    }
}
    

