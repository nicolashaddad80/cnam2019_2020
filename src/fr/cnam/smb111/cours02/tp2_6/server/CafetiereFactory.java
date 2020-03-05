package fr.cnam.smb111.cours02.tp2_6.server;

import fr.cnam.smb111.cours02.tp2_6.common.ICafetiere;
import fr.cnam.smb111.cours02.tp2_6.common.ICafetiereFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CafetiereFactory extends UnicastRemoteObject implements ICafetiereFactory {

    protected CafetiereFactory() throws RemoteException {
        super();
    }

    @Override
    public void construireCafetiere(String cafetiereName, int waterCapacity, int doseCapacity) throws RemoteException, MalformedURLException {
        //Creating one cafetiere
        ICafetiere cafetiere = new Cafetiere(waterCapacity, doseCapacity);

        //registering the created cafetiere using the name that client would

        try {
            // Enregistrement de l'objet sur le Registry
            Naming.rebind(cafetiereName, cafetiere);
        } catch (RemoteException e) {
            System.err.println("Impossible de mettre a disposition la cafetiere : " + e);
            System.exit(-1);
        } catch (MalformedURLException e) {
            System.err.println("Probleme avec l'URL : " + e);
            System.exit(-1);
        }

        System.out.println("Cafetiere" + cafetiereName + "prete");

    }
}
