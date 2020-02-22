package fr.cnam.nfp121.tp9;

import fr.cnam.nfp121.tp9.command.specification.Command;
import fr.cnam.nfp121.tp9.editor.SimpleEditor;
import fr.cnam.nfp121.tp9.editor.specification.Editor;
import fr.cnam.nfp121.tp9.line.LineTab;
import fr.cnam.nfp121.tp9.line.linecommands.simplelinecomm.*;
import fr.cnam.nfp121.tp9.line.specification.Line;
import fr.cnam.nfp121.tp9.menu.EntryImp;
import fr.cnam.nfp121.tp9.menu.MenuImp;
import fr.cnam.nfp121.tp9.menu.specification.Entry;
import fr.cnam.nfp121.tp9.menu.specification.Menu;

import java.io.PrintStream;

public class SimpleLineEditorLauncher {
    final PrintStream linePrinterOutputPort = System.out;
    final PrintStream menuPrinterOutputPort = System.out;

    final Menu myMenu;
    final Line myLineTab;
    final Editor mySimpleEditor;

    public SimpleLineEditorLauncher() {
        /* creating needed object to instance an editor
         */
        this.myMenu = new MenuImp(0, "Menu Principal", "", menuPrinterOutputPort);
        this.myLineTab = new LineTab(linePrinterOutputPort);
        this.mySimpleEditor = new SimpleEditor(myMenu);

        /* Filing menu and put there desired Commands
         */
        this.fillMenu();

    }


    private void fillMenu() {

        Command[] lineCommandsTable = new LineComm[20];

        //filling the Menu
        int i = 0, j = 0, c = 0, nbLineCommands = 0;
        Entry[] mainMenuList = new Entry[8];
        Entry[] subMenuList = new Entry[3];

        //Creating Commands:

        lineCommandsTable[nbLineCommands++] = new MoveBeginningCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new MoveRightCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new MoveLeftCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new AddBeginningCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new AddEndCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new ReplaceCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new DeleteCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new AddBeforeCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands++] = new AddAfterCommand(this.myLineTab);
        lineCommandsTable[nbLineCommands] = new DeleteAllCommand(this.myLineTab);

        //Creating and filling CursorSubMenu


        subMenuList[i++] = new EntryImp(i, "Placer le curseur au debut de la ligne    ", lineCommandsTable[c++], "o");
        subMenuList[i++] = new EntryImp(i, "Avancer le curseur d une position a droite", lineCommandsTable[c++], "l");
        subMenuList[i++] = new EntryImp(i, "Reculer le curseur d une position a gauche", lineCommandsTable[c++], "h");

        //filling main menu

        mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere au debut de la ligne", lineCommandsTable[c++], "I");
        mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere a la fin de la ligne", lineCommandsTable[c++], "A");
        Menu cursorSubMenu = new MenuImp(j + 1, "Menu Curseur                              ", "C", menuPrinterOutputPort);
        for (Entry entry : subMenuList) {
            cursorSubMenu.add(entry);
        }
        mainMenuList[j++] = (Entry) cursorSubMenu;
        mainMenuList[j++] = new EntryImp(j, "Remplacer le caractere sous le curseur   ", lineCommandsTable[c++], "r");
        mainMenuList[j++] = new EntryImp(j, "Supprimer le caractere sous le curseur   ", lineCommandsTable[c++], "x");
        mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere avant le curseur    ", lineCommandsTable[c++], "i");
        mainMenuList[j++] = new EntryImp(j, "Ajouter un caractere apres le curseur    ", lineCommandsTable[c++], "a");
        mainMenuList[j++] = new EntryImp(j, "Supprimer tous les caracteres de la ligne", lineCommandsTable[c], "dd");


        for (Entry entry : mainMenuList) {
            this.myMenu.add(entry);
        }

    }

    public void start() {
        this.myLineTab.getPrinter().print();
        this.mySimpleEditor.editer();
    }
}
