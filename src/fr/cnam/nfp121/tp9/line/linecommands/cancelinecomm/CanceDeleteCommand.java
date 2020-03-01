package fr.cnam.nfp121.tp9.line.linecommands.cancelinecomm;

import fr.cnam.nfp121.tp9.line.specification.ClonableLine;

public class CanceDeleteCommand extends CancelableLinComm {

    public CanceDeleteCommand(ClonableLine a_Line) {
        super(a_Line);
    }

    public void executer() {
        this.saveExecContext();
        CancelableLinComm.clonableLine.delete();
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return CancelableLinComm.clonableLine.getCursorPos() > 0;
    }
}
