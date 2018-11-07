package net.snortum.javafx.multiscene.controller;

import javafx.event.Event;
import javafx.stage.Stage;

import net.snortum.javafx.multiscene.Main;
import net.snortum.javafx.multiscene.model.SceneName;
import net.snortum.javafx.multiscene.view.ViewTwo;

/**
 * Controller for {@link ViewTwo}.

 */
public class ViewTwoController {
	
	private Stage stage;
	
	/** Must inject a stage */
	public ViewTwoController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}
		
		this.stage = stage;
	}
	
	/** Display main scene when the "back" button is clicked */
	public void handleMousePress(Event event) {
		stage.setScene(Main.getScenes().get(SceneName.MAIN));
	}
}
