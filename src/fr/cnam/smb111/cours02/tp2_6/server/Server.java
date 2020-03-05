package fr.cnam.smb111.cours02.tp2_6.server;

import fr.cnam.smb111.cours02.tp2_6.common.ICafetiereFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {
        // Creation du RMI registry
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            System.err.println("Erreur lors de la recuperation du registry : " + e);
            System.exit(-1);
        }

        // Creation de l'objet distant
        ICafetiereFactory cafetieresFactory = null;
        try {
            cafetieresFactory = new CafetiereFactory();
        } catch (RemoteException e) {
            System.err.println("Erreur lors de la creation de l'objet : " + e);
            System.exit(-1);
        }

        // Enregistrement aupres du Registry
        try {
            // Enregistrement de l'objet sur le Registry
            Naming.rebind("usineCafetieres", cafetieresFactory);
        } catch (RemoteException e) {
            System.err.println("Impossible de mettre a disposition l'usine de cafetieres' : " + e);
            System.exit(-1);
        } catch (MalformedURLException e) {
            System.err.println("Probleme avec l'URL : " + e);
            System.exit(-1);
        }

        System.out.println("serveur pret");
    }

}
