package fr.cnam.nfp121.tp9.line.linecommands.cancelinecomm;

import fr.cnam.nfp121.tp9.line.specification.ClonableLine;

public class CanceDeleteAllCommand extends CancelableLinComm {

    public CanceDeleteAllCommand(ClonableLine a_Line) {
        super(a_Line);
    }

    public void executer() {
        this.saveExecContext();
        while (CancelableLinComm.clonableLine.getLength() > 0) {
            CancelableLinComm.clonableLine.delete();
        }
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return CancelableLinComm.clonableLine.getLength() > 0;
    }
}
