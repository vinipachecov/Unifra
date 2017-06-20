package rpc.sincrono;

import org.jgroups.JChannel;
import org.jgroups.blocks.RpcDispatcher;

public class Cliente {

    JChannel channel;
    RpcDispatcher disp;

    //método que poderá ser invocado por outros processos
    public static int print(int number) throws Exception {
        System.out.println("Recebi uma chamada");
        return number * 2;
    }

    public void start() throws Exception {
        channel = new JChannel();
        //Declaração de um RpcDispatcher, para registrar o método no grupo
        disp = new RpcDispatcher(channel, this);
        //entrada do processo no grupo
        channel.connect("Grupo");
    }

    public Cliente() {
    }

    public static void main(String[] args) throws Exception {
        new Cliente().start();
    }
}
