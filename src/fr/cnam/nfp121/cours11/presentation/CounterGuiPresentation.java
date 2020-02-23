package fr.cnam.nfp121.cours11.presentation;

import fr.cnam.nfp121.cours11.controllers.PanelController;
import fr.cnam.nfp121.cours11.model.Counter;
import fr.cnam.nfp121.cours11.vue.PanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CounterGuiPresentation {
    private JFrame frame = new JFrame("CounterGuiPresentation");
    /*Create instance of Model*/
    private Counter myModel;
    private PanelView myCounterVue;
    private PanelController myController;

    public CounterGuiPresentation(Counter a_myModel) {
        this.myModel = a_myModel;
        this.myCounterVue = new PanelView(myModel);
        this.myController = new PanelController(myModel);
        JButton myExitButton = new JButton("Quitter");

        Container content = this.frame.getContentPane();
        content.setLayout(new FlowLayout());
        /* Adding Vue Panel Part */
        content.add(this.myCounterVue);
        /* Adding controller Panel Part */
        content.add(myController);
        myExitButton.addActionListener(e -> myExit());
        /*Adding Exit Button*/
        content.add(myExitButton);
    }

    public void start() {
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                myExit();
            }
        });
        this.frame.setSize(500, 100);
        this.frame.setVisible(true);
    }

    private void myExit() {
        this.myCounterVue.destroy();
        System.out.println("Thank you Using this Application");
        this.frame.dispose();
        if (this.myModel.countObservers() == 0)
            System.exit(0);
    }
}
