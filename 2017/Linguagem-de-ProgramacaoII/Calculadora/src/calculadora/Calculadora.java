/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;


import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Calculadora {
    ArrayList<Integer> operandos; 
    ArrayList<Character> operadores;
    
    
    public Calculadora(){
        operandos = new ArrayList<Integer>();        
        operadores = new ArrayList<Character>();                
    }
    
    public void lastOperando(String input){
        char test;
        for(int i = input.length()-1;i>=0; i--){
            test = input.charAt(i);
            if(test == ' '|| i== 0 ){
                if(i == 0){
                    String operandolast = input.substring(i, input.length());
                    AddOperando(Integer.parseInt(operandolast));                    
                    break;
                }
                else{                    
                    String operandolast = input.substring(i+1, input.length());                    
                    AddOperando(Integer.parseInt(operandolast));
                    break;                    
                }                
            }                
        }        
    }
    
    public String AddOperador(String input, char oper){
        char test;        
        //encontra ultimo operando
        lastOperando(input);
        System.out.println("valores a serem operados: " + operandos);
        System.out.println("Operandos na sua sequencia: " + operadores);
        operadores.add(oper);
        return input + " " + oper + " ";        
    }    
    public void AddOperando(int oper){
        operandos.add(oper);
    }
    
    public String Result(String input){
         lastOperando(input);
         Integer res = 0;
         int i_operandos = 0;         
         for(int i = 0; i < operadores.size(); i++){             
               switch(operadores.get(i)){
                  case '+':
                      res += operandos.get(i_operandos) + operandos.get(i_operandos+1);
                      break;
                  case '-':
                      res += operandos.get(i_operandos) - operandos.get(i_operandos+1);
                      break;
                  case '/':
                      res += operandos.get(i_operandos) / operandos.get(i_operandos+1);
                      break;
                  case 'x':
                      res += operandos.get(i_operandos) * operandos.get(i_operandos+1);
                      break;                      
              }              
              i_operandos+=2;             
         } 
        operandos.clear();
        operadores.clear();
        return res.toString();
    }    
    
    public void Clear(){
        operandos.clear();
        operadores.clear();        
    }
}
