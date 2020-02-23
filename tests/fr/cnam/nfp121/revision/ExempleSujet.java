package fr.cnam.nfp121.revision;

import fr.cnam.nfp121.revision.pralteforme.Plateforme;
import fr.cnam.nfp121.revision.pralteforme.PlateformeConcrete;
import fr.cnam.nfp121.revision.serialiseurxml.Serialiseur;
import fr.cnam.nfp121.revision.serialiseurxml.SerialiseurConcret;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ExempleSujet {

    static public Plateforme getPlateformeSujet() {
        Plateforme exemple = new PlateformeConcrete();
        exemple.nouveauProjet("XYZ", 120000);
        exemple.faireOffre("XYZ", 50, 7.5);
        exemple.faireOffre("XYZ", 90, 8.3);
        exemple.faireOffre("XYZ", 20, 9.9);
        exemple.faireOffre("XYZ", 50, 5.0);
        exemple.faireOffre("XYZ", 68, 6.9);
        exemple.nouveauProjet("ABC", 30000);
        return exemple;
    }

    public static void main(String[] args) throws Exception {
        Plateforme exemple = getPlateformeSujet();
        Writer monFichierxml = null;
        //TO Clean Surround with try catch
        //TO Clean Surround with try catch
        try {
            monFichierxml = new FileWriter("ExempleSujetPlateforme.xml");
        } catch (IOException e) {
            System.out.println("Problem sur le fichier créé");
            //Not mandatory to close FileWriter as it is autoClosable
        }
        try {
            Serialiseur monSerialiseur = new SerialiseurConcret();
            monSerialiseur.serialiser(exemple, monFichierxml);
        } catch (IOException e) {
            System.out.println("Problem sur le fichier DTD");
            //Not mandatory to close FileWriter as it is autoClosable
        }
    }
}
