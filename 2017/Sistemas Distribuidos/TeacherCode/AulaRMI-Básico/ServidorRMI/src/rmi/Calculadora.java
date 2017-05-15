package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//1 - Precisamos definir qual interface essa classe implementa
//(implements ICalculadora)
//2 - Precisa se especializar da classe UnicastRemoteObject
//3 - Precisa ter seu construtor definido com throws RemoteException
public class Calculadora extends UnicastRemoteObject implements ICalculadora {

    public Calculadora() throws RemoteException{
    }

    @Override
    public double soma(double x, double y) throws RemoteException {
        System.out.println("Soma: "+x+"+"+y);
        double resposta = x + y;
        return resposta;
    }

    @Override
    public double subtracao(double x, double y) throws RemoteException {
        System.out.println("Subtração: "+x+"-"+y);
        double resposta = x - y;
        return resposta;
    }

    @Override
    public double multiplicacao(double x, double y) throws RemoteException {
        System.out.println("Multiplicação: "+x+"*"+y);
        double resposta = x * y;
        return resposta;
    }

    @Override
    public double divisao(double x, double y) throws RemoteException {
        System.out.println("Divisão: "+x+"/"+y);
        double resposta = x / y;
        return resposta;
    }

    @Override
    public double raizQuadrada(double x) throws RemoteException {
        System.out.println("Raiz quadrada: sqrt("+x+")");
        double resposta = Math.sqrt(x);
        return resposta;
    }

    @Override
    public double potencia(double base, double expoente) throws RemoteException {
        System.out.println("Potência: "+base+"^"+expoente);
        double resposta = Math.pow(base, expoente);
        return resposta;
    }
}
