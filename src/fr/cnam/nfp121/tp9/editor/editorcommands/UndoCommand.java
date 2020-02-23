package fr.cnam.nfp121.tp9.editor.editorcommands;

import fr.cnam.nfp121.tp9.editor.HistoryEditor;

public class UndoCommand extends EditorCommand {

    public UndoCommand(HistoryEditor a_Hiseditor) {
        super(a_Hiseditor);
    }

    @Override
    public void executer() {
        this.editor.undo();
    }

    @Override
    public boolean isExecutable() {

        return (!(this.editor.getUndoHistory().isEmpty()));
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
