package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteRMI {

    public static void main(String[] args) {
        int op;
        try {
            ICalculadora ref = (ICalculadora) Naming.lookup("rmi://localhost/Calculadora");

            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Soma");
                System.out.println("2. Subtação");
                System.out.println("3. Divisão");
                System.out.println("4. Multiplicação");
                System.out.println("5. Potência");
                System.out.println("6. Raiz Quadrada");
                System.out.println("0. Sair");
                //le pelo teclado a opção
                Scanner teclado = new Scanner(System.in);
                op = teclado.nextInt();

                double x, y, resposta;

                switch (op) {
                    case 1:
                        x = teclado.nextDouble();
                        y = teclado.nextDouble();
                        resposta = ref.soma(x, y);                        
                        System.out.println("soma = " + resposta);
                        break;
                    case 2:
                        x = teclado.nextDouble();
                        y = teclado.nextDouble();
                        resposta = ref.subtracao(x, y);
                        System.out.println("subtracao = " + resposta);
                        break;
                    case 3:
                        x = teclado.nextDouble();
                        y = teclado.nextDouble();
                        resposta = ref.divisao(x, y);
                        System.out.println("divisao = " + resposta);
                        break;
                    case 4:
                        x = teclado.nextDouble();
                        y = teclado.nextDouble();
                        resposta = ref.multiplicacao(x, y);
                        System.out.println("multiplicacao = " + resposta);
                        break;
                    case 5:
                        x = teclado.nextDouble();
                        y = teclado.nextDouble();
                        resposta = ref.potencia(x, y);
                        System.out.println("potencia = " + resposta);
                        break;
                    case 6:
                        x = teclado.nextDouble();
                        resposta = ref.raizQuadrada(x);
                        System.out.println("raiz quadrada = " + resposta);
                        break;
                }
            } while (op != 0);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
