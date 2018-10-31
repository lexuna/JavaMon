package de.lexuna.monster_fighter.test;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import de.lexuna.monster_fighter.controller.Main;
import de.lexuna.monster_fighter.model.EnemyIsDead;
import de.lexuna.monster_fighter.model.Fight;
import de.lexuna.monster_fighter.model.LevelUp;
import de.lexuna.monster_fighter.model.NoSkillImplemented;
import de.lexuna.monster_fighter.model.Player;
import de.lexuna.monster_fighter.model.PlayerIsDead;

public class FightTest {

	private static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Field player = Main.class.getDeclaredField("character");
		player.setAccessible(true);
		player.set(Player.class, new Player(0, "Lexuna"));
		int fightCount = 0;
		while (true) {
			fightCount++;
			Fight fight = new Fight(null);
			LOG.info("New fight. Player Level: " + Main.getPlayer().getLevel() + "; Enemy Health:"
					+ fight.getEnemy().getHealth() + ", Xp:" + fight.getEnemy().getXp() + ", Dmg: "
					+ fight.getEnemy().getMaxDmg());
			boolean isFight = true;
			while (isFight) {
				try {
					fight.enemyAttack(null);
					fight.playerAttack(null);
				} catch (NoSkillImplemented e) {
					LOG.info(e.getMessage());
					isFight = false;
				} catch (PlayerIsDead e) {
					LOG.info("Player is dead (TEST)" + Main.getPlayer().getLevel() + ", " + fightCount);
					return;
				} catch (EnemyIsDead e) {
					 LOG.info("Enemy defeated");
					isFight = false;
				} catch (LevelUp e) {
					 LOG.info("Player leveld up: " + Main.getPlayer().getLevel());
					isFight = false;
				}
			}
		}
	}
}
