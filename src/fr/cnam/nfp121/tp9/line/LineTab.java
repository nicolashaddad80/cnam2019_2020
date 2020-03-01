package fr.cnam.nfp121.tp9.line;

import fr.cnam.nfp121.tp9.line.specification.Line;
import fr.cnam.nfp121.tp9.printer.AbsPrinter;
import fr.cnam.nfp121.tp9.printer.specification.Printer;
import fr.cnam.nfp121.tp9.textformating.TextColor;

import java.io.PrintStream;

public class LineTab implements Line {

    /**
     * Attributes
     */
    protected final PrintStream lineOutStream;
    private final Printer linePrinter;
    /**
     * Tableau de stockage des carastères de la ligne
     */
    protected char[] carTable;
    /**
     * La position du curseur pointant sur le caractère courant
     */
    protected int cursorPosition;

    /**
     * Constructeur de notre ligne  "ligne vide a la créationé
     */
    public LineTab(PrintStream a_lineOutStream) {
        this.carTable = new char[0];
        this.cursorPosition = 0;
        this.lineOutStream = a_lineOutStream;
        this.linePrinter = new LinePrinter(this.lineOutStream);
    }

    @Override
    public Printer getPrinter() {
        return this.linePrinter;
    }

    private String afficher() {
        StringBuilder lineString = new StringBuilder("--------------------------------------------------------\n\t\t\t" + TextColor.GREEN.set + "Je suis la ligne a editer:\n" + TextColor.DEFAULT.set);
        if (this.getLength() == 0) {
            lineString.append(TextColor.RED.set).append('~').append(TextColor.DEFAULT.set);
        } else {
            for (int i = 0; i < this.getCursorPos() - 1; i++) {

                lineString.append(TextColor.BLUE.set).append(this.carTable[i]).append(TextColor.DEFAULT.set);
            }
            lineString.append(TextColor.RED.set).append("[").append(TextColor.DEFAULT.set).append(TextColor.BLACK.set).append(TextColor.Highlight.set).append(this.carTable[this.getCursorPos() - 1]).append(TextColor.DEFAULT.set).append(TextColor.RED.set).append("]").append(TextColor.DEFAULT.set);

            for (int i = this.getCursorPos(); i < this.getLength(); i++) {

                lineString.append(TextColor.BLUE.set).append(this.carTable[i]).append(TextColor.DEFAULT.set);
            }
        }
        lineString.append('\n');

        return lineString.toString();
    }

    /**
     * Obtient le nombre de caractères dans une ligne.
     *
     * @return L'entier représentant le nombre de caractères dans une ligne.
     */
    public int getLength() {
        return this.carTable.length;
    }

    /**
     * Obtient la position du curseur sur la ligne.
     *
     * @return L'entier représentant la position du curseur sur la ligne.
     */
    public int getCursorPos() {
        return this.cursorPosition;

    }

    /**
     * Fait avancer le curseur d'une position à droite.
     * Ne fonctionne que si le curseur n'est pas déjà au bout de la ligne.
     */
    public void moveRight() {
        if (this.getCursorPos() == this.getLength()) {
            //Through Exception
            throw new RuntimeException("Cursor Already Reached End of Line");
        } else {
            this.cursorPosition++;
        }
    }

    /**
     * Fait avancer le curseur d'une position à gauche.
     * Ne fonctionne que si le curseur n'est pas déjà au début de la ligne.
     */
    public void moveLeft() {
        if (this.getCursorPos() < 2) {
            //Through Exception
            throw new RuntimeException("Cursor Already Reached the Beginning of Line");
        } else {
            this.cursorPosition--;
        }

    }

    /**
     * Place le curseur sur le premier caractère.
     * Ne fonctionne que si la ligne est non vide.
     */
    public void moveBeginning() {

        if (this.getLength() == 0) {
            //Through Exception
            throw new RuntimeException("Cursor Already Reached the Beginning of Line");
        } else {
            this.cursorPosition = 1;
        }
    }

    /**
     * Remplace le caractère sous le curseur par le caractère c.
     * Ne fonctionne qui si la ligne est non vide.
     *
     * @param c Le nouveau caractère.
     */
    public void replace(char c) {

        if (this.getLength() == 0) {
            //Through Exception
            throw new RuntimeException("There is no Cursor yet as line is Empty try to insert a character first ");
        } else {
            this.carTable[this.cursorPosition - 1] = c;
        }
    }

    /**
     * Supprime le caractère sous le curseur.
     * Ne fonctionne que si la ligne est non vide.
     * La position du curseur reste inchangée sauf si le dernier caractère vient d'être supprimé.
     */
    public void delete() {
        if (this.getLength() == 0) {
            //Through Exception
            throw new RuntimeException("There is no Cursor yet as line is Empty try to insert a character first ");
        } else {
            char[] tempTab = new char[this.getLength() - 1];
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getCursorPos() - 1);
            System.arraycopy(this.carTable, this.getCursorPos(), tempTab, this.getCursorPos() - 1, this.getLength() - this.getCursorPos());
            this.carTable = tempTab;
        }

        if (this.cursorPosition > this.getLength()) {
            this.cursorPosition--;
        }
    }

    /**
     * Ajoute le caractère c avant le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addBefore(char c) {
        char[] tempTab = new char[this.getLength() + 1];
        if (this.getLength() == 0) {
            //Through Exception
            throw new RuntimeException("There is no Cursor yet as line is Empty try to insert a character first ");
        } else {
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getCursorPos() - 1);
            tempTab[this.getCursorPos() - 1] = c;
            System.arraycopy(this.carTable, this.getCursorPos() - 1, tempTab, this.getCursorPos(), this.getLength() - this.getCursorPos() + 1);
            this.cursorPosition++;
            this.carTable = tempTab;
        }

    }

    /**
     * Ajoute le caractère c après le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addAfter(char c) {

        char[] tempTab = new char[this.getLength() + 1];
        if (this.getLength() == 0) {
            //Through Exception
            throw new RuntimeException("There is no Cursor yet as line is Empty try to insert a character first ");
        } else {
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getCursorPos());
            tempTab[this.getCursorPos()] = c;
            System.arraycopy(this.carTable, this.getCursorPos(), tempTab, this.getCursorPos() + 1, this.getLength() - this.getCursorPos());
            this.carTable = tempTab;
        }
    }

    /**
     * Ajoute le caractère c au début de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addBeginning(char c) {
        char[] tempTab = new char[this.getLength() + 1];
        if (this.getLength() == 0) {
            tempTab[0] = c;
        } else {
            tempTab[0] = c;
            System.arraycopy(this.carTable, 0, tempTab, 1, this.getLength());
        }
        this.cursorPosition++;
        this.carTable = tempTab;
    }

    /**
     * Ajoute le caractère c à la fin de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    public void addEnd(char c) {
        char[] tempTab = new char[this.getLength() + 1];
        if (this.getLength() == 0) {
            tempTab[0] = c;
            this.cursorPosition++;
        } else {
            System.arraycopy(this.carTable, 0, tempTab, 0, this.getLength());
            tempTab[this.getLength()] = c;
        }

        this.carTable = tempTab;
    }

    /**
     * Private classes
     */
    private class LinePrinter extends AbsPrinter {

        public LinePrinter(PrintStream a_LinePrinterPort) {
            super(a_LinePrinterPort);
        }

        @Override
        public void print() {
            this.printerOutPort.print(afficher());
        }
    }


}
