package fr.cnam.nfp121.cours11.vue;

import fr.cnam.nfp121.cours11.model.Counter;
import fr.cnam.nfp121.cours11.mydesignpatterns.observer.MyObserver;
import fr.cnam.nfp121.cours11.mydesignpatterns.observer.OptimizedClass;

import javax.swing.*;

public class PanelView extends JPanel implements OptimizedClass {

    /*Attributes*/

    /*Vue Model*/

    /**
     * My Model is a simple Observable counter that I will Observe by registering me to him
     */
    private Counter myModel;
    private MyObserver myModelObserver;

    /**
     * My Model is a simple Counter use simple swing label to show it in the screen
     */
    private JLabel displayCounterValue;

    /**
     * Constructor
     *
     * @param a_myModel: A simple counter as a Model for me.
     */
    public PanelView(Counter a_myModel) {
        this.myModel = a_myModel;
        this.myModelObserver = this::updateMyModelValue;
        this.myModel.registerObserver(myModelObserver);
        this.displayCounterValue = new JLabel();
        this.add(this.displayCounterValue);
        this.updateMyModelValue();
    }

    private void updateMyModelValue() {
        this.displayCounterValue.setText("" + myModel.getValue());
    }

    /**
     * Implementing OptimizedClass as my Graphical elements are actualized on my Model notifications
     * need to unregister me from my Observable Model list
     * This is to allow garbage collector freeing my occupied memory space at my instantiation (creation)
     */

    @Override
    public void destroy() {
        this.myModel.unregisterObserver(this.myModelObserver);
    }
}


