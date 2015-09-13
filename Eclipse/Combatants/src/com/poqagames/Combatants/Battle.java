package com.poqagames.Combatants;

import java.util.*;

// A battle pits two groups of Combatants against each other.
public class Battle 
{
	Party _leftSide;
	Party _rightSide;
	String _error = "";
	Combatant[] _turnList;
	int _turnIndex = 0;
	
	public Battle(Party left, Party right)
	{
		_leftSide = left;
		_rightSide = right;
		rollInitiative();
	}
	
	public String getError()
	{
		return _error;
	}
	
	public BattleTurn getNextTurn()
	{		
		_turnIndex = ++_turnIndex % _turnList.length;
		
		Combatant c = _turnList[_turnIndex];
		Party p = getParty(c);
		
		return new BattleTurn(p, c);
	}
	
	private Party getParty(Combatant c)
	{
		if (Arrays.asList(_leftSide.getMembers()).contains(c))
			return _leftSide;
		else if (Arrays.asList(_rightSide.getMembers()).contains(c))
			return _rightSide;
		return null;
	}
	
	private void rollInitiative()
	{
		HashMap<Combatant, Integer> order = new HashMap<Combatant, Integer>();
		ArrayList<Combatant> turns = new ArrayList<Combatant>();
		
		for (Combatant c : _leftSide.getMembers())
		{
			order.put(c, rollInitiative(c));
		}
		for (Combatant c : _rightSide.getMembers())
		{
			order.put(c, rollInitiative(c));
		}
		
		while (order.size() > 0)
		{
			ArrayList<Combatant> combatantsThisTurn = new ArrayList<Combatant>();
			int currentInitiative = 0;
			
			for (Combatant c:order.keySet())
			{
				int initiative = order.get(c);
				
				if (order.get(c) > currentInitiative)
				{
					currentInitiative = order.get(c);
					combatantsThisTurn = new ArrayList<Combatant>();
					combatantsThisTurn.add(c);
				}
				else if (currentInitiative == initiative)
				{
					combatantsThisTurn.add(c);
				}
			}
			
			while (combatantsThisTurn.size() > 0)
			{
				int i = CombatUtils.getInstance().getRandom().nextInt(combatantsThisTurn.size());
				Combatant c = combatantsThisTurn.get(i);
				turns.add(c);
				combatantsThisTurn.remove(i);
				order.remove(c);
			}
			
			_turnIndex = 0;
		}
		_turnList = new Combatant[turns.size()];
		turns.toArray(_turnList);
	}
	
	private int rollInitiative(Combatant c)
	{
		return c.getInitiative() + CombatUtils.getInstance().getRandom().nextInt(20);
	}
	
	public enum State
	{
		Active,
		Finished,
		Error
	}
}
