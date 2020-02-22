package fr.cnam.nfp121.tp9.menu.specification;

import fr.cnam.nfp121.tp9.command.specification.Command;

public interface Entry {

    String toString();

    Command getCommand();

    boolean isMenu();

    String getShortcut();

    Integer getNumber();
}
