package fr.cnam.smb111.cours02.modenonconnecte;

import java.io.IOException;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Classe correspondant à un client en mode non connecte.
 * La chaine de caracteres "Bonjour" est envoyee au serveur.
 * Le port d'ecoute du serveur est indique dans la classe Serveur.
 * @author Cyril Rabat
 */
public class Client {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        // Création de la socket
        try {
            socket = new DatagramSocket();
        } catch(SocketException e) {
            System.err.println("Erreur lors de la creation de la socket : " + e);
            System.exit(-1);
        }

        // Creation du message
        DatagramPacket msg = null;
        try {
            InetAddress adresse = InetAddress.getByName(null);
            String message = "Bonjour";
            byte[] tampon = message.getBytes();
            msg = new DatagramPacket(tampon,tampon.length, adresse,Serveur.portEcoute);
            
        } catch(UnknownHostException e) {
            System.err.println("Erreur lors de la creation du message : " + e);
            System.exit(-1);
        }

        // Envoi du message
        try {
            socket.send(msg);
        } catch(IOException e) {
            System.err.println("Erreur lors de l'envoi du message : " + e);
            System.exit(-1);
        }

        // Fermeture de la socket
        socket.close();
    }

}
