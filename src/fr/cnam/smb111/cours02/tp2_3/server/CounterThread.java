package fr.cnam.smb111.cours02.tp2_3.server;

import fr.cnam.smb111.cours02.tp2_2.Counter;
import fr.cnam.smb111.cours02.tp2_2.CounterImpl;
import fr.cnam.smb111.cours02.tp2_3.DebugTp2_3;
import fr.cnam.smb111.cours02.tp2_3.client.ClientParameters;

import java.io.*;
import java.net.Socket;


public class CounterThread extends Thread {

    private BufferedReader input = null;
    private PrintWriter output = null;
    private Socket socketClient = null;
    private Counter threadCounter = null;
    private String command = "";

    public CounterThread(Socket socketClient) {
        this.socketClient = socketClient;
        this.threadCounter = new CounterImpl();

        // Association d'un flux d'entree et de sortie
        try {
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }
    }

    @Override
    public void run() {

        do {
            // Lecture de la command a executer
            try {
                this.command = input.readLine();
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);
            }
            if (DebugTp2_3.SERVER_THREAD_DEBUG_ON) System.out.println("Command recue: " + command);
            this.executeCommand(command);

        } while (!this.command.equals(ClientParameters.END));
        // Fermeture des flux et des sockets
        try {
            input.close();
            output.close();
            socketClient.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la fermeture des flux et des sockets : " + e);
            System.exit(-1);
        }
    }

    private void executeCommand(String command) {
        switch (this.command) {
            case ClientParameters.DOWN:
                this.threadCounter.decrement();
                if (DebugTp2_3.SERVER_THREAD_TRACE_ON) System.out.println("Decrementing(--) Server Counter");
                break;
            case ClientParameters.UP:
                this.threadCounter.increment();
                if (DebugTp2_3.SERVER_THREAD_TRACE_ON) System.out.println("Incremating (++) Server Counter");
                break;
            case ClientParameters.GET:
                if (DebugTp2_3.SERVER_THREAD_TRACE_ON) System.out.println("Sending Counter Value");
                this.sendServerCounterValue();
                break;
            case ClientParameters.END:
                System.out.println("client Communication end, will close all then exit");
                // Fermeture des flux et des sockets
                try {
                    this.input.close();
                    this.output.close();
                    this.socketClient.close();
                } catch (IOException e) {
                    System.err.println("Erreur lors de la fermeture des flux et des sockets : " + e);
                    System.exit(-1);
                }
                break;

            default:
                System.err.println("Uknown Command");
                System.exit(-1);
                break;
        }
    }

    private void sendServerCounterValue() {
        // Envoi de la valeur du compteur
        String counterValue = (new StringBuilder().append(this.threadCounter.getValue())).toString();
        if (DebugTp2_3.SERVER_THREAD_TRACE_ON) System.out.println("Envoi: " + counterValue);
        output.println(counterValue);
    }
}

