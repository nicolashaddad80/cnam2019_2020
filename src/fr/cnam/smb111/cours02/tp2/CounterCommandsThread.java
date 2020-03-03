package fr.cnam.smb111.cours02.tp2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class CounterCommandsThread extends Thread {
    private String command = null;
    private String clientIpAddress;
    private DatagramSocket serverSocket;


    public CounterCommandsThread(String clientIpAdress, String command, DatagramSocket serverSocket) {
        this.command = command;
        this.serverSocket = serverSocket;
        this.clientIpAddress = clientIpAdress;

    }

    @Override
    public void run() {

        if (Debug.SERVER_THREAD_DEBUG_ON) System.out.println(this.command);
        switch (this.command) {
            case ClientParameters.DOWN:
                Server.getCounter().decrement();
                if (Debug.SERVER_THREAD_TRACE_ON) System.out.println("Decrementing(--) Server Counter");
                break;
            case ClientParameters.UP:
                Server.getCounter().increment();
                if (Debug.SERVER_THREAD_TRACE_ON) System.out.println("Incremating (++) Server Counter");
                break;
            case ClientParameters.GET:
                if (Debug.SERVER_THREAD_TRACE_ON) System.out.println("GEt Counter Value");
                this.sendServerCounterValue();
                break;

            default:
                System.err.println("Uknown Command");
                System.exit(-1);
                break;
        }
        if (Debug.SERVER_THREAD_TRACE_ON) System.out.println("Server Thread Job Done");

    }

    private void sendServerCounterValue() {
        // Creating Packet (Marshalling)
        if (Debug.SERVER_THREAD_TRACE_ON) System.out.println("Sending Server Counter Value to Client");
        DatagramPacket msg = null;
        try {
            String message = ""+Server.getCounter().getValue();
            byte[] tampon = message.getBytes();
            msg = new DatagramPacket(tampon, tampon.length, InetAddress.getByName(this.clientIpAddress), ClientParameters.CLIENT_PORT);
            // Sending Packet
            try {
                this.serverSocket.send(msg);
            } catch (IOException e) {
                System.err.println("Erreur lors de l'envoi du message : " + e);
                System.exit(-1);
            }
        } catch (UnknownHostException e) {
            System.err.println("Erreur lors de la creation du message : " + e);
            System.exit(-1);
        }
    }
}
