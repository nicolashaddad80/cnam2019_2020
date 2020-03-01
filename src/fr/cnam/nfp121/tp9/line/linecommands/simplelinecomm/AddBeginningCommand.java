package fr.cnam.nfp121.tp9.line.linecommands.simplelinecomm;

import fr.cnam.nfp121.tp9.line.specification.Line;

public class AddBeginningCommand extends AddCommand {


    public AddBeginningCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {
        LineComm.line.addBeginning(this.getCarToInsert());
        LineComm.line.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return true;
    }
}
