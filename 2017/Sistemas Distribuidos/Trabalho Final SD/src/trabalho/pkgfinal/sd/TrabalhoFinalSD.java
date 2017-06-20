/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.pkgfinal.sd;


//Trabalho

/* 
Introdução

Realizar uma comparação de desempenho na comunicação confiável em grupo de algumas
APIs de comunicação estudadas durante o semestre, de acordo com os seguintes requisitos:

Implementar um processo emissor, que envia milhares de mensagens a um grupo de processos
(dar a opção de escolha da quantidade de mensagens), e aguarda a confirmação de recebimento de cada uma das mensagens.

Os processos receptores devem confirmar o recebimento de cada mensagem, caso o protocolo/API não ofereça isso por padrão.

O processo emissor só pode enviar a próxima mensagem depois que a anterior foi confirmada. 
Se for necessário, o processo emissor deverá retransmitir a mensagem.

Somente após receber a confirmação do recebimento de todas as mensagens que o processo emissor deve calcular o tempo gasto para todo este processo.

Contabilizar, também, a quantidade de mensagens perdidas e retransmitidas.

Portanto, deve ser implementado e comparado o desempenho da comunicação confiável em grupo entre:

    Sockets TCP
    
    Sockets UDP

    RMI

    Multicast Java

    JGroups

Efetue testes exaustivos em rede, ou seja, execute várias vezes o teste de modo a se obter uma média final, 
bem como elaborar um relatório dos resultados obtidos.

O que deve ser entregue e apresentado

Códigos-fonte das avaliações citadas acima;

Relatório do resultado obtido;

Data de entrega e apresentação:

26/06/2017
*/
/**
 *
 * @author vinipachecov
 */
public class TrabalhoFinalSD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Server UDP
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerUDP().setVisible(true);
            }
        });
         
         
        //Server TCP
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerTCP().setVisible(true);
            }
        });
        
        //Client
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }
    
}
