package fr.cnam.nfp121.tp9.line.linecommands.simplelinecomm;

import fr.cnam.nfp121.tp9.line.specification.Line;

public class DeleteAllCommand extends LineComm {

    public DeleteAllCommand(Line a_Line) {
        super(a_Line);
    }

    public void executer() {

        while (LineComm.line.getLength() > 0) {
            LineComm.line.delete();
        }
        LineComm.line.getPrinter().print();
    }

    @Override
    public final boolean isExecutable() {
        return LineComm.line.getLength() > 0;
    }
}
