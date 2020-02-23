package fr.cnam.nfp121.revision.pralteforme;

public interface Offre extends Comparable<Offre> {
    int getNumero();

    int getMontant();

    double getTaux();

    OffreState getEtat();

    void setEtat(OffreState state);
}
