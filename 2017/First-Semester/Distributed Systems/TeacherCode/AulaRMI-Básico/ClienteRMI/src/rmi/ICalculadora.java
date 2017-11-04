package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

//1 - Todos os métodos devem ser public
//2 - Todos os métodos devem disparar exceção RemoteException
//3 - A interface deve se especializar de Remote

public interface ICalculadora extends Remote{
    //descrição dos métodos da calculadora
    public double soma(double x, double y) throws RemoteException;
    public double subtracao(double x, double y) throws RemoteException;
    public double multiplicacao(double x, double y) throws RemoteException;
    public double divisao(double x, double y) throws RemoteException;
    public double raizQuadrada(double x) throws RemoteException;
    public double potencia(double base, double expoente) throws RemoteException;

}
