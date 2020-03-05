package fr.cnam.smb111.cours02.tp2_6.server;

import java.rmi.RemoteException;

public class NoEnoughDose extends RemoteException {
    public NoEnoughDose(String s) {
        super(s);
    }
}
