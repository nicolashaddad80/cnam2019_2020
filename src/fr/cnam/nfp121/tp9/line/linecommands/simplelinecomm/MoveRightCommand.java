package fr.cnam.nfp121.tp9.line.linecommands.simplelinecomm;

import fr.cnam.nfp121.tp9.line.specification.Line;

public class MoveRightCommand extends LineComm {

    public MoveRightCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {
        LineComm.line.moveRight();
        LineComm.line.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return LineComm.line.getCursorPos() < LineComm.line.getLength();
    }
}