package fr.cnam.nfp121.tp9.line.specification;


import fr.cnam.nfp121.tp9.printer.specification.Printable;

/**
 * Spécification d’une ligne de texte.
 *
 * @author Anaël Megna
 * @version 1.0
 */
public interface Line extends Printable {
    /**
     * Obtient le nombre de caractères dans une ligne.
     *
     * @return L'entier représentant le nombre de caractères dans une ligne.
     */
    int getLength();

    /**
     * Obtient la position du curseur sur la ligne.
     *
     * @return L'entier représentant la position du curseur sur la ligne.
     */
    int getCursorPos();

    /**
     * Fait avancer le curseur d'une position à droite.
     * Ne fonctionne que si le curseur n'est pas déjà au bout de la ligne.
     */
    void moveRight();

    /**
     * Fait avancer le curseur d'une position à gauche.
     * Ne fonctionne que si le curseur n'est pas déjà au début de la ligne.
     */
    void moveLeft();

    /**
     * Place le curseur sur le premier caractère.
     * Ne fonctionne que si la ligne est non vide.
     */
    void moveBeginning();

    /**
     * Remplace le caractère sous le curseur par le caractère c.
     * Ne fonctionne qui si la ligne est non vide.
     *
     * @param c Le nouveau caractère.
     */
    void replace(char c);

    /**
     * Supprime le caractère sous le curseur.
     * Ne fonctionne que si la ligne est non vide.
     * La position du curseur reste inchangée sauf si le dernier caractère vient d'être supprimé.
     */
    void delete();

    /**
     * Ajoute le caractère c avant le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addBefore(char c);

    /**
     * Ajoute le caractère c après le curseur.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addAfter(char c);

    /**
     * Ajoute le caractère c au début de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addBeginning(char c);

    /**
     * Ajoute le caractère c à la fin de la ligne.
     * Le curseur reste sur le même caractère.
     *
     * @param c Le caractère à ajouter.
     */
    void addEnd(char c);


}
