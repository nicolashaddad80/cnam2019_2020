package fr.cnam.nfp121.tp9.editor.specification;

import fr.cnam.nfp121.tp9.command.specification.Cancelable;
import fr.cnam.nfp121.tp9.history.specification.History;

public interface HisEditor extends Editor {
    void undo();

    void redo();

    History<Cancelable> getRedoHistory();

    History<Cancelable> getUndoHistory();
}
