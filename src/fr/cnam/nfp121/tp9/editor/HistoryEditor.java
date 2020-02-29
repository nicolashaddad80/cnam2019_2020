package fr.cnam.nfp121.tp9.editor;

import fr.cnam.nfp121.tp9.command.specification.Cancelable;
import fr.cnam.nfp121.tp9.editor.editorcommands.RedoCommand;
import fr.cnam.nfp121.tp9.editor.editorcommands.UndoCommand;
import fr.cnam.nfp121.tp9.editor.specification.HisEditor;
import fr.cnam.nfp121.tp9.history.HistoryImp;
import fr.cnam.nfp121.tp9.history.specification.History;
import fr.cnam.nfp121.tp9.menu.EntryImp;
import fr.cnam.nfp121.tp9.menu.specification.Entry;
import fr.cnam.nfp121.tp9.menu.specification.Menu;

public class HistoryEditor extends SimpleEditor implements HisEditor {

    private final History<Cancelable> undoHistory = new HistoryImp<>();
    private final History<Cancelable> redoHistory = new HistoryImp<>();


    public HistoryEditor(Menu a_Menu) {
        super(a_Menu);
        this.currentMenu.add(new EntryImp(-1, "Undo", new UndoCommand(this), "-"));
        this.currentMenu.add(new EntryImp(-2, "Redo", new RedoCommand(this), "+"));
    }


    @Override
    public History<Cancelable> getUndoHistory() {
        return this.undoHistory;
    }

    @Override
    public History<Cancelable> getRedoHistory() {
        return this.redoHistory;
    }

    @Override
    public void undo() {

        Cancelable previousCommand = this.undoHistory.pull();
        this.redoHistory.push(previousCommand);

        previousCommand.undo();

    }

    @Override
    public void redo() {

        Cancelable previousUndoneCommand = this.redoHistory.pull();
        this.undoHistory.push(previousUndoneCommand);

        previousUndoneCommand.redo();
    }


    //TODO Arch++:delegate to a proxy in further version7@


    protected void execute(Cancelable a_Command) {

        if (a_Command.isExecutable()) {


            a_Command.executer();
            /* if the command is Cancellable save command here for undo it later if the user chooses Undo from Menu
             */
            if (a_Command.isCancellable()) {
                //Pullback all RedoHistory to UndoHistory

                while (!this.redoHistory.isEmpty()) {
                    this.undoHistory.push(this.redoHistory.pull());
                }
                this.undoHistory.push(a_Command);
            }

        }
    }


    @Override
    public void editer() {
        do {

            this.currentMenu.getPrinter().print();

            Entry choice = this.currentMenu.proposer();

            if (choice.isMenu()) {
                this.currentMenu = (Menu) choice;
            } else {
                //TODO Arch++:delegate to a proxy in further version
                this.execute((Cancelable) choice.getCommand());
            }
        } while (this.currentMenu.choiceIsQuit());
    }
}
