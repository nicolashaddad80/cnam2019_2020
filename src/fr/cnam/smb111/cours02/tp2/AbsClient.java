package fr.cnam.smb111.cours02.tp2;

import java.io.IOException;
import java.net.*;

public abstract class AbsClient implements Runnable {

    private static int numClientCounter = 0;
    private String clientIpAddress = null;
    private String command;
    private int clientId;
    private DatagramSocket clientSocket = null;


    public AbsClient(String command) {
        this.clientId = numClientCounter++;
        this.command = command;

        try {
            this.clientIpAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();

        }

        // Creating Client Socket
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException e) {
            System.err.println("Erreur lors de la creation de la socket : " + e);
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        this.sendRequest();
        if (this.command.equals(ClientParameters.GET))
            this.receiveValue();

        if (Debug.CLIENT_TRACE_ON) System.out.println(" Client Thread Job Done");
    }

    protected void sendRequest() {
        DatagramPacket msg = null;
        try {
            String message = ""+this.clientId + ClientParameters.MARSHALLING_DELIMETER + this.clientIpAddress + ClientParameters.MARSHALLING_DELIMETER  + this.command;
            byte[] tampon = message.getBytes();
            msg = new DatagramPacket(tampon, tampon.length, InetAddress.getByName(null), ServerParameters.SERVER_PORT_NUMBER);
            // Sending Packet
            try {
                this.clientSocket.send(msg);
            } catch (IOException e) {
                System.err.println("Erreur lors de l'envoi du message : " + e);
                System.exit(-1);
            }
        } catch (UnknownHostException e) {
            System.err.println("Erreur lors de la creation du message : " + e);
            System.exit(-1);
        }

    }

    protected void receiveValue() {

        //Read Packet
        System.out.println("Need now to read Value From a data packet");
        //Unmarchall Packet
        //Filter Packet and Diplay Result if this not destinated to us re inject it to socket

    }


    @Override
    public String toString() {
        return "numClient=" + clientId +
                "\tipAddress=" + clientIpAddress +
                "\tcommand=" + command
                ;
    }
}
