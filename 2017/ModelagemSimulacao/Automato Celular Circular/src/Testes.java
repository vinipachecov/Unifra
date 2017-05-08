/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinipachecov
 */
public class Testes {
    public enum Dia{
        Segunda,
        Terça,
        Quarta,
        Quinta,
        Sexta,
        Sabado
    }
    
    public static void main(String[] args) {
        System.out.println("testes");
        Dia day = Dia.Segunda;
        System.out.println(day);
        if(day == Dia.Segunda){
            System.out.println("EH SEGUNDA CARAI");
        }
    }
}
