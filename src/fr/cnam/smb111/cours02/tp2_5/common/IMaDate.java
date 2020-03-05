package fr.cnam.smb111.cours02.tp2_5.common;

import java.io.Serializable;

public interface IMaDate extends Serializable {

    //Getters
    int getJour();

    int getMois();

    int getAnnee();

    //Setters
    void setJour(int newJour);

    void setMois(int newMois);

    void setAnnee(int newAnnee);

    @Override
    String toString();
}
