package com.poqagames.Combatants;

public enum Gender {
	Male,
	Female;
	
	public static Gender getRandomGender()
	{
		if (CombatUtils.getInstance().getRandom().nextInt(2) == 0)
			return Male;
		else
			return Female;
	}
}
