package fr.cnam.nfp121.tp8;

public class AmountException extends Exception {
    private int amountError;

    public AmountException(String message, int a_Solde) {
        super(message);
        this.amountError = a_Solde;

    }

    public int getAmount() {
        return this.amountError;
    }
}
