package fr.cnam.smb111.cours02.tp2_3;

import java.util.Scanner;

public class MenuImpl implements Menu{
    @Override
    public void printMenu() {
        System.out.println("======================================");
        System.out.println("|        Counter Client Menu          |");
        System.out.println("======================================");
        System.out.println("1- Increment My Server Counter        |");
        System.out.println("2- Decrement My Server Counter        |");
        System.out.println("3- Display My Server Counter          |");
        System.out.println("4- Quit                               |");
        System.out.println("======================================");
    }

    @Override
    public String chooseCommand() {

        System.out.println("Veuillez choisir la commande :");
        boolean ok = false;
        int choix = 0;
        String command = "Unknown";
        Scanner scanner = new Scanner(System.in);


        while (!ok) {

            String shortcut;
            try {
                choix = scanner.nextInt();
                if (choix > 0 && choix < 4)
                    ok = true;
            } catch (Exception e1) {
                System.out.println("Exception on Input Stream");
                System.exit(-1);
            } finally {
                if (!ok)
                    System.out.println("Il faut choisir une commande valide:");
            }
        }

        switch (choix) {
            case 1:
                command = ClientParameters.UP;
                break;
            case 2:
                command = ClientParameters.DOWN;
                break;
            case 3:
                command = ClientParameters.GET;
                break;
            case 4:
                command = ClientParameters.END;

            default:
                System.err.println("Uknown Command");
                System.exit(-1);
                break;
        }
        return command;
    }
}

