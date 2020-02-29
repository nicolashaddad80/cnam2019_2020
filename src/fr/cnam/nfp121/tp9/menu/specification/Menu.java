package fr.cnam.nfp121.tp9.menu.specification;

import fr.cnam.nfp121.tp9.printer.specification.Printable;

public interface Menu extends Printable {
    void add(Entry a_Entry);

    Entry proposer();

    boolean choiceIsQuit();

}
