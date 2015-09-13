package com.poqagames.Combatants;
import static org.junit.Assert.*;

import org.junit.Test;


public class CombatantTest {
	@Test
	public void test() 		throws StatNotFoundException 
	{
		Combatant c = new Combatant();
		assertNotNull(c.getStat(Stats.Strength));
		assertNotNull(c.getStat(Stats.Dexterity));
		assertNotNull(c.getStat(Stats.Constitution));
		assertNotNull(c.getStat(Stats.Intelligence));
		assertNotNull(c.getStat(Stats.Wisdom));
		assertNotNull(c.getStat(Stats.Charisma));
	}
}
