package fr.cnam.smb111.cours02.tp2_5.common;



import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface correspondant a un calendrier distance.
 * Les operations disponibles : getJour, getMois et getAnnee.
 *
 * @author Cyril Rabat
 */
public interface ICalendrier extends Remote {

    /**
     * Recupere le numero du jour dans le mois.
     *
     * @return le numero du jour
     */
    int getJour() throws RemoteException;

    /**
     * Recupere le numero du mois (de 1 � 12).
     *
     * @return le numero du mois
     */
    int getMois() throws RemoteException;

    /**
     * Recupere l'annee.
     *
     * @return l'annee
     */
    int getAnnee() throws RemoteException;

    IHeure getHeure() throws RemoteException;

}