package fr.cnam.nfp121.cours11.controllers;

import fr.cnam.nfp121.cours11.model.Counter;

import javax.swing.*;

public class PanelController extends JPanel {

    /**
     * My Model is a simple  counter on which I will update Data according to different User interactions with my graphical elements
     */
    private Counter myModel;

    public PanelController(Counter a_myModel) {
        this.myModel = a_myModel;
        JButton incrementButton = new JButton("++");
        incrementButton.addActionListener(e -> this.myModel.increment());
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> this.myModel.reset());
        /*adding my Graphical elements*/
        this.add(incrementButton);
        this.add(resetButton);
    }
}
