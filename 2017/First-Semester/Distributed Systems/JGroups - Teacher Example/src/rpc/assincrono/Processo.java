package rpc.assincrono;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.blocks.MethodCall;
import org.jgroups.blocks.RequestOptions;
import org.jgroups.blocks.ResponseMode;
import org.jgroups.blocks.RpcDispatcher;
import org.jgroups.util.RspList;
import org.jgroups.util.Util;

public class Processo {

    JChannel channel;
    RpcDispatcher disp;
    String props; // set by application

    //método que poderá ser invocado por outros processos
    public static int print(int number) throws Exception {
        return number * 2;
    }

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
            MethodCall call = new MethodCall(getClass().getMethod("print", int.class));
            call.setArgs(i);
            CompletableFuture<RspList<Integer>> future = disp.callRemoteMethodsWithFuture(null, call, opcoes);
            future.whenComplete((result, ex) -> {
                System.out.println(result);
            });
        }
        //channel.close();
        //disp.stop();
    }

    public static void main(String[] args) throws Exception {
        new Processo().start();
    }
}
