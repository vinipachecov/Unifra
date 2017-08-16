/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula13marco;

import java.util.ArrayList;

//ctrl + shift + del
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class Questao1 {

    
    public static void main(String[] args) {
        ArrayList<ThreadMostraNome> tdmn = new ArrayList<ThreadMostraNome>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Criando threads " + i);
            tdmn.add(new ThreadMostraNome("Nome" + i));                        
        }
    }    
}
