package hust.soict.dsai.javafx;

import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.Objects;

public class Painter extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(
				Objects.requireNonNull(getClass().getResource("Painter.fxml")));
		Scene scene = new Scene(root);
		stage.setTitle("Painter");
		stage.setScene(scene);
		stage.show();
	}

}