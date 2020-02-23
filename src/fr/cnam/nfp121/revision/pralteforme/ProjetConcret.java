package fr.cnam.nfp121.revision.pralteforme;

import java.util.Iterator;
import java.util.TreeSet;

public class ProjetConcret extends TreeSet<Offre> implements Projet {
    private static int numOffre = 0;
    private String nom;
    private int montant;
    // les offres
    private TreeSet<Offre> mesOffres = new TreeSet<>();


    public ProjetConcret(String nom, int montant) {
        this.nom = nom;
        this.montant = montant;


    }

    public String getNom() {
        return this.nom;
    }

    public int getMontant() {
        return this.montant;
    }

    public void faireOffre(int montant, double taux) {
        this.mesOffres.add(new OffreConcrete(++numOffre, montant, taux));
    }

    public Iterator<Offre> iterator() {
        return this.mesOffres.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Projet " + this.nom + "(" + this.montant + ")");
        for (Offre offre : this) {
            result.append("\n - " + offre);
        }
        return result.toString();
    }
}
