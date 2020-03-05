package fr.cnam.smb111.cours02.tp2_5.client;



import fr.cnam.smb111.cours02.tp2_5.common.ICalendrier;
import fr.cnam.smb111.cours02.tp2_5.common.IHeure;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * client permettant d'interrger un serveur distant.
 *
 * @author Cyril Rabat
 */
public class Client {

    /**
     * Methode principale.
     *
     * @param args inutilise
     */
    public static void main(String[] args) {
        ICalendrier calendrier = null;

        // R�cup�ration du calendrier distant
        try {
            calendrier = (ICalendrier) Naming.lookup("rmi://localhost/monCalendrier");
        } catch (RemoteException e) {
            System.err.println("Pas possible d'acceder � l'objet distant : " + e);
            System.exit(-1);
        } catch (NotBoundException e) {
            System.err.println("Pas possible d'acceder � l'objet distant : " + e);
            System.exit(-1);
        } catch (MalformedURLException e) {
            System.err.println("Probleme avec l'URL : " + e);
            System.exit(-1);
        }

        // Utilisation du calendrier
        try {
            System.out.print("Nous sommes le " + calendrier.getJour());
            System.out.print("/" + calendrier.getMois());
            System.out.println("/" + calendrier.getAnnee());

            IHeure heure = calendrier.getHeure();
            System.out.println("Heure : " + heure);
        } catch (RemoteException e) {
            System.err.println("Erreur lors de l'acces aux methodes");
            System.exit(-1);
        }
    }

}