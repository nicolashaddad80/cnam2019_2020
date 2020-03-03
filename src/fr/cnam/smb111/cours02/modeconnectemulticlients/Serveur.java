package fr.cnam.smb111.cours02.modeconnectemulticlients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe correspondant � un serveur en mode connecte, multi-clients et
 * multi-thread�.
 * Le client envoie la chaine 'Bonjour' et lit une reponse de la part du serveur.
 * Le client envoie ensuite la chaine 'Au revoir' et lit une reponse.
 * Le numero de port du serveur est specifie dans la classe Serveur.
 *
 * @author Cyril Rabat
 */
public class Serveur {

    // Le num�ro de port est fixe ici arbitrairement a 5001
    public static final int portEcoute = 5001;

    public static void main(String[] args) {
        // Cr�ation de la socket serveur
        ServerSocket socketServeur = null;
        try {
            socketServeur = new ServerSocket(Serveur.portEcoute);
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