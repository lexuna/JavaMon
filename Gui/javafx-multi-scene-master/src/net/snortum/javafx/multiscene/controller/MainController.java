package net.snortum.javafx.multiscene.controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import de.lexuna.monster_fighter.controller.Main;
import net.snortum.javafx.multiscene.model.SceneName;

/**
 * Pressing a button displays the different scenes.
 * 
 */
public class MainController {

	private Stage stage;

	/** Inject the stage from {@link Main} */
	public MainController(Stage stage) {
		this.stage = stage;
	}

	/** Display the first scene */
	public void handleOnPressButton1(MouseEvent event) {
		Scene scene = net.snortum.javafx.multiscene.Main.getScenes().get(SceneName.SCENE1);
		
		Label label1 = new Label(Main.getPlayer().getName() + ", " + Main.getPlayer().getHealth());
		((BorderPane) scene.getRoot()).getChildren().add(label1);
		stage.setScene(scene);
	}

	/** Display the second scene */
	public void handleOnPressButton2(MouseEvent event) {
		stage.setScene(net.snortum.javafx.multiscene.Main.getScenes().get(SceneName.SCENE2));
	}

	/** Display the third scene */
	public void handleOnPressButton3(MouseEvent event) {
		stage.setScene(net.snortum.javafx.multiscene.Main.getScenes().get(SceneName.SCENE3));
	}

	// TEST FUNC
	public void handleOnPressButton1TEST(MouseEvent event) {
		stage.setScene(net.snortum.javafx.multiscene.Main.getScenes().get(SceneName.SCENE1));
	}

}
