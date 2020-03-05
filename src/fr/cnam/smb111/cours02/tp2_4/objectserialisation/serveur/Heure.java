package fr.cnam.smb111.cours02.tp2_4.objectserialisation.serveur;

import fr.cnam.smb111.cours02.tp2_4.objectserialisation.common.IHeure;


/**
 * Classe permettant de representer une heure avec heure/minute/seconde
 *
 * @author Cyril Rabat
 */
public class Heure implements IHeure {

    private int heure;
    private int minute;
    private int seconde;

    /**
     * Cree une heure en specifiant les heures, les minutes et les heures
     *
     * @param seconde les secondes
     * @param minute  les minutes
     * @param heure   les heures
     */
    public Heure(int seconde, int minute, int heure) {
        this.seconde = seconde;
        this.minute = minute;
        this.heure = heure;
    }

    /**
     * Recupere les heures
     *
     * @return les heures
     */
    public int getHeure() {
        return heure;
    }

    /**
     * Recupere les minutes
     *
     * @return les minutes
     */
    public int getMinute() {
        return heure;
    }

    /**
     * Recupere les secondes
     *
     * @return les secondes
     */
    public int getSeconde() {
        return heure;
    }

    /**
     * Retourne l'heure sous forme de chaine de caracteres
     *
     * @return l'heure sous forme d'une chaine de caracteres
     */
    public String toString() {
        return heure + "h" + minute + "m" + seconde + "s";
    }

}