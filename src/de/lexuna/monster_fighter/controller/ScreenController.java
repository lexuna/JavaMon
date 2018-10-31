package de.lexuna.monster_fighter.controller;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:37
 */
public class ScreenController {

	private static Map<String, Scene> screenMap = new HashMap<>();
	private static Scene activeScene;

	public ScreenController(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param activeScene
	 */
	public static void setActiveScene(Scene activeScene){

	}

	/**
	 * 
	 * @param name
	 * @param pane
	 */
	public static void addScreen(String name, Pane pane){

	}

	/**
	 * 
	 * @param name
	 */
	public static void removeScreen(String name){

	}

	/**
	 * 
	 * @param name
	 */
	public static void activate(String name){

	}

}