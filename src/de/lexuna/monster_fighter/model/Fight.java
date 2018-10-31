package de.lexuna.monster_fighter.model;

import java.util.logging.Logger;

import de.lexuna.monster_fighter.controller.Main;
import javafx.stage.Stage;

/**
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:36
 */
public class Fight {

	private static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private Stage stage;
	private Player player;
	private Enemy enemy;

	/**
	 * 
	 * @param level
	 *            default null
	 */
	public Fight(Stage level) {
		this.player = Main.getPlayer();
		this.enemy = new Enemy();
	}

	/**
	 * get the player attack dmg and count it on the enemy's health
	 * 
	 * @param skill
	 *            default null
	 * @return playerAttackDmg for GUI
	 * @throws NoSkillImplemented
	 *             if skill != null
	 * @throws EnemyIsDead
	 * @throws LevelUp
	 */
	public int playerAttack(Skill skill) throws NoSkillImplemented, EnemyIsDead, LevelUp {
		int playerAttackDmg = player.attack(skill);
		if (enemy.takeDmg(playerAttackDmg)) {
			throw new EnemyIsDead("the player killed the enemy");
		}
		return playerAttackDmg;
	}

	/**
	 * 
	 * get the enemy attack dmg and count it on the player's health
	 * 
	 * @param skill
	 *            default null
	 * @return enemyAttackDmg for GUI
	 * @throws NoSkillImplemented
	 *             if skill != null
	 * @throws PlayerIsDead
	 */
	public int enemyAttack(Skill skill) throws NoSkillImplemented, PlayerIsDead {
		int enemyAttackDmg = enemy.attack(skill);
		if (player.takeDmg(enemyAttackDmg)) {
			throw new PlayerIsDead("the enemy killed the player");
		}
		return enemyAttackDmg;
	}

	public Stage getStage() {
		return stage;
	}

	public Enemy getEnemy() {
		return enemy;
	}

}