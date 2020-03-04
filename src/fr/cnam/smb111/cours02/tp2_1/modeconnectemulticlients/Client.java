package fr.cnam.smb111.cours02.tp2_1.modeconnectemulticlients;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Classe correspondant � un client en mode connect�.
 * Le client envoie la chaine 'Bonjour' et lit une reponse de la part du serveur.
 * Le client envoie ensuite la chaine 'Au revoir' et lit une reponse.
 * Le numero de port du serveur est specifie dans la classe Serveur.
 *
 * @author Cyril Rabat
 */
public class Client {

    public static void main(String[] args) {
        // Cr�ation de la socket
        Socket socket = null;
        try {
            socket = new Socket("localhost", Serveur.portEcoute);
        } catch (UnknownHostException e) {
            System.err.println("Erreur sur l'h�te : " + e);
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Creation de la socket impossible : " + e);
            System.exit(-1);
        }

        // Association d'un flux d'entree et de sortie
        BufferedReader input = null;
        PrintWriter output = null;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Envoi de 'Bonjour'
        String message = "Bonjour";
        System.out.println("Envoi: " + message);
        output.println(message);

        // Lecture de 'Bonjour'
        try {
            message = input.readLine();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture : " + e);
            System.exit(-1);
        }
        System.out.println("Lu: " + message);

        // Envoi de 'Au revoir'
        message = "Au revoir";
        System.out.println("Envoi: " + message);
        output.println(message);

        // Lecture de 'Au revoir'
        try {
            message = input.readLine();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture : " + e);
            System.exit(-1);
        }
        System.out.println("Lu: " + message);

        // Fermeture des flux et de la socket
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la fermeture des flux et de la socket : " + e);
            System.exit(-1);
        }
    }

}