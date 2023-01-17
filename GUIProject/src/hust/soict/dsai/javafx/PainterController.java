package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private RadioButton penFunction;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle;
        if (penFunction.isSelected()) {
            newCircle = new Circle(
                    event.getX(),
                    event.getY(),
                    4,
                    Color.BLACK);
        } else {
            newCircle = new Circle(
                    event.getX(),
                    event.getY(),
                    4,
                    Color.WHITE);
        }
        drawingAreaPane.getChildren().add(newCircle);
    }

}
