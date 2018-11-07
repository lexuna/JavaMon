package net.snortum.javafx.multiscene.view;

import javafx.stage.Stage;

import net.snortum.javafx.multiscene.controller.ViewTwoController;

/**
 * Creates and returns the scene for the second view.
 * 

 */
public class ViewTwo extends ViewBase {

	/** Must inject a stage */
	public ViewTwo(Stage stage) {
		super(stage, "This is scene 2", e -> new ViewTwoController(stage).handleMousePress(e));
	}

}
