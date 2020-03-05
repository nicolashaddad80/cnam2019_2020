package fr.cnam.smb111.cours02.tp2_5.common;

import java.io.Serializable;

public interface IHeure extends Serializable {
    int getHeure();
    int getMinute();
    int getSeconde();
}
