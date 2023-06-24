package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PainterController {

    public ToggleGroup choose;
    private boolean isDrawing = true;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isDrawing) {
            int radius = 5;
            double x = event.getX();
            double y = event.getY();

            // check if the circle is out of the drawing area
            if (x - radius < 0 || x + radius > drawingAreaPane.getWidth() || 
                y - radius < 0 || y + radius > drawingAreaPane.getHeight()) {
                return;
            }
            javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(x, y, radius);
            circle.setFill(Color.BLACK);
            drawingAreaPane.getChildren().add(circle);
        } else {
            drawingAreaPane.getChildren().removeIf(node -> node instanceof javafx.scene.shape.Circle && node.contains(event.getX(), event.getY()));
        }
    }

    @FXML
    void eraser() {
        isDrawing = false;
    }

    @FXML
    void pen() {
        isDrawing = true;
    }

}
