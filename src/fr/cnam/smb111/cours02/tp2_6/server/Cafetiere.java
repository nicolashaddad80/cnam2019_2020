package fr.cnam.smb111.cours02.tp2_6.server;


import fr.cnam.smb111.cours02.tp2_6.common.ICafetiere;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cafetiere extends UnicastRemoteObject implements ICafetiere {
    private static final int SHORT_COFFE_WATER = 20;
    private static final int LONG_COFFE_WATER = 40;

    private static final int SHORT_COFFE_DOSE = 1;
    private static final int LONG_COFFE_DOSE = 2;

    private int maxWater;
    private int currentWater = 0;

    private int maxDose;
    private int curretnDose = 0;

    public Cafetiere(int maxWater, int maxDose) throws RemoteException {
        this.maxWater = maxWater;
        this.maxDose = maxDose;
    }

    @Override
    public void addWater(int waterQuantity) throws RemoteException {
        if (this.currentWater + waterQuantity > this.maxWater)
            throw new MaxWaterExceeded("Cette quantite d eau ne peut etre ajoutee car on depassera le maximum");
        this.currentWater += waterQuantity;
    }

    @Override
    public void addDose(int nbDose) throws RemoteException {
        if (this.curretnDose + nbDose > this.maxDose)
            throw new MaxDoseExceeded("Cette quantite de doses ne peut etre ajoutee car on depassera le maximum");
        this.curretnDose += nbDose;
    }

    private boolean getCoffe(int waterQuantity, int doseNumeber) throws NoEnoughWater, NoEnoughDose {

        if (this.curretnDose <= doseNumeber)
            throw new NoEnoughDose("Pas assez de dosettes");
        if (this.currentWater <= waterQuantity)
            throw new NoEnoughWater("Pas assez d eau");
        this.currentWater -= waterQuantity;
        this.curretnDose -= doseNumeber;
        return true;
    }

    @Override
    public boolean getSortCoffe() throws RemoteException {
        return this.getCoffe(SHORT_COFFE_WATER, SHORT_COFFE_DOSE);
    }

    @Override
    public boolean getLongCoffe() throws RemoteException {
        return this.getCoffe(LONG_COFFE_WATER, LONG_COFFE_DOSE);
    }
}
