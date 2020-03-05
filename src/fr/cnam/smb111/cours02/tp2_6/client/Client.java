package fr.cnam.smb111.cours02.tp2_6.client;

import fr.cnam.smb111.cours02.tp2_6.common.ICafetiere;
import fr.cnam.smb111.cours02.tp2_6.common.ICafetiereFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {

        // Recuperation du l'usine de cafetieres distante
        ICafetiereFactory usineCafetieres = null;
        try {
            usineCafetieres = (ICafetiereFactory) Naming.lookup("rmi://localhost/" + ICafetiereFactory.CAFETIERE_FACTORY_NAME);
        } catch (RemoteException e) {
            System.err.println("Pas possible d'acceder a l'objet distant : " + e);
            System.exit(-1);
        } catch (NotBoundException e) {
            System.err.println("Pas possible d'acceder a l'objet distant : " + e);
            System.exit(-1);
        } catch (
                MalformedURLException e) {
            System.err.println("Probleme avec l'URL : " + e);
            System.exit(-1);
        }

        // Creation d'une cafetiere et remplisage au max de l eau et dosettes et tests simples des methodes cafe court et cafe long

        try {
            usineCafetieres.construireCafetiere("cafetiere1", 100, 5);

        } catch (RemoteException e) {
            System.err.println("Erreur lors de l'acces a l'usine de cafetieres");
            System.exit(-1);
        } catch (MalformedURLException e) {
            System.err.println("Probleme avec l'URL : " + e);
            System.exit(-1);
        }


        //Recuperation de la cafetiere aupres du Registry RMI
        ICafetiere cafetiere1 = null;

        try {
            cafetiere1 = (ICafetiere) Naming.lookup("rmi://localhost/cafetiere1");
        } catch (RemoteException e) {
            System.err.println("Pas possible d'acceder a la cafetiere distante : " + e);
            System.exit(-1);
        } catch (NotBoundException e) {
            System.err.println("Pas possible d'acceder a l'objet distant : " + e);
            System.exit(-1);
        } catch (
                MalformedURLException e) {
            System.err.println("Probleme avec l'URL : " + e);
            System.exit(-1);
        }

        //Remplisage aux max de la cafetiere
        try {
            cafetiere1.addWater(100);
            cafetiere1.addDose(5);
        } catch (RemoteException e) {
            System.out.println("Erreur lors du remplissage de la cafetiere");
            System.exit(-2);
        }
        //test simple de la methode distante cafe court
        try {
            if (cafetiere1.getSortCoffe())
                System.out.println("Le cafe court est bien servi");
            else
                System.out.println("le cafe court ne peut pas etre servi, verifiez l'eau et les dosettes de la cafetiere");
        } catch (RemoteException e) {
            System.out.println("Erreur lors de la commande du cafe court" + e);
        }

        //test simple de la methode distante cafe long
        try {
            if (cafetiere1.getLongCoffe())
                System.out.println("Le cafe long est bien servi");
            else
                System.out.println("le cafe court ne peut pas etre servi, verifiez l'eau et les dosettes de la cafetiere");
        } catch (RemoteException e) {
            System.out.println("Erreur lors de la commande du cafe long" + e);
        }

        //test epuisement des dosettes
        try {
            cafetiere1.addWater(20);
            while (cafetiere1.getLongCoffe())
                System.out.println("Le cafe long est bien servi");


        } catch (RemoteException e) {
            System.out.println("Erreur lors de la commande du cafe : " + e);
        }

        //test epuisement d eau
        try {
            cafetiere1.addDose(3);
            while (cafetiere1.getLongCoffe())
                System.out.println("Le cafe long est bien servi");


        } catch (RemoteException e) {
            System.out.println("Erreur lors de la commande du cafe : " + e);
        }

        //test depassement de la capacite de dosettes max
        try {
            cafetiere1.addDose(3);
        } catch (RemoteException e) {
            System.out.println("Erreur lors de la commande du cafe : " + e);
        }

        //test depassement de la capacite eau max
        try {
            cafetiere1.addWater(81);
        } catch (RemoteException e) {
            System.out.println("Erreur lors de la commande du cafe : " + e);
        }

        //test Creation multiple cafetieres (100 cafetieres) avec un test cafe court sur chacune

        //preparation des noms
        String[] nomscafetieres = new String[100];
        for (int i = 0; i < 100; i++) nomscafetieres[i] = "" + i;
        //Creation des cafetieres
        for (int i = 0; i < 100; i++) {
            try {
                usineCafetieres.construireCafetiere(nomscafetieres[i], 100, 5);

            } catch (RemoteException e) {
                System.err.println("Erreur lors de l'acces a l'usine de cafetieres");
                System.exit(-1);
            } catch (MalformedURLException e) {
                System.err.println("Probleme avec l'URL : " + e);
                System.exit(-1);
            }

        }


        //recuperation des cafetieres
        //preparation des references
        ICafetiere[] refCafetiere = new ICafetiere[100];
        for (int i = 0; i < 100; i++)
            refCafetiere[i] = null;
        //recuperation des cafetieres distantes aupres du Registry
        for (int i = 0; i < 100; i++) {
            try {
                refCafetiere[i] = (ICafetiere) Naming.lookup("rmi://localhost/" + nomscafetieres[i]);
            } catch (RemoteException e) {
                System.err.println("Pas possible d'acceder a la cafetiere distante : " + e);
                System.exit(-1);
            } catch (NotBoundException e) {
                System.err.println("Pas possible d'acceder a l'objet distant : " + e);
                System.exit(-1);
            } catch (
                    MalformedURLException e) {
                System.err.println("Probleme avec l'URL : " + e);
                System.exit(-1);
            }
        }
        //Remplissage des cafetieres
        for (int i = 0; i < 100; i++) {
            try {
                refCafetiere[i].addWater(100);
                refCafetiere[i].addDose(5);
            } catch (RemoteException e) {
                System.out.println("Erreur lors du remplissage de la cafetiere");
                System.exit(-2);
            }
        }

        //command d'un cafe court pour cahaque cafetiere
        for (int i = 0; i < 100; i++) {
            //test simple de la methode distante cafe court
            try {
                if (refCafetiere[i].getSortCoffe())
                    System.out.println("Le cafe court de la cafetiere " + nomscafetieres[i] + " est bien servi");
                else
                    System.out.println("le cafe court de la cafetiere " + nomscafetieres[i] + " ne peut pas etre servi, verifiez l'eau et les dosettes de la cafetiere");
            } catch (RemoteException e) {
                System.out.println("Erreur lors de la commande du cafe court" + e);
            }

        }
    }
}
