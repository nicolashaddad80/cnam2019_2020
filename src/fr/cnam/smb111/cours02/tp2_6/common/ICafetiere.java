package fr.cnam.smb111.cours02.tp2_6.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICafetiere extends Remote {

    void addWater(int waterQuantity) throws RemoteException;

    void addDose(int nbDose) throws RemoteException;

    boolean getSortCoffe() throws RemoteException;

    boolean getLongCoffe() throws RemoteException;
}
