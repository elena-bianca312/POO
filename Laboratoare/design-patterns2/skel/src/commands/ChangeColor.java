package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ChangeColor implements DrawCommand{

    private DiagramCanvas diagramCanvas;
    private int index;
    private String color;
    private String oldColor;

    public ChangeColor(DiagramCanvas diagramCanvas, int index, String color) {
        this.diagramCanvas = diagramCanvas;
        this.index = index;
        this.color = color;
        oldColor = diagramCanvas.getComponent(index).getColor();
    }

    public DiagramCanvas getDiagramCanvas() {
        return diagramCanvas;
    }

    public void setDiagramCanvas(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getOldColor() {
        return oldColor;
    }

    public void setOldColor(String oldColor) {
        this.oldColor = oldColor;
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(index).setColor(color);
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(index).setColor(oldColor);
    }

    @Override
    public String toString() {
        return "ChangeColor{" +
                "diagramCanvas=" + diagramCanvas +
                ", color='" + color + '\'' +
                ", index=" + index +
                '}';
    }
}
