package fr.cnam.smb111.cours02.tp2_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.UP)));
        executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.GET)));
        executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.UP)));
        executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.GET)));
        executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.DOWN)));
        executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.GET)));

        for (int i = 0; i < 100; i++)
            executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.UP)));

        for (int i = 0; i < 10; i++)
            executor.submit(new Thread(new Client(ServerParameters.SERVER_ADDRESS, ServerParameters.SERVER_PORT_NUMBER, ClientParameters.GET)));
    }
}
