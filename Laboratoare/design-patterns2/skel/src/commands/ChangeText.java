package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ChangeText implements DrawCommand{

    private DiagramCanvas diagramCanvas;
    private int index;
    private String text;
    private String oldText;

    public ChangeText(DiagramCanvas diagramCanvas, int index, String text) {
        this.diagramCanvas = diagramCanvas;
        this.index = index;
        this.text = text;
        oldText = diagramCanvas.getComponent(index).getText();
    }

    public DiagramCanvas getDiagramCanvas() {
        return diagramCanvas;
    }

    public void setDiagramCanvas(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getOldText() {
        return oldText;
    }

    public void setOldText(String oldText) {
        this.oldText = oldText;
    }

    @Override
    public void execute() {
        diagramCanvas.getComponent(index).setText(text);
    }

    @Override
    public void undo() {
        diagramCanvas.getComponent(index).setText(oldText);
    }

    @Override
    public String toString() {
        return "ChangeText{" +
                "diagramCanvas=" + diagramCanvas +
                ", text='" + text + '\'' +
                ", index=" + index +
                '}';
    }
}
