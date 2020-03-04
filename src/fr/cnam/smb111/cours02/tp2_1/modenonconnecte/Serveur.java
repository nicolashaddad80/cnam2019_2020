package fr.cnam.smb111.cours02.tp2_1.modenonconnecte;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Classe correspondant à un serveur en mode non connecté.
 * La chaine de caractères "Bonjour" est envoyée au serveur.
 * Le port d'écoute du serveur est indiqué dans la classe Serveur.
 *
 * @author Cyril Rabat
 */
public class Serveur {

    // Le numéro de port est fixé ici arbitrairement a 2025
    public static int portEcoute = 2025;

    public static void main(String[] args) {
        // Création de la socket
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(Serveur.portEcoute);
        } catch (SocketException e) {
            System.err.println("Erreur lors de la creation de la socket : " + e);
            System.exit(-1);
        }

        // Création du message
        byte[] tampon = new byte[1024];
        DatagramPacket msg = new DatagramPacket(tampon, tampon.length);

        // Lecture du message du client
        try {
            socket.receive(msg);
            String texte = new String(msg.getData(), 0, msg.getLength());
            System.out.println("Lu: " + texte);
        } catch (IOException e) {
            System.err.println("Erreur lors de la reception du message : " + e);
            System.exit(-1);
        }

        // Fermeture de la socket
        socket.close();
    }

}