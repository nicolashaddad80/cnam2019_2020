package fr.cnam.nfp121.revision.serialiseurxml;

import fr.cnam.nfp121.revision.pralteforme.Offre;
import fr.cnam.nfp121.revision.pralteforme.Plateforme;
import fr.cnam.nfp121.revision.pralteforme.Projet;
import org.jdom2.Attribute;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.util.Iterator;

public class SerialiseurConcret implements Serialiseur {


    public void serialiser(Plateforme plateforme, java.io.Writer out)
            throws IOException {
        // Création du document XML
        Element racine = new Element("crowdlending");
        DocType docType = new DocType("crowdlending", "crowdlending.dtd");
        Document document = new Document(racine, docType);
        // Production du fichier XML en se basant sur la DTD Fournis
        for (Projet projetObject : plateforme) {

            Element xmlProjet = new Element("projet");
            xmlProjet.setAttribute(new Attribute("nom", projetObject.getNom()));
            Element xmlMontant = new Element("montant");
            xmlMontant.setText(Integer.toString(projetObject.getMontant()));
            xmlProjet.addContent(xmlMontant);

            for (Iterator<Offre> it = projetObject.iterator(); it.hasNext(); ) {
                Offre offreObject = it.next();
                Element xmlOffre = new Element("offre");
                xmlOffre.setAttribute(new Attribute("montant", Integer.toString(offreObject.getMontant())));
                xmlOffre.setAttribute(new Attribute("taux", Double.toString(offreObject.getTaux())));
                xmlOffre.setAttribute(new Attribute("numéro", Integer.toString(offreObject.getNumero())));
                xmlOffre.setAttribute(new Attribute("état", offreObject.getEtat().offerState));
                xmlProjet.addContent(xmlOffre);
            }
            racine.addContent(xmlProjet);
        }

        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, out);
    }
}