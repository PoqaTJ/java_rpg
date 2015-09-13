package com.poqagames.Combatants;

import com.poqagames.Combatants.Actions.*;

public class BattleTurn 
{
	public Party party;
	public Combatant combatant;
	public Action action;
	public Combatant[] target;

	public BattleTurn(Party p, Combatant c)
	{
		combatant = c;
		party = p;
	}
}