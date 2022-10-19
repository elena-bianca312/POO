package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class DrawRectangle implements DrawCommand{

    private DiagramCanvas diagramCanvas;
    private DiagramComponent diagramComponent = new DiagramComponent();

    public DrawRectangle(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    public DiagramCanvas getDiagramCanvas() {
        return diagramCanvas;
    }

    public void setDiagramCanvas(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    public DiagramComponent getDiagramComponent() {
        return diagramComponent;
    }

    public void setDiagramComponent(DiagramComponent diagramComponent) {
        this.diagramComponent = diagramComponent;
    }

    @Override
    public void execute() {
        diagramCanvas.addComponent(diagramComponent);
    }

    @Override
    public void undo() {
        diagramCanvas.removeComponent(diagramComponent);
    }

    @Override
    public String toString() {
        return "DrawRectangle{" +
                "diagramCanvas=" + diagramCanvas +
                '}';
    }
}
