package fr.cnam.smb111.cours02.tp2_5.common;

import java.io.Serializable;

public interface IMaDate extends Serializable {
    int getJour();
    int getMois();
    int getAnnee();

    @Override
    String toString();
}
