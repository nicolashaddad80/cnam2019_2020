package fr.cnam.smb111.cours02.tp2_3;

import fr.cnam.smb111.cours02.tp2_1.modeconnectemulticlients.ThreadConnexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class CounterServeur {

    // Le num�ro de port est fixe ici arbitrairement a 5001
    public static final int portEcoute = 5001;

    public static void main(String[] args) {
        // Cr�ation de la socket serveur
        ServerSocket socketServeur = null;
        try {
            socketServeur = new ServerSocket(CounterServeur.portEcoute);
        } catch (IOException e) {
            System.err.println("Creation de la socket impossible : " + e);
            System.exit(-1);
        }

        // Attente des connexions des clients
        try {
            Socket socketClient;
            while (true) {
                socketClient = socketServeur.accept();
                ThreadConnexion t = new ThreadConnexion(socketClient);
                System.out.println("Nouvelle Connexion");
                t.start();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'attente d'une connexion : " + e);
            System.exit(-1);
        }

        // Fermeture de la socket
        try {
            socketServeur.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la fermeture de la socket : " + e);
            System.exit(-1);
        }
    }

}