package fr.cnam.nfp121.tp9.line.linecommands.cancelinecomm;


import fr.cnam.nfp121.tp9.command.specification.Cancelable;
import fr.cnam.nfp121.tp9.history.HistoryImp;
import fr.cnam.nfp121.tp9.history.specification.History;
import fr.cnam.nfp121.tp9.line.specification.ClonableLine;

public abstract class CancelableLinComm implements Cancelable {
    protected static final History<ClonableLine> undoLineHistory = new HistoryImp<>();
    protected static final History<ClonableLine> redoLineHistory = new HistoryImp<>();
    /**
     * Attributes
     */
    protected static ClonableLine clonableLine;


    public CancelableLinComm(ClonableLine a_clonableLine) {

        CancelableLinComm.clonableLine = a_clonableLine;
    }


    public void undo() {
        ClonableLine lastExecutedLine = CancelableLinComm.undoLineHistory.pull();
        CancelableLinComm.redoLineHistory.push(CancelableLinComm.clonableLine.lineClone());
        CancelableLinComm.clonableLine = lastExecutedLine;
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    @Override
    public void redo() {

        ClonableLine lastUndoneLine = CancelableLinComm.redoLineHistory.pull();
        CancelableLinComm.undoLineHistory.push(CancelableLinComm.clonableLine.lineClone());
        CancelableLinComm.clonableLine = lastUndoneLine;
        CancelableLinComm.clonableLine.getPrinter().print();
    }

    protected final void saveExecContext() {

        //Pullback all RedoHistory to UndoHistory
        while (!CancelableLinComm.redoLineHistory.isEmpty()) {

            CancelableLinComm.undoLineHistory.push(CancelableLinComm.redoLineHistory.pull());
        }
        //saving current line context
        CancelableLinComm.undoLineHistory.push(CancelableLinComm.clonableLine.lineClone());
    }

    /**
     * to check if a command is cancellable inorder to save its context and to allow the invoker to save it in its commands history
     */
    public boolean isCancellable() {
        return true;
    }
}
