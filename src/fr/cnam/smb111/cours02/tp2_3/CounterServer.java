package fr.cnam.smb111.cours02.tp2_3;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class CounterServer implements Runnable {


    private int portEcoute;
    private ServerSocket socketServeur=null;

    public CounterServer(int portEcoute) {
        this.portEcoute = portEcoute;
        // Cr�ation de la socket serveur

        try {
            this.socketServeur = new ServerSocket(this.portEcoute);
        } catch (IOException e) {
            System.err.println("Creation de la socket impossible : " + e);
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        while (true) {
            // Attente des connexions des clients
            try {
                Socket socketClient;
                while (true) {
                    socketClient = this.socketServeur.accept();
                    CounterThread t = new CounterThread(socketClient);
                    System.out.println("Nouvelle Connexion");
                    t.start();
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de l'attente d'une connexion : " + e);
                System.exit(-1);
            }
        }
    }
}