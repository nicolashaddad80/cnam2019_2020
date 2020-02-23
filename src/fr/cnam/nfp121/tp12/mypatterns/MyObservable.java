package fr.cnam.nfp121.tp12.mypatterns;

public interface MyObservable {
    /**
     * Adds an observer to the internal list of observers.
     *
     * @param observer: The Object that will observe this Observable
     */
    void addObserver(MyObserver observer);

    /**
     * @param observer: Deletes an observer from the internal list of observers.
     */
    void deleteObserver(MyObserver observer);

    /**
     * @return: number of observers in the internal list of observers.
     */
    int countObservers();


    /**
     *  Checks the internal flag to see if the observable has changed state and notifies all observers.
     *  Passes the object specified in the parameter list to the notify() method of the observer.
     */

    void notifyObservers();

}
