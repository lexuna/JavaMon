package net.snortum.javafx.multiscene.view;

import javafx.scene.Scene;

/** Guarantees that the method {@link #getScene()} is present */ 
@SuppressWarnings("restriction")
public interface ViewMaker {
	
	/**
	 * Build and return a scene for this view
	 * 
	 * @return the Scene for this view
	 */
	Scene getScene();
}
