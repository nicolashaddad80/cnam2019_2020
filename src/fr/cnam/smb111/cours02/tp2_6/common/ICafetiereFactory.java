package fr.cnam.smb111.cours02.tp2_6.common;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICafetiereFactory extends Remote {
    String CAFETIERE_FACTORY_NAME = "usineCafetieres";

    void construireCafetiere(String cafetiereName, int weterCapacity, int doseCapacity) throws RemoteException, MalformedURLException;
}
