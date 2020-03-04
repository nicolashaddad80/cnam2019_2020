package fr.cnam.smb111.cours02.tp2_3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class CounterClient implements Runnable {


    private static Socket socketClient = null;

    private BufferedReader input = null;
    private PrintWriter output = null;
    private String currentCommand = null;
    private Menu menu;

    static {

        // Création de la socke
        try {
            socketClient = new Socket("localhost", ServerParametersTp2_3.SERVER_PORT_NUMBER);
        } catch (UnknownHostException e) {
            System.err.println("Erreur sur l'hote : " + e);
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Creation de la socket impossible : " + e);
            System.exit(-1);
        }

    }

    public CounterClient(int portEcoute) {
        this.menu = new MenuImpl();


        // Association d'un flux d'entree et de sortie

        try {
            this.input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            this.output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        do {
            this.menu.printMenu();
            this.currentCommand = this.menu.chooseCommand();
            if (!this.currentCommand.equals(ClientParameters.END))
                this.executeCommand();
        } while (this.currentCommand.equals(ClientParameters.END));


        // Fermeture des flux et de la socket
        try {
            this.input.close();
            this.output.close();
            //socketClient.close();
            System.out.println("Merci d'avoit Utiliser Cette Application");
        } catch (IOException e) {
            System.err.println("Erreur lors de la fermeture des flux et de la socket : " + e);
            System.exit(-1);
        }
    }

    private void executeCommand() {
        System.out.println(this.currentCommand + " Executed");
    }
}