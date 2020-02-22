package fr.cnam.nfp121.tp9.editor.editorcommands;

import fr.cnam.nfp121.tp9.command.specification.Cancelable;
import fr.cnam.nfp121.tp9.editor.specification.HisEditor;

public abstract class EditorCommand implements Cancelable {
    public final HisEditor editor;

    public EditorCommand(HisEditor a_Editor) {
        this.editor = a_Editor;
    }

    @Override
    public boolean isCancellable() {
        return false;
    }
}
