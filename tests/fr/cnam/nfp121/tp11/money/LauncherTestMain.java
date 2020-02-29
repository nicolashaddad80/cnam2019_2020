package fr.cnam.nfp121.tp11.money;


import fr.cnam.nfp121.tp11.Launcher;
import fr.cnam.nfp121.tp11.LauncherImpl;

public class LauncherTestMain {

    public static void main(String[] args) {
        Launcher mytestLauncher = new LauncherImpl("fr.cnam.nfp121.tp11.money." + args[0]);
        mytestLauncher.startTests();
        System.out.println(mytestLauncher.getStatistics());
    }
}
