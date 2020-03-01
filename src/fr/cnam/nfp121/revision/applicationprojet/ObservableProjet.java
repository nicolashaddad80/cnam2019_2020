package fr.cnam.nfp121.revision.applicationprojet;


import fr.cnam.nfp121.revision.pralteforme.Projet;
import fr.cnam.nfp121.tp12.mypatterns.MyObservable;
import fr.cnam.nfp121.tp12.mypatterns.MyObserver;
import fr.cnam.nfp121.tp13.DebugOnOFF;

import java.util.ArrayList;


public class ObservableProjet extends ProjetDecorator implements MyObservable {


    private ArrayList<MyObserver> observers = new ArrayList<>();

    public ObservableProjet(Projet monProjet) {
        super(monProjet);
    }

    @Override
    public void faireOffre(int montant, double taux) {
        super.faireOffre(montant, taux);
        this.notifyObservers();
    }

    @Override
    public void addObserver(MyObserver a_My_observer) {
        this.observers.add(a_My_observer);
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("An Observer just registered, now total Observers= " + this.countObservers());
    }

    @Override
    public void deleteObserver(MyObserver a_My_observer) {
        this.observers.remove(a_My_observer);
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("An Observer just Unregistered, now total Observers= " + this.countObservers());
    }

    @Override
    public void notifyObservers() {
        if (DebugOnOFF.DEBUG_ON) System.out.println("notifying " + this.countObservers() + ": All Observers");
        for (MyObserver obs : this.observers) {
            obs.update(this);
        }
    }

    @Override
    public int countObservers() {
        return this.observers.size();
    }

}
