package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class Resize implements DrawCommand{

    private DiagramCanvas diagramCanvas;
    private int index;
    private int percentage;
    private int oldWeight;
    private int oldHeight;

    public Resize(DiagramCanvas diagramCanvas, int index, int percentage) {
        this.diagramCanvas = diagramCanvas;
        this.index = index;
        this.percentage = percentage;
        oldWeight = diagramCanvas.getComponent(index).getWeight();
        oldHeight = diagramCanvas.getComponent(index).getHeight();
    }

    public DiagramCanvas getDiagramCanvas() {
        return diagramCanvas;
    }

    public void setDiagramCanvas(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getOldWeight() {
        return oldWeight;
    }

    public void setOldWeight(int oldWeight) {
        this.oldWeight = oldWeight;
    }

    public int getOldHeight() {
        return oldHeight;
    }

    public void setOldHeight(int oldHeight) {
        this.oldHeight = oldHeight;
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(index).setWeight(oldWeight * percentage / 100);
        diagramCanvas.getComponent(index).setHeight(oldHeight * percentage / 100);
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(index).setWeight(oldWeight);
        diagramCanvas.getComponent(index).setHeight(oldHeight);
    }

    @Override
    public String toString() {
        return "Resize{" +
                "diagramCanvas=" + diagramCanvas +
                ", percentage=" + percentage +
                ", index=" + index +
                '}';
    }
}
