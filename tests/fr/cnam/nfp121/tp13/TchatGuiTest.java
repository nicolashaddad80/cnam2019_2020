package fr.cnam.nfp121.tp13;


import fr.cnam.nfp121.tp13.application.TchatGui;
import fr.cnam.nfp121.tp13.model.ObservableSalon;

import javax.swing.*;

public class TchatGuiTest {

    public static void main(String[] args) {
        ObservableSalon myModel1 = new ObservableSalon();
        SwingUtilities.invokeLater(() -> new TchatGui(myModel1).start());
        /*Launching Additional Views of same Model counter for debug purpose if DEBUG_ON seated to true*/
        if (fr.cnam.cour11.DebugOnOFF.DEBUG_ON) for (int i = 0; i < fr.cnam.cour11.DebugOnOFF.NB_DEBUG_PARALLEL_ADDITIONAL_VIEWS; i++)
            SwingUtilities.invokeLater(() -> new TchatGui(myModel1).start());
    }
}
