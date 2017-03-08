package com.viniciuspv.calculadora;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by root on 06/03/17.
 */

public class Calculadora {
    public ArrayList<Integer> operands;
    public ArrayList<Character> operators;
    public int result;

    public Calculadora(){
        operands = new ArrayList<Integer>();
        operators = new ArrayList<Character>();
        result = 0;
    }

    public void addOperator(String input, char operator){
        findOperand(input);
        operators.add(operator);
    }

    public void addOperand(int operand){
        operands.add(operand);
    }

    public void clearCalc(){
        operands.clear();
        operators.clear();
    }

    public void clearResult(){
        result = 0;
    }

    public void CalcOperands(int operand1, int operand2, char operator){
        switch (operator){
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case 'x':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }

    }

    public void findOperand(String input){
        String operand = "";
        for (int i = input.length()-1; i >=0; i--){
            if(i == 0 || input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == 'x' || input.charAt(i) == '/'){
                if(i!=0){
                    operand = input.substring(i+1,input.length());
                }else{
                    operand = input.substring(i,input.length());
                }
                addOperand(Integer.parseInt(operand));
                break;
            }
        }
    }


    public void CalculateExpression(String input){
        int index_operands = 0;
        for(int i = 0; i <operators.size(); i++){
            if(i==0){
                findOperand(input);
                CalcOperands(operands.get(index_operands),operands.get(index_operands+1), operators.get(i));
                index_operands+=2;
            }else
            {
                CalcOperands(result,operands.get(index_operands),operators.get(i));
                index_operands++;
            }
        }
        this.clearCalc();
    }

}
