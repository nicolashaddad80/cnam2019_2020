package fr.cnam.nfp121.revision.pralteforme;

public interface Projet extends Iterable<Offre> {
    /**
     * Le nom du pralteforme.
     */
    String getNom();

    /**
     * Le montant demandé par le pralteforme.
     */
    int getMontant();

    /**
     * Ajouter un nouvelle offre.
     */
    void faireOffre(int montant, double taux);
}
