package fr.cnam.nfp121.tp9.editor.editorcommands;

import fr.cnam.nfp121.tp9.editor.specification.HisEditor;

public class RedoCommand extends EditorCommand {

    public RedoCommand(HisEditor a_Hiseditor) {
        super(a_Hiseditor);
    }

    @Override
    public void executer() {
        this.editor.redo();
    }

    @Override
    public boolean isExecutable() {
        return (!this.editor.getRedoHistory().isEmpty());
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
