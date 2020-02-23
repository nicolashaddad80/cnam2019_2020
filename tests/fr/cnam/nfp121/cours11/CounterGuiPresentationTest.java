package fr.cnam.nfp121.cours11;

import fr.cnam.cour11.DebugOnOFF;
import fr.cnam.nfp121.cours11.model.Counter;
import fr.cnam.nfp121.cours11.model.CounterImp1;
import fr.cnam.nfp121.cours11.presentation.CounterGuiPresentation;

import javax.swing.*;

public class CounterGuiPresentationTest {

    public static void main(String[] args) {
        Counter myModel1 = new CounterImp1();
        SwingUtilities.invokeLater(() -> new CounterGuiPresentation(myModel1).start());
        /*Launching Additional Views of same Model counter for debug purpose if DEBUG_ON seated to true*/
        if (DebugOnOFF.DEBUG_ON) for (int i = 0; i < DebugOnOFF.NB_DEBUG_PARALLEL_ADDITIONAL_VIEWS; i++)
            SwingUtilities.invokeLater(() -> new CounterGuiPresentation(myModel1).start());
    }
}
