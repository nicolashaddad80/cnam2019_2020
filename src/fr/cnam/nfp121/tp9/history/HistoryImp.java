package fr.cnam.nfp121.tp9.history;

import fr.cnam.nfp121.tp9.history.specification.History;

import java.util.Stack;

public class HistoryImp<T> implements History<T> {

    private final Stack<T> myStack;

    public HistoryImp() {
        this.myStack = new Stack<>();
    }

    @Override
    public void push(T a_Line) {
        this.myStack.push(a_Line);
    }

    @Override
    public T pull() {
        return this.myStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.myStack.isEmpty();
    }
}
