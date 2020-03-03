package fr.cnam.smb111.cours02.tp2;

import java.io.IOException;
import java.net.*;

public abstract class AbsClient implements Runnable {


    private String clientIpAddress = null;
    private String command;
    private DatagramSocket clientSocket = null;


    public AbsClient(String command) {

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
            String message = "" + this.clientIpAddress + ClientParameters.MARSHALLING_DELIMETER + this.command;
            byte[] tampon = message.getBytes();
            msg = new DatagramPacket(tampon, tampon.length, InetAddress.getByName(ServerParameters.SERVER_ADDRESS), ServerParameters.SERVER_PORT_NUMBER);
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
        // Creating reception buffer
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket msg = new DatagramPacket(receiveBuffer, receiveBuffer.length);

        // Lecture du message du client
        try {
            this.clientSocket.receive(msg);
            String texte = new String(msg.getData(), 0, msg.getLength());
            System.out.println("Counter Value" + texte);
        } catch(IOException e) {
            System.err.println("Erreur lors de la reception du message : " + e);
            System.exit(-1);
        }

        // Closing socket
        this.clientSocket.close();
    }


    @Override
    public String toString() {
        return
                "ipAddress=" + clientIpAddress +
                "\tcommand=" + command
                ;
    }
}
