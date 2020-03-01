package fr.cnam.nfp121.tp13.application;

import fr.cnam.nfp121.tp13.controllers.Tp13JPanelController;
import fr.cnam.nfp121.tp13.model.ObservableSalon;
import fr.cnam.nfp121.tp13.view.Tp13JPanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TchatGui {

    private JFrame frame = new JFrame("Tchat Gui Application");
    /*Create instance of Model*/
    private ObservableSalon myModel;
    private Tp13JPanelView myTchatView;
    private Tp13JPanelController myTchatController;
    private JButton myExitButton;

    public TchatGui(ObservableSalon a_myModel) {
        this.myModel = a_myModel;
        this.myTchatView = new Tp13JPanelView(myModel);
        this.myTchatView.setSize(500, 300);
        this.myTchatController = new Tp13JPanelController(myModel);
        this.myTchatController.setSize(500, 50);
        this.myExitButton = new JButton("Fermer");
        myExitButton.addActionListener(e -> myExit());

        Container content = this.frame.getContentPane();

        /*Adding Exit Button*/
        content.add(this.myExitButton, BorderLayout.NORTH);
        /* Adding Vue Panel Part */
        JScrollPane tchat = new JScrollPane(this.myTchatView);
        tchat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tchat.setAutoscrolls(true);

        content.add(tchat, BorderLayout.CENTER);
        /* Adding controller Panel Part */
        content.add(myTchatController, BorderLayout.SOUTH);

    }

    public void start() {
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                myExit();
            }
        });
        this.frame.setSize(500, 400);
        this.frame.setVisible(true);
    }

    private void myExit() {
        this.myTchatView.destroy();
        System.out.println("Thank you Using this Application");
        this.frame.dispose();
        if (this.myModel.countObservers() == 0)
            System.exit(0);
    }
}

