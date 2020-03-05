package fr.cnam.smb111.cours02.tp2_5.serveur;

import fr.cnam.smb111.cours02.tp2_5.common.ICalendrier;
import fr.cnam.smb111.cours02.tp2_5.common.IHeure;
import fr.cnam.smb111.cours02.tp2_5.common.IMaDate;
import fr.cnam.smb111.cours02.tp2_5.common.MaDate;

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

    //statisticsTable[0] represents day statistics
    //statisticsTable[1] represents month statistics
    //statisticsTable[2] represents year statistics
    private int[] statisticsTable ;
    private IMaDate date=null;

    /**
     * Constructeur par defaut. Permet d'initialiser le calendrier.
     */
    public CalendrierDistant() throws RemoteException {
        calendrier = Calendar.getInstance();
        this.date=new MaDate(this.calendrier.get(Calendar.DAY_OF_MONTH),this.calendrier.get(Calendar.MONTH),this.calendrier.get(Calendar.YEAR));

        //initialisation of statistic counter to 0 at creation
        this.statisticsTable=new int[3];
        for (int i = 0; i < 3; i++)
            this.statisticsTable[i] = 0;
    }

    /**
     * Recupere le numero du jour dans le mois.
     *
     * @return le numero du jour
     */
    public int getJour() throws RemoteException {
        this.statisticsTable[0]++;
        return calendrier.get(Calendar.DAY_OF_MONTH);


    }

    /**
     * Recupere le numero du mois (de 1 � 12).
     *
     * @return le numero du mois
     */
    public int getMois() throws RemoteException {
        this.statisticsTable[1]++;
        return calendrier.get(Calendar.MONTH);

    }

    /**
     * Recupere l'annee.
     *
     * @return l'annee
     */
    public int getAnnee() throws RemoteException {
        this.statisticsTable[2]++;
        return calendrier.get(Calendar.YEAR);

    }

    /**
     * Recupere l'heure.
     *
     * @return l'heure
     */
    public IHeure getHeure() throws RemoteException {
        IHeure heure = new Heure(Calendar.SECOND, Calendar.MINUTE, Calendar.HOUR_OF_DAY);
        return heure;
    }

    @Override
    public int[] getStatistics() throws RemoteException {
        return this.statisticsTable;
    }

    @Override
    public IMaDate getDateComplete() throws RemoteException {
        return this.date;
    }

    @Override
    public void update(IMaDate newDate) throws RemoteException {

        this.date.setJour(newDate.getJour());
        this.date.setMois(newDate.getMois());
        this.date.setAnnee(newDate.getAnnee());

    }

}