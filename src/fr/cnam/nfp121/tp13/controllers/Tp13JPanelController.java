package fr.cnam.nfp121.tp13.controllers;


import fr.cnam.nfp121.tp13.DebugOnOFF;
import fr.cnam.nfp121.tp13.model.ObservableSalon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.Date;

public class Tp13JPanelController extends JPanel {

    public static int userNumber = 1;

    private ObservableSalon myModel;
    private JLabel userLabel;
    private JTextField userMessageField;
    private JButton okButton;


    public Tp13JPanelController(ObservableSalon a_myModel) {
        this.myModel = a_myModel;
        this.userLabel = new JLabel("User " + (Tp13JPanelController.userNumber++) + ":");
        this.userMessageField = new JTextField(null);
        this.userMessageField.setColumns(30);
        this.okButton = new JButton("ok");
        okButton.addActionListener(this::updateMode);
        /*if user wants to send message by just pressing Enter key*/
        userMessageField.addActionListener(e -> okButton.doClick());

        /*adding my Graphical elements*/
        this.add(this.userLabel, BorderLayout.WEST);
        this.add(this.userMessageField, BorderLayout.CENTER);
        this.add(this.okButton, BorderLayout.EAST);
    }

    private void updateMode(ActionEvent actionEvent) {

        //Date object
        Date date = new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        if (!userMessageField.getText().isEmpty()) {
            this.myModel.add(ts + "  " + this.userLabel.getText() + this.userMessageField.getText() + DebugOnOFF.newline);
            this.userMessageField.setText("");
        }
    }
}
