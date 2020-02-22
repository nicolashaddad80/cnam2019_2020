package fr.cnam.nfp121.tp9.printer;

import fr.cnam.nfp121.tp9.printer.specification.Printer;

import java.io.PrintStream;

public abstract class AbsPrinter implements Printer {
    protected final PrintStream printerOutPort;

    public AbsPrinter(PrintStream a_outStram) {
        this.printerOutPort = a_outStram;
    }
}
