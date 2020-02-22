package fr.cnam.nfp121.tp9.line.linecommands.cancelinecomm;

import fr.cnam.nfp121.tp9.line.specification.ClonableLine;

public class CanceAddBeginningCommand extends CanceAddCommand {

    public CanceAddBeginningCommand(ClonableLine a_Line) {
        super(a_Line);
    }

    public void executer() {
        this.saveExecContext();
        CancelableLinComm.clonableLine.addBeginning(this.getCarToInsert());
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return true;
    }
}
