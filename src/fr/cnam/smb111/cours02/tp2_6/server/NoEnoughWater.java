package fr.cnam.smb111.cours02.tp2_6.server;

import java.rmi.RemoteException;

public class NoEnoughWater extends RemoteException {
    public NoEnoughWater(String s) {
        super(s);
    }
}
