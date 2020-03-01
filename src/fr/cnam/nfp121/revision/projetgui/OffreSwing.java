package fr.cnam.nfp121.revision.projetgui;

import fr.cnam.nfp121.revision.applicationprojet.AppProjet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OffreSwing {

    private final JFrame fenetre;
    private final ProjetDisplay monAffichageProjet = new ProjetDisplay();
    private final ControllerProjet monControlleurProjet = new ControllerProjet();


    public OffreSwing() {
        this.fenetre = new JFrame("Offre de pret");
        Container content = this.fenetre.getContentPane();
        content.add(this.monAffichageProjet, BorderLayout.NORTH);
        content.add(this.monControlleurProjet, BorderLayout.CENTER);

        this.fenetre.setSize(500, 470);
        this.fenetre.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                myExit();
            }
        });
    }

    public void start() {
        this.fenetre.setVisible(true);
    }

    private void myExit() {
        this.monAffichageProjet.destroy();
        System.out.println("Thank you Using this Application");
        this.fenetre.dispose();
        if (AppProjet.getMonObservableProjet().countObservers() == 0)
            System.exit(0);
    }
}
