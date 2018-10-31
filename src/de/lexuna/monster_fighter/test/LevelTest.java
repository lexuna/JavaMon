package de.lexuna.monster_fighter.test;

public class LevelTest {

	public static void main(String[] args) {
		double constA = 8.7;
		double constB = -40;
		double constC = 111;
		long oldLevel = 0;

		for (int i = 0; i < 100000; i++) {
			long level = Math.round(Math.max(Math.floor(constA * Math.log(i + constC) + constB), 1));
			if (oldLevel != level) {
				System.out.println("Level: " + level + ", Xp: " + i);
			}
			oldLevel = level;
		}
	}
}
