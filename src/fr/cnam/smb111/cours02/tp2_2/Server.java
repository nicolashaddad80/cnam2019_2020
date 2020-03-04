package fr.cnam.smb111.cours02.tp2_2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable {
    private static int clientPortNum = 0;
    private static DatagramSocket serverSocket = null;
    private static Counter counter = new CounterImpl();

    static {
        try {
            serverSocket = new DatagramSocket(ServerParameters.SERVER_PORT_NUMBER);
        } catch (SocketException e) {
            System.err.println("Erreur lors de la creation de la socket : " + e);
            System.exit(-1);
        }
    }

    //make constructor private to avoid invoking it
    public Server(int clinetPortNum) {
        Server.clientPortNum = clinetPortNum;
    }

    public static Counter getCounter() {
        return Server.counter;
    }

    @Override
    public void run() {

        while (true) {
            // Reading Client Request
            try {
                byte[] tampon = new byte[1024];
                DatagramPacket receiveRequestPacket = new DatagramPacket(tampon, tampon.length);
                if (Debug.SERVER_TRACE_ON) System.out.println("Waiting for Client Request...");
                serverSocket.receive(receiveRequestPacket);
                String clientRequestPacket = new String(receiveRequestPacket.getData(), 0, receiveRequestPacket.getLength());
                if (Debug.SERVER_DEBUG_ON) System.out.println("Received Request: " + clientRequestPacket);

                //Unmarchaling
                String[] packetDecoded = clientRequestPacket.split(ClientParameters.MARSHALLING_DELIMETER);
                if (packetDecoded.length != 2) throw new ClientRequestFormatError();

                //Create Thread to serve client Request
                new CounterCommandsThread(packetDecoded[0].trim(), clientPortNum, packetDecoded[1].trim(), serverSocket).start();

            } catch (IOException e) {
                System.err.println("Erreur lors de la reception du message : " + e);
                System.exit(-1);
            }
        }
    }

}
