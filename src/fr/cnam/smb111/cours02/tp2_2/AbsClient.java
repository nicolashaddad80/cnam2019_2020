package fr.cnam.smb111.cours02.tp2_2;

import java.io.IOException;
import java.net.*;

public abstract class AbsClient implements Runnable {


    private static DatagramSocket clientSocket = null;

    static {
        // Creating client Socket
        try {
            clientSocket = new DatagramSocket(ClientParameters.CLIENT_PORT);
        } catch (SocketException e) {
            System.err.println("Erreur lors de la creation de la socket : " + e);
            System.exit(-1);
        }
    }

    private String serverAddress = null;
    private int serverPortNum;
    private String command;
    private String clientIpAddress = null;


    public AbsClient(String serverAddress, int serverPortNum, String command) {

        this.command = command;
        this.serverAddress = serverAddress;
        this.serverPortNum = serverPortNum;
        try {
            this.clientIpAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.sendRequest();
        if (this.command.equals(ClientParameters.GET))
            this.receiveValue();

        if (Debug.CLIENT_TRACE_ON) System.out.println(" client Thread Job Done");
    }

    protected void sendRequest() {
        DatagramPacket msg = null;
        try {
            byte[] tampon = null;
            String message = "" + this.clientIpAddress + ClientParameters.MARSHALLING_DELIMETER + this.command;
            tampon = message.getBytes();
            msg = new DatagramPacket(tampon, tampon.length, InetAddress.getByName(this.serverAddress), this.serverPortNum);
            // Sending Packet
            try {
                AbsClient.clientSocket.send(msg);
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
        // Creating reception buffer
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket msg = new DatagramPacket(receiveBuffer, receiveBuffer.length);

        // Lecture du message du client
        try {
            AbsClient.clientSocket.receive(msg);
            String texte = new String(msg.getData(), 0, msg.getLength());
            System.out.println("Counter Value: " + texte);
        } catch (IOException e) {
            System.err.println("Erreur lors de la reception du message : " + e);
            System.exit(-1);
        }
    }


    @Override
    public String toString() {
        return
                "ipAddress=" + clientIpAddress +
                        "\tcommand=" + command
                ;
    }
}
