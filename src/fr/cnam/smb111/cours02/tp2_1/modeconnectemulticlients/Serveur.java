package fr.cnam.smb111.cours02.tp2_1.modeconnectemulticlients;

import fr.cnam.smb111.cours02.tp2_3.server.ServerParametersTp2_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classe correspondant � un serveur en mode connecte, multi-client et
 * multi-thread�.
 * Le client envoie la chaine 'Bonjour' et lit une reponse de la part du serveur.
 * Le client envoie ensuite la chaine 'Au revoir' et lit une reponse.
 * Le numero de port du serveur est specifie dans la classe serveur.
 *
 * @author Cyril Rabat
 */
public class Serveur {


    public static final int portEcoute = ServerParametersTp2_3.SERVER_PORT_NUMBER;

    public static void main(String[] args) {
        // Création de la socket serveur
        ServerSocket socketServeur = null;
        try {
            socketServeur = new ServerSocket(Serveur.portEcoute);
        } catch (IOException e) {
            System.err.println("Creation de la socket impossible : " + e);
            System.exit(-1);
        }

        // Attente des connexions des client
        try {
            Socket socketClient;
            while (true) {
                socketClient = socketServeur.accept();
                new ThreadConnexion(socketClient).start();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'attente d'une connexion : " + e);
            System.exit(-1);
        }
    }

}