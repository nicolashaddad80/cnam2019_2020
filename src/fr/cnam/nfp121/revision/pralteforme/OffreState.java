package fr.cnam.nfp121.revision.pralteforme;

public enum OffreState {
    ONGOIG("EN-COURS"),
    REJECTED("NON-RETENUE"),
    ACCEPTED("RETENUE");

    public final String offerState;

    OffreState(String label) {
        this.offerState = label;
    }
}
