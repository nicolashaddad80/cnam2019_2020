package fr.cnam.nfp121.tp9.menu;

import fr.cnam.nfp121.tp9.menu.menucommands.ExitCommand;
import fr.cnam.nfp121.tp9.menu.menucommands.MenuUpCommand;
import fr.cnam.nfp121.tp9.menu.menucommands.NoopCommand;
import fr.cnam.nfp121.tp9.menu.specification.Entry;
import fr.cnam.nfp121.tp9.menu.specification.Menu;
import fr.cnam.nfp121.tp9.printer.AbsPrinter;
import fr.cnam.nfp121.tp9.printer.specification.Printer;
import fr.cnam.nfp121.tp9.textformating.TextColor;

import java.io.PrintStream;
import java.util.*;

public class MenuImp extends EntryImp implements Menu {


    /**
     * Attributes
     */
    private final Hashtable<Integer, Entry> entree = new Hashtable<>(20);
    private final Hashtable<String, Entry> shortcutTable = new Hashtable<>(20);
    private final MenuPrinter menuPrinter;
    private MenuImp parent = this;
    private Entry choice = this;

    public MenuImp(int a_MenuNum, String a_text, String a_Shortcut, PrintStream a_menuOutStream) {
        super(a_MenuNum, a_text, new NoopCommand(), a_Shortcut);
        this.menuPrinter = new MenuPrinter(a_menuOutStream);
        this.add(new EntryImp(0, "Quitter", new ExitCommand(), "Q"));
    }

    /**
     * Methods
     */
    @Override
    public Printer getPrinter() {
        return menuPrinter;
    }

    public String afficher() {
        StringBuilder menuElementsString = new StringBuilder("--------------------------------------------------------\n\t\t\t\t" + TextColor.GREEN.set + this.text + TextColor.DEFAULT.set + '\n' + "--------------------------------------------------------\n");

        Vector<Integer> sortedEntry = null;
        try {
            sortedEntry = new Vector<>(entree.keySet());
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (sortedEntry != null)
                Collections.sort(sortedEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Iterator<Integer> it = null;
        if (sortedEntry != null) {
            it = sortedEntry.iterator();
        }

        if (it != null) {
            while (it.hasNext()) {
                Integer entryKey = it.next();
                Entry entry = entree.get(entryKey);

                if (entryKey > 0) {
                    if (entry.getCommand().isExecutable()) {

                        menuElementsString.append(TextColor.GREEN.set).append(entryKey).append(TextColor.DEFAULT.set);
                        menuElementsString.append(") ").append(entry.toString()).append("\t\t[").append(TextColor.GREEN.set).append(entry.getShortcut()).append(TextColor.DEFAULT.set).append("]\n");
                    } else {
                        menuElementsString.append(TextColor.RED.set).append("-").append(TextColor.DEFAULT.set);
                        menuElementsString.append(") ").append(entry.toString()).append("\t\t[").append(TextColor.RED.set).append(entry.getShortcut()).append(TextColor.DEFAULT.set).append("]\n");

                    }

                }

            }
        }

        if (sortedEntry != null) {
            Collections.reverse(sortedEntry);
            it = sortedEntry.iterator();
        }

        if (it != null) {
            while (it.hasNext()) {
                Integer entryKey = it.next();
                Entry entry = entree.get(entryKey);
                if (entryKey <= 0) {
                    if (entry.getCommand().isExecutable()) {
                        menuElementsString.append(TextColor.GREEN.set).append(entryKey).append(TextColor.DEFAULT.set);
                        menuElementsString.append(") ").append(entry.toString()).append("\t\t[").append(TextColor.GREEN.set).append(entry.getShortcut()).append(TextColor.DEFAULT.set).append("]\n");
                    } else {
                        menuElementsString.append(TextColor.RED.set).append("-").append(TextColor.DEFAULT.set);
                        menuElementsString.append(") ").append(entry.toString()).append("\t\t[").append(TextColor.RED.set).append(entry.getShortcut()).append(TextColor.DEFAULT.set).append("]\n");
                    }
                }
            }
        }

        menuElementsString.append("--------------------------------------------------------\n");

        return menuElementsString.toString();
    }

    public Entry proposer() {

        System.out.println("Veuillez choisir la commande :");
        boolean ok = false;

        Scanner scanner = new Scanner(System.in);


        while (!ok) {
            Integer choix;
            String shortcut;
            try {
                choix = scanner.nextInt();

                if (this.entree.containsKey(choix) && this.entree.get(choix).getCommand().isExecutable()) {
                    ok = true;
                    this.choice = this.entree.get(choix);
                }

            } catch (InputMismatchException e) {
                try {
                    shortcut = scanner.nextLine();
                    if (this.shortcutTable.containsKey(shortcut)) {
                        Entry tempChoice = this.shortcutTable.get(shortcut);
                        if (tempChoice.getCommand().isExecutable()) {
                            ok = true;
                            this.choice = tempChoice;
                        }
                    }

                } catch (Exception e1) {
                    System.out.println("Exception should be trown  but muted for the moment");
                }

            } finally {
                if (ok) {
                    if (this.choiceIsNavigateUp()) {
                        this.choice = this.parent;
                    }
                } else {
                    System.out.println("Il faut choisir une commande valide:");
                }
            }
        }
        return this.choice;

    }

    public void add(Entry menuComp) {
        if (menuComp.isMenu()) {
            EntryImp back = new EntryImp(((MenuImp) menuComp).entree.size(), "Retour", new MenuUpCommand(), "U");
            ((MenuImp) menuComp).add(back);
            ((MenuImp) menuComp).parent = this;

        }
        this.entree.put(menuComp.getNumber(), menuComp);
        this.shortcutTable.put(menuComp.getShortcut(), menuComp);
    }

    public boolean choiceIsQuit() {
        return !(this.choice.getCommand() instanceof ExitCommand);
    }

    public boolean choiceIsNavigateUp() {
        return this.choice.getCommand() instanceof MenuUpCommand;
    }

    @Override
    public final boolean isMenu() {
        return true;
    }

    /**
     * Private classes
     */
    private class MenuPrinter extends AbsPrinter {


        public MenuPrinter(PrintStream a_MenuPrinterPort) {
            super(a_MenuPrinterPort);
        }

        @Override
        public void print() {
            this.printerOutPort.print(afficher());
        }
    }
}
