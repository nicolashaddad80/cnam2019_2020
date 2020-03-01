package fr.cnam.nfp121.revision.projetgui;

import fr.cnam.nfp121.revision.applicationprojet.AppProjet;
import fr.cnam.nfp121.revision.pralteforme.Offre;
import fr.cnam.nfp121.tp12.mypatterns.MyObserver;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class ProjetDisplay extends JPanel implements MyObserver {

    private JTextArea Projetdisplay;
    private JLabel infoProjet;

    public ProjetDisplay() {

        AppProjet.getMonObservableProjet().addObserver(this);

        this.infoProjet = new JLabel();
        this.Projetdisplay = new JTextArea();
        this.Projetdisplay.setLineWrap(true);
        this.Projetdisplay.setWrapStyleWord(true);
        this.Projetdisplay.setEditable(false);
        this.Projetdisplay.setColumns(45);
        this.Projetdisplay.setRows(10);
        this.Projetdisplay.setAutoscrolls(true);
        this.add(infoProjet, BorderLayout.NORTH);
        this.add(this.Projetdisplay, BorderLayout.CENTER);
        this.setAutoscrolls(false);
        this.LoadMyModel();
    }

    private void LoadMyModel() {
        // update of JLabel representing the Project at top of this panel
        this.infoProjet.setText("Offre  sur le Projet :" + AppProjet.getMonObservableProjet().getNom() + " (" + AppProjet.getMonObservableProjet().getMontant() + ")");

        //adding pralteforme offers to the text area
        for (Iterator<Offre> it = AppProjet.getMonObservableProjet().iterator(); it.hasNext(); ) {
            Offre offre = it.next();
            this.Projetdisplay.append(offre + "\n");
        }
    }

    @Override
    public void update(Object observable) {
        Offre derniereOffre = null;
        Iterator<Offre> it = AppProjet.getMonObservableProjet().iterator();
        while (it.hasNext())
            derniereOffre = it.next();

        if (derniereOffre == null)
            throw new NullPointerException();
        else
            this.Projetdisplay.append(derniereOffre + "\n");
    }

    @Override
    public void destroy() {
        AppProjet.getMonObservableProjet().deleteObserver(this);
    }

}
