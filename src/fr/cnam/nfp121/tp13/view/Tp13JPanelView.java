package fr.cnam.nfp121.tp13.view;


import fr.cnam.nfp121.tp12.mypatterns.MyObserver;
import fr.cnam.nfp121.tp13.model.ObservableSalon;

import javax.swing.*;


public class Tp13JPanelView extends JPanel implements MyObserver {

    /*Attributes*/

    /*Vue Model*/

    /**
     * My Model is a simple Observable counter that I will Observe by registering me to him
     */
    private ObservableSalon myModel;
    //private MyObserver myModelObserver;

    /**
     * My Model is a simple Counter use simple swing label to show it in the screen
     */
    private JTextArea displaySalon;

    /**
     * Constructor
     *
     * @param a_myModel: A Ordered Set
     */
    public Tp13JPanelView(ObservableSalon a_myModel) {
        this.myModel = a_myModel;
        //this.myModelObserver = this::update;
        this.myModel.addObserver(this);

        this.displaySalon = new JTextArea();
        this.displaySalon.setLineWrap(true);
        this.displaySalon.setWrapStyleWord(true);
        this.displaySalon.setEditable(false);
        this.displaySalon.setColumns(45);
        this.displaySalon.setRows(40);
        this.displaySalon.setAutoscrolls(true);

        //ToClean  JScrollPane salonScrollPane = new JScrollPane(this.displaySalon);
        // ToClean  salonScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(this.displaySalon);

        this.LoadMyModel();
    }

    private void LoadMyModel() {

        for (String message : this.myModel) this.displaySalon.append(message);
    }

    @Override
    public void update(Object observable) {
        this.displaySalon.append(this.myModel.last());
    }

    /**
     * Implementing OptimizedClass as my Graphical elements are actualized on my Model notifications
     * need to unregister me from my Observable Model list
     * This is to allow garbage collector freeing my occupied memory space at my instantiation (creation)
     */

    @Override
    public void destroy() {
        this.myModel.deleteObserver(this);
    }

}
