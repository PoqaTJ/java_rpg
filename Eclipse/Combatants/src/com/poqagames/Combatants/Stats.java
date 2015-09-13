package com.poqagames.Combatants;

import java.util.*;

public enum Stats {
	Strength("Strength"),
	Dexterity("Dexterity"),
	Constitution("Constitution"),
	Intelligence("Intelligence"),
	Wisdom("Wisdom"),
	Charisma("Charisma"),
	Test("Test");
	
	private String _name;
	
	private Stats(String name)
	{
		_name = name;
	}
	
	private static Stats[] _baseStats = 
		{
			Stats.Strength,
			Stats.Dexterity,
			Stats.Constitution,
			Stats.Intelligence,
			Stats.Wisdom,
			Stats.Charisma
		};
	
	public static Map<Stats, Integer> rollBaseStats()
	{
		Map<Stats, Integer> ret = new HashMap<Stats, Integer>();
		
		for (Stats s : _baseStats)
		{
			ret.put(s, normalRoll());
		}
		
		return ret;
	}
	
	private static int normalRoll()
	{
		return (CombatUtils.getInstance().getRandom().nextInt(6) + 1 +
				CombatUtils.getInstance().getRandom().nextInt(6) + 1 +
				CombatUtils.getInstance().getRandom().nextInt(6) + 1);
	}
	
	public String toString()
	{
		return _name;
	}
}
