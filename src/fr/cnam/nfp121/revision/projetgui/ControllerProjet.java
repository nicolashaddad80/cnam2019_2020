package fr.cnam.nfp121.revision.projetgui;


import fr.cnam.nfp121.revision.DebugOnOFF;
import fr.cnam.nfp121.revision.applicationprojet.AppProjet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControllerProjet extends JPanel {


    private final JTextField valeurMontant = new JTextField(6);
    private final JLabel labelMontant = new JLabel("Montant:");
    private final JPanel panelMontant = new JPanel();

    private final JLabel labelTaux = new JLabel("Taux:");
    private final JTextField valeurTaux = new JTextField(6);
    private final JPanel panelTaux = new JPanel();

    private final JPanel panelBouton = new JPanel();
    private final JButton boutonAnnuler = new JButton("Annuler");
    private final JButton boutonPreter = new JButton("Preter");


    public ControllerProjet() {

        this.panelMontant.add(this.labelMontant, BorderLayout.EAST);
        this.panelMontant.add(this.valeurMontant, BorderLayout.WEST);


        this.panelTaux.add(this.labelTaux, BorderLayout.EAST);
        this.panelTaux.add(this.valeurTaux, BorderLayout.WEST);

        this.panelBouton.add(this.boutonAnnuler, BorderLayout.WEST);
        this.panelBouton.add(this.boutonPreter, BorderLayout.EAST);

        LayoutManager controllerLayout = new GridLayout(3, 1);
        this.setLayout(controllerLayout);
        this.add(this.panelMontant, 0);
        this.add(this.panelTaux, 1);
        this.add(this.panelBouton, 2);

        this.boutonPreter.addActionListener(this::updateModel);
        this.boutonAnnuler.addActionListener(this::cancelOffer);
    }

    private void updateModel(ActionEvent actionEvent) {

        int montant = this.getMontant();
        double taux = this.getTaux();
        boolean montantValide = this.validateMontant(montant);
        boolean tauxValide = this.validateTaux(taux);

        if (montantValide && tauxValide) {
            AppProjet.getMonObservableProjet().faireOffre(montant, taux);
            this.clearOffer();
        }
    }

    private boolean validateMontant(double montant) {
        boolean montantIsValide = false;
        if (montant >= 20) {
            this.valeurMontant.setBackground(Color.WHITE);
            montantIsValide = true;
        } else {
            this.valeurMontant.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "Le Montant doit etre superieur a 20 Euros");
        }
        return montantIsValide;
    }


    private boolean validateTaux(double taux) {
        boolean tauxIsValide = false;
        if (taux <= 10 && taux >= 4) {

            this.valeurTaux.setBackground(Color.WHITE);
            tauxIsValide = true;
        } else {
            this.valeurTaux.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "Le Taux doit etre compris entre 4 et 10");
        }
        return tauxIsValide;
    }

    private void invalidateMontant() {
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("Montant Invalide");
        this.valeurMontant.setBackground(Color.RED);
    }

    private void invalidateTaux() {
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("Taux Invalide");
        this.valeurTaux.setBackground(Color.RED);
    }

    private double getTaux() {
        double taux = -1;
        try {
            taux = Double.parseDouble(this.valeurTaux.getText());

        } catch (NumberFormatException e) {
            this.invalidateTaux();
        } catch (NullPointerException e) {

            this.invalidateTaux();
        }
        return taux;
    }


    private int getMontant() {
        int montant = -1;
        try {
            montant = Integer.parseInt(this.valeurMontant.getText());

        } catch (NumberFormatException e) {
            this.invalidateMontant();
        } catch (NullPointerException e) {

            this.invalidateMontant();
        }
        return montant;
    }

    private void cancelOffer(ActionEvent actionEvent) {
        this.clearOffer();
    }

    private void clearOffer() {

        this.valeurMontant.setText(null);
        this.valeurMontant.setBackground(Color.WHITE);

        this.valeurTaux.setText(null);
        this.valeurTaux.setBackground(Color.WHITE);
    }


}
