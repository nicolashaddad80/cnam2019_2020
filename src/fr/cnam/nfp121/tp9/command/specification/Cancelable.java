package fr.cnam.nfp121.tp9.command.specification;

public interface Cancelable extends Command {
    // void restoreContext( Context previousContext );


    boolean isCancellable();


    void undo();

    void redo();

}
