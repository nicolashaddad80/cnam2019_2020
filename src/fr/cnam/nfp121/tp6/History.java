package tp6;

/**
 * ____________________________________________________________________________________________<br
 * NFP121:TP6 <br>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * ____________________________________________________________________________________________<br
 * La classe History Modelise l'historique des operations d'un Compte Courant Bancaire  <br>
 * La modelisation d'un historique est represente par un tableau contenant les montants des operations dans un attribu <br>
 * ____________________________________________________________________________________________<br>
 */
public class History {

    /**
     * Tableau sauvgardant notre historique de note Compte Courant
     */
    private double[] history;

    /**
     * Constructeur de notre Historique, l'historique est vide au depart.
     */
    public History() {
        this.history = new double[0];
    }

    /**
     * Methode permettant d'ajouter une operation a notre Historique
     *
     * @param a_Amount : le montant de la transaction
     */
    public void addOperation(double a_Amount) {
        double[] l_history = new double[this.getNbOperation() + 1];
        System.arraycopy(this.history, 0, l_history, 0, this.getNbOperation());
        l_history[this.getNbOperation()] = a_Amount;
        this.history = l_history;
    }

    /**
     * Methode qui permet d'obtenir l'historique de tous les credit
     *
     * @return : l'Historique de tous les credits
     */
    public fr.cnam.tp6.History getCredit() {
        fr.cnam.tp6.History l_History = new fr.cnam.tp6.History();
        for (int i = 0; i < this.getNbOperation(); i++) {
            if (this.getOperation(i + 1) >= 0) {
                l_History.addOperation(this.getOperation(i + 1));
            }
        }
        return l_History;
    }

    /**
     * Methode qui permet d'obtenir l'historique de tous les debits
     *
     * @return : l'Historique de tous les debits
     */
    public fr.cnam.tp6.History getDebit() {
        fr.cnam.tp6.History l_History = new fr.cnam.tp6.History();
        for (int i = 0; i < this.getNbOperation(); i++) {
            if (this.getOperation(i + 1) <= 0) {
                l_History.addOperation(this.getOperation(i + 1));
            }
        }
        return l_History;
    }

    public String toString() {
        StringBuilder l_str = new StringBuilder("[\n");
        for (int i = 0; i < this.getNbOperation(); i++) {
            l_str.append((i + 1) + ", ");
            l_str.append(this.getOperation(i + 1) + "\n");
        }
        l_str.append("]");
        return l_str.toString();
    }

    /**
     * Methode permettant d'obtenir le montant d'une transaction a un moment donne. Le moment est exprime par un entier et le plus ancient est 1, retourne null si il y a aucune operation dans l'historique
     *
     * @return :  le montatn de l'operation a la position donnee, null si l'operation n'existe pas a la position donnee
     */
    public double getOperation(int a_Position) {
        assert (this.getNbOperation() != 0 & a_Position > 0 & a_Position <= this.getNbOperation()) : "No History yet at this position";
        return this.history[a_Position - 1];
    }

    /**
     * Methode pour obtenir le nombre d'operation existants dans l'historique
     *
     * @return : Le nombre d'operations sauvegardees dans l'historique, 0 si aucune operation est inscrite
     */
    public int getNbOperation() {
        return this.history.length;
    }
}