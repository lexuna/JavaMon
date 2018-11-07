package net.snortum.javafx.multiscene.view;

import javafx.stage.Stage;

import net.snortum.javafx.multiscene.controller.ViewOneController;

/**
 * Creates and returns the scene for the first view.
 * 
 */
@SuppressWarnings("restriction")
public class ViewOne extends ViewBase {

	/** Must inject a stage */
	public ViewOne(Stage stage) {
		super(stage, "This is scene 1", e -> new ViewOneController(stage).handleMousePress(e));
		//Kann ich hier in der View elemente hinzufügen? 
		
	}

}
