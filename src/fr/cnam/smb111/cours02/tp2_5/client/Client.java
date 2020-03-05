package fr.cnam.smb111.cours02.tp2_5.client;


import fr.cnam.smb111.cours02.tp2_5.common.ICalendrier;
import fr.cnam.smb111.cours02.tp2_5.common.IHeure;
import fr.cnam.smb111.cours02.tp2_5.common.IMaDate;
import fr.cnam.smb111.cours02.tp2_5.common.MaDate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

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


        //Get Statistics from remote calendrier

        try {
            int[] distantCalandarStatistics = calendrier.getStatistics();
            System.out.println("Nmobre d'accès getjour : " + distantCalandarStatistics[0]);
            System.out.println("Nmobre d'accès getMois : " + distantCalandarStatistics[1]);
            System.out.println("Nmobre d'accès getAnnee : " + distantCalandarStatistics[2]);
        } catch (RemoteException e) {
            System.err.println("Erreur lors de l'acces a la methode getStatistics()");
            System.exit(-1);
        }


        //Get Date by getDateComplete methode that serilizes MaDate remote object

        try {

            System.out.println("Getting date by remote MaDate Object refernece");
            IMaDate date = (IMaDate) calendrier.getDateComplete();
            //Extacting information from referenced remote MaDate Object
            System.out.println("Nous Somes Le: " + date);
        } catch (RemoteException e) {
            System.err.println("Erreur lors de l'acces a la methode getDAteComplete()");
            System.exit(-1);
        }

        //Updating Server Date by invoking update(IMaDate newDate) methode that serilizes MaDate remote object

        try {

            System.out.println("Getting date by remote MaDate Object refernece");
            IMaDate newDate = new MaDate(5,3,2020);
            //Updating Server Date
            calendrier.update(newDate);
            //diplaying the new date to check that update working fine
            IMaDate newServerDate= calendrier.getDateComplete();
            System.out.println("Nous Somes Le: " + newServerDate);
        } catch (RemoteException e) {
            System.err.println("Erreur lors de l'acces a la methode update(IMaDAte nouvelleDate) ou la methode getDAteComplete()");
            System.exit(-1);
        }
    }

}