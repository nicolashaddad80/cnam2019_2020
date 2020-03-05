package fr.cnam.smb111.cours02.tp2_6.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICafetiereFactory extends Remote {

    void construireCafetiere(ICafetiere cafetiereName,int weterCapacity,int doseCapacity) throws RemoteException;
}
