package ex1;

import static java.lang.Thread.sleep;

public class Principal {

    //thread principal
    public static void main(String[] args) {
        //criação de uma thread inline
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    System.out.println("Fluxo secundário 1");
                    try {
                        sleep(1000);
                    } catch (Exception e) {
                        //trata-se falha
                    }
                }
            }
        };
        t1.start();//start faz com que o run execute sua tarefa em paralelo

        //criação de uma thread inline
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    System.out.println("Fluxo secundário 2");
                    try {
                        sleep(500);
                    } catch (Exception e) {
                        //trata-se falha
                    }
                }
            }
        };
        t2.start();

        while (true) {
            System.out.println("Fluxo Principal");
            try {
                sleep(2000);
            } catch (Exception e) {
                //trata-se falha
            }
        }
        
    }
}
