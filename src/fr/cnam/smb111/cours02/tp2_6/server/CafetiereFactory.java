package fr.cnam.smb111.cours02.tp2_6.server;

import fr.cnam.smb111.cours02.tp2_6.common.ICafetiere;
import fr.cnam.smb111.cours02.tp2_6.common.ICafetiereFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CafetiereFactory extends UnicastRemoteObject implements ICafetiereFactory {

    protected CafetiereFactory() throws RemoteException {
        super();
    }

    @Override
    public void construireCafetiere(ICafetiere cafetiereName, int waterCapacity, int doseCapacity) throws RemoteException {

        cafetiereName=new Cafetiere(waterCapacity,doseCapacity);
    }
}
