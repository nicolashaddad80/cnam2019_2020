package fr.cnam.smb111.cours02.tp2_3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTestTp2_3 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Thread(new CounterClient(ServerParametersTp2_3.SERVER_PORT_NUMBER)));
        executor.submit(new Thread(new CounterClient(ServerParametersTp2_3.SERVER_PORT_NUMBER)));
        executor.submit(new Thread(new CounterClient(ServerParametersTp2_3.SERVER_PORT_NUMBER)));

    }
}