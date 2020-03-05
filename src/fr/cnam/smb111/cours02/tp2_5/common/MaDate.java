package fr.cnam.smb111.cours02.tp2_5.common;

import fr.cnam.smb111.cours02.tp2_5.common.IMaDate;

public class MaDate implements IMaDate {
    int jour, mois, annee;

    public MaDate(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    //Getters

    @Override
    public int getJour() {
        return this.jour;
    }

    @Override
    public int getMois() {
        return this.mois;
    }

    @Override
    public int getAnnee() {
        return this.annee;
    }

    //Setters

    @Override
    public void setJour(int newJour) {
        this.jour = newJour;

    }

    @Override
    public void setMois(int newMois) {
        this.mois = newMois;

    }

    @Override
    public void setAnnee(int newAnnee) {
        this.annee = newAnnee;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.jour).append('/').append(this.mois).append('/').append(this.annee).toString();
    }
}
