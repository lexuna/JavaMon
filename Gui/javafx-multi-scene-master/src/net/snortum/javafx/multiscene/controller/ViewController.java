package net.snortum.javafx.multiscene.controller;

import de.lexuna.monster_fighter.controller.Main;
import de.lexuna.monster_fighter.model.Player;
import javafx.stage.Stage;

public class ViewController {

	public static void chooseMonster(int x) {
		Main.setPlayer(new Player(x, "Default"));

	}

}
