package fr.cnam.smb111.cours02.tp2_4.serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;

/**
 * Serveur qui cree un calendrier distant et le met a disposition des clients.
 * @author Cyril Rabat
 */
public class Serveur {

    /**
     * Methode principale.
     * @param args inutilise
     */
    public static void main(String[] args) {
        // Step 01 Creation du RMI registry
        try {
            LocateRegistry.createRegistry(1099);
        } catch(RemoteException e) {
            System.err.println("Erreur lors de la recuperation du registry : " + e);
            System.exit(-1);
        }
	
        // Step 02 Creation de l'objet distant
        ICalendrier calendrier = null;
        try {
            calendrier = new CalendrierDistant();
        } catch(RemoteException e) {
            System.err.println("Erreur lors de la creation de l'objet : " + e);
            System.exit(-1);
        }

        // Step 03 Enregistrement aupres du Registry
        try {
            // Enregistrement de l'objet sur le Registry
            Naming.rebind("monCalendrier", calendrier);
        } catch(RemoteException e) {
            System.err.println("Impossible de mettre a disposition le calendrier : " + e);
            System.exit(-1);
        } catch(MalformedURLException e) {
            System.err.println("Probleme avec l'URL : " + e);
            System.exit(-1);
        }

        System.out.println("Serveur pret");
    }

}