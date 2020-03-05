package fr.cnam.smb111.cours02.tp2_6.server;

import java.rmi.RemoteException;

public class MaxWaterExceeded extends RemoteException {
    public MaxWaterExceeded(String s) {
        super(s);
    }
}
