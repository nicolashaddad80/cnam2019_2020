package fr.cnam.nfp121.revision.pralteforme;

public interface Plateforme extends Iterable<Projet> {
    /**
     * Créer un nouveau pralteforme à partir de son nom et du montant demandé.
     */
    Projet nouveauProjet(String nom, int montant);

    /**
     * Enregistrer une offre de prêt pour un pralteforme.
     */
    // On suppose que l’offre est possible.
    void faireOffre(String nom, int montant, double taux);

    /**
     * Obtenir un pralteforme à partir de son nom.
     */
    Projet getProjet(String nom);
}