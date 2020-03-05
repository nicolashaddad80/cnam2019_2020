package fr.cnam.smb111.cours02.tp2_4.simpletypes.serveur;

import fr.cnam.smb111.cours02.tp2_4.simpletypes.common.ICalendrier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

/**
 * Cette classe correspond a un calendrier distant. Elle permet aux clients
 * de recuperer le jour, le mois et l'annee.
 * Elle implemente l'interface ICalendrier.
 *
 * @author Cyril Rabat
 */
public class CalendrierDistant extends UnicastRemoteObject implements ICalendrier {

    private Calendar calendrier;  // Une instance de calendrier

    /**
     * Constructeur par defaut. Permet d'initialiser le calendrier.
     */
    public CalendrierDistant() throws RemoteException {
        calendrier = Calendar.getInstance();
    }

    /**
     * Recupere le numero du jour dans le mois.
     *
     * @return le numero du jour
     */
    public int getJour() throws RemoteException {
        return calendrier.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Recupere le numero du mois (de 1 � 12).
     *
     * @return le numero du mois
     */
    public int getMois() throws RemoteException {
        return calendrier.get(Calendar.MONTH);
    }

    /**
     * Recupere l'annee.
     *
     * @return l'annee
     */
    public int getAnnee() throws RemoteException {
        return calendrier.get(Calendar.YEAR);
    }

}