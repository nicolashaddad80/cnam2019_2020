package fr.cnam.nfp121.revision.serialiseurxml;

import fr.cnam.nfp121.revision.pralteforme.Plateforme;

import java.io.IOException;

public interface Serialiseur {

    /**
     * Sérialiser les données de la plateforme en XML sur le flot out.
     */
    void serialiser(Plateforme plateforme, java.io.Writer out)
            throws IOException;
}