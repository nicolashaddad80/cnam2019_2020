package fr.cnam.nfp121.tp9.line;


import fr.cnam.nfp121.tp9.line.specification.ClonableLine;

import java.io.PrintStream;

@SuppressWarnings({"ALL", "JavaDoc"})
public class ClonableLineTab extends LineTab implements ClonableLine {
    /**
     * Constructeur de notre ligne  "ligne vide a la créationé
     *
     * @param a_lineOutStream
     */
    @SuppressWarnings("JavaDoc")
    public ClonableLineTab(PrintStream a_lineOutStream) {
        super(a_lineOutStream);
    }

    @Override
    public ClonableLine lineClone() {
        ClonableLineTab clone_Line = new ClonableLineTab(this.lineOutStream);
        clone_Line.cursorPosition = this.cursorPosition;

        clone_Line.carTable = new char[this.getLength()];
        System.arraycopy(this.carTable, 0, clone_Line.carTable, 0, this.getLength());


        return clone_Line;
    }
}
