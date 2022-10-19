package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ConnectComponents implements DrawCommand{

    private DiagramCanvas diagramCanvas;
    private int index1;
    private int index2;

    public ConnectComponents(DiagramCanvas diagramCanvas, int index1, int index2) {
        this.diagramCanvas = diagramCanvas;
        this.index1 = index1;
        this.index2 = index2;
    }

    public DiagramCanvas getDiagramCanvas() {
        return diagramCanvas;
    }

    public void setDiagramCanvas(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    public int getIndex1() {
        return index1;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(index1).connectTo(String.valueOf(index2));
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(index1).removeConnection(String.valueOf(index2));
    }

    @Override
    public String toString() {
        return "ConnectComponents{" +
                "diagramCanvas=" + diagramCanvas +
                ", index1=" + index1 +
                ", index2=" + index2 +
                '}';
    }
}
