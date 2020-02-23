package fr.cnam.nfp121.revision.pralteforme;

public class OffreConcrete implements Offre {
    private int numero;
    private int montant;
    private double taux;
    private OffreState etat;

    public OffreConcrete(int numero, int montant, double taux) {
        this.numero = numero;
        this.montant = montant;
        this.taux = taux;
        this.etat = OffreState.ONGOIG;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getMontant() {
        return this.montant;
    }

    public double getTaux() {
        return this.taux;
    }

    public String toString() {
        return String.format("%4d. %8d a%5.1f", this.numero, this.montant, this.taux);
    }

    @Override
    public int compareTo(Offre offre) {
        return this.numero - offre.getNumero();
    }

    @Override
    public OffreState getEtat() {
        return this.etat;
    }

    @Override
    public void setEtat(OffreState state) {
        this.etat = state;
    }
}