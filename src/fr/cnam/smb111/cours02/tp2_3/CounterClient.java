package fr.cnam.smb111.cours02.tp2_3;

import fr.cnam.smb111.cours02.tp2_3.textformating.TextColor;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class CounterClient implements Runnable {


    private Socket socketClient = null;
    private int portEcoute;
    private BufferedReader input = null;
    private PrintWriter output = null;
    private String currentCommand = null;
    private Menu menu;


    public CounterClient(int portEcoute) {
        this.portEcoute = portEcoute;
        this.menu = new MenuImpl();
        // Création de la socke
        try {
            socketClient = new Socket("localhost", this.portEcoute);
        } catch (UnknownHostException e) {
            System.err.println("Erreur sur l'hote : " + e);
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Creation de la socket impossible Verifiez si le Serveur est lance: " + e);
            System.exit(-1);
        }

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
            this.executeCommand();
        } while (!this.currentCommand.equals(ClientParameters.END));


        // Fermeture des flux et de la socket
        try {
            this.input.close();
            this.output.close();
            this.socketClient.close();
            System.out.println("Merci d'avoit Utiliser Cette Application");
        } catch (IOException e) {
            System.err.println("Erreur lors de la fermeture des flux et de la socket : " + e);
            System.exit(-1);
        }
    }

    private void executeCommand() {

        this.output.println(this.currentCommand);
        if (this.currentCommand.equals(ClientParameters.GET)) {
            // Lecture de la valeur du compteur
            try {
                String counterValue = input.readLine();
                System.out.println(TextColor.BLUE.set + "La valeur du compteur Distant est: " + TextColor.RED.set + counterValue + TextColor.DEFAULT.set);
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);
            }
        }


        if (DebugTp2_3.CLIENT_DEBUG_ON) System.out.println(this.currentCommand + " Executed");
    }
}