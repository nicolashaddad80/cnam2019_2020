package fr.cnam.smb111.cours02.tp2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable {
    private static int serverPort = 0;
    private static Counter counter = null;
    private DatagramSocket datagramSocket = null;
    private DatagramPacket receiveRequestPacket;

    //make constructor private to avoid invoking it
    public Server(int serverPort) {
        Server.counter = new CounterImpl();
        Server.serverPort = serverPort;
        try {
            this.datagramSocket = new DatagramSocket(Server.serverPort);
        } catch (SocketException e) {
            System.err.println("Erreur lors de la creation de la socket : " + e);
            System.exit(-1);
        }

        byte[] tampon = new byte[1024];
        this.receiveRequestPacket = new DatagramPacket(tampon, tampon.length);
    }

    public static int getServerPort() {
        return Server.serverPort;
    }

    public static Counter getCounter() {
        return Server.counter;
    }

    @Override
    public void run() {


        while (true) {
            // Reading Client Request
            try {
                if (Debug.SERVER_TRACE_ON) System.out.println("Waiting for Client Request...");
                datagramSocket.receive(receiveRequestPacket);
                String clientRequestPacket = new String(receiveRequestPacket.getData(), 0, receiveRequestPacket.getLength());
                if (Debug.SERVER_TRACE_ON) System.out.println("Received Request: " + clientRequestPacket);

                //Unmarchaling
                String[] packetDecoded = clientRequestPacket.split(ClientParameters.MARSHALLING_DELIMETER);
                if (packetDecoded.length != 2) throw new ClientRequestFormatError();

                //Create Thread to serve client Request
                new CounterCommandsThread(packetDecoded[0].trim(), packetDecoded[1].trim(), this.datagramSocket).start();

            } catch (IOException e) {
                System.err.println("Erreur lors de la reception du message : " + e);
                System.exit(-1);
            }
        }
    }

}
