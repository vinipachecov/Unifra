package rpc.sincrono;

import org.jgroups.JChannel;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.blocks.RpcDispatcher;
import org.jgroups.util.RspList;
import org.jgroups.util.Util;

public class Servidor {

    JChannel channel;
    RpcDispatcher disp;
    RspList respostas;
    String props; // set by application

    public void start() throws Exception {
        //Essa variável define que iremos esperar a resposta de todos os nós (GET_ALL), por até 5 segundos.
        RequestOptions opcoes = new RequestOptions(ResponseMode.GET_ALL, 5000);
        channel = new JChannel(props);

        //declara um RpcDispatcher, que permitirá invocar os métodos nos processos do grupo
        disp = new RpcDispatcher(channel, this);

        //entrada do processo no grupo
        channel.connect("Grupo");

        //invoca 10 vezes o método print nos processos do grupo e mostra suas respostas
        for (int i = 0; i < 10; i++) {
            Util.sleep(100);
            respostas = disp.callRemoteMethods(null,
                    "print",
                    new Object[]{i},
                    new Class[]{int.class},
                    opcoes);
            System.out.println("Responses: " + respostas);
        }
        channel.close();
        disp.stop();
    }

    public static void main(String[] args) throws Exception {
        new Servidor().start();
    }
}
