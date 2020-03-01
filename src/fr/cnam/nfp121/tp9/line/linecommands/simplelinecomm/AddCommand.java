package fr.cnam.nfp121.tp9.line.linecommands.simplelinecomm;

import fr.cnam.nfp121.tp9.line.specification.Line;

import java.util.Scanner;

public abstract class AddCommand extends LineComm {

    public AddCommand(Line a_Line) {
        super(a_Line);
    }

    protected final char getCarToInsert() {

        Scanner myCharReader = new Scanner(System.in);
        System.out.println("Tapez un caractere ");
        return myCharReader.next().charAt(0);
    }

}
