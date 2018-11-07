package net.snortum.javafx.multiscene.view;

import javafx.stage.Stage;

import net.snortum.javafx.multiscene.controller.ViewThreeController;

/**
 scene3 

 */
@SuppressWarnings("restriction")
public class ViewThree extends ViewBase {

	/** Must inject a stage */
	public ViewThree(Stage stage) {
		super(stage, "This is scene 3", e -> new ViewThreeController(stage).handleMousePress(e));
	}

}
