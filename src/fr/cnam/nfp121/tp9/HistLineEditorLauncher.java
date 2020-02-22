package fr.cnam.nfp121.tp9;

import fr.cnam.nfp121.tp9.editor.HistoryEditor;
import fr.cnam.nfp121.tp9.command.specification.Cancelable;
import fr.cnam.nfp121.tp9.editor.specification.HisEditor;
import fr.cnam.nfp121.tp9.line.ClonableLineTab;
import fr.cnam.nfp121.tp9.line.linecommands.cancelinecomm.*;
import fr.cnam.nfp121.tp9.line.specification.ClonableLine;
import fr.cnam.nfp121.tp9.menu.EntryImp;
import fr.cnam.nfp121.tp9.menu.MenuImp;
import fr.cnam.nfp121.tp9.menu.specification.Entry;
import fr.cnam.nfp121.tp9.menu.specification.Menu;

import java.io.PrintStream;

public class HistLineEditorLauncher {

    private final PrintStream linePrinterOutputPort = System.out;
    private final PrintStream menuPrinterOutputPort = System.out;

    private final Menu myMenu;
    private final ClonableLine myClonableLineTab;
    private final HisEditor myHisEditor;

    public HistLineEditorLauncher() {
        /* creating needed object to instance an editor
         */

        this.myMenu = new MenuImp(0, "Menu Principal", "", menuPrinterOutputPort);
        this.myClonableLineTab = new ClonableLineTab(linePrinterOutputPort);
        this.myHisEditor = new HistoryEditor(myMenu);

        /* Filing menu and put there desired Commands
         */
        this.fillMenu();

    }

    private void fillMenu() {

        Cancelable[] lineCommandsTable = new CancelableLinComm[20];

        //filling the Menu
        int i = 0, j = 0, c = 0, nbLineCommands = 0;
        Entry[] mainMenuList = new Entry[8];
        Entry[] subMenuList = new Entry[3];

        //Creating Commands:

        lineCommandsTable[nbLineCommands++] = new CanceMoveBeginningCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceMoveRightCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceMoveLeftCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceAddBeginningCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceAddEndCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceReplaceCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceDeleteCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceAddBeforeCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands++] = new CanceAddAfterCommand(this.myClonableLineTab);
        lineCommandsTable[nbLineCommands] = new CanceDeleteAllCommand(this.myClonableLineTab);


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
        this.myClonableLineTab.getPrinter().print();
        this.myHisEditor.editer();

    }

}

