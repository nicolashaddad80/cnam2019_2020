package fr.cnam.smb111.cours02.tp2_5.serveur;

import fr.cnam.smb111.cours02.tp2_5.common.IMaDate;

public class MaDate implements IMaDate {
    int jour,mois,annee;

    public MaDate(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

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

    @Override
    public String toString() {
        return new StringBuilder().append(this.jour).append('/').append(this.mois).append('/').append(this.annee).toString();
    }
}
