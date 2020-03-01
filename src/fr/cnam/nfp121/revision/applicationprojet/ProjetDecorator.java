package fr.cnam.nfp121.revision.applicationprojet;

import fr.cnam.nfp121.revision.pralteforme.Offre;
import fr.cnam.nfp121.revision.pralteforme.Projet;

import java.util.Iterator;

public abstract class ProjetDecorator implements Projet {
    private static Projet monProjet;

    public ProjetDecorator(Projet monProjet) {
        ProjetDecorator.monProjet = monProjet;
    }

    @Override
    public String getNom() {
        return monProjet.getNom();
    }

    @Override
    public int getMontant() {
        return monProjet.getMontant();
    }

    @Override
    public void faireOffre(int montant, double taux) {
        monProjet.faireOffre(montant, taux);
    }

    public Iterator<Offre> iterator() {
        return monProjet.iterator();
    }

    @Override
    public String toString() {

        return monProjet.toString();
    }

}
