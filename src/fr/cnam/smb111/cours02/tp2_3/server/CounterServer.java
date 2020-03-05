package fr.cnam.smb111.cours02.tp2_3.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class CounterServer implements Runnable {


    private int portEcoute;
    private ServerSocket socketServeur = null;

    public CounterServer(int portEcoute) {
        this.portEcoute = portEcoute;
        // Création de la socket serveur

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

            //Adding shutdown Hook inorder to close ServerSocket properly
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        socketServeur.close();
                        System.out.println("The server is shut down!");
                    } catch (IOException e) { /* failed */ }
                }
            });
            // Attente des connexions des client
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