package fr.cnam.smb111.cours02.tp2_6.server;

import java.rmi.RemoteException;

public class MaxDoseExceeded extends RemoteException {
    public MaxDoseExceeded(String s) {
        super(s);
    }
}
