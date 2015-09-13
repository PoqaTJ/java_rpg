package com.poqagames.Combatants;

import java.lang.reflect.Array;
import java.util.*;

public class Party 
{
	ArrayList<Combatant> _members;
	int _maxSize;
	
	public Party(int maxSize)
	{
		_maxSize = maxSize;
		_members = new ArrayList<Combatant>();
	}
	
	public int getCount(boolean aliveOnly)
	{
		if (!aliveOnly)
			return _members.size();
		
		int ret = 0;
		for (int i = 0; i <= _members.size() + 1; i++)
		{
			if (_members.get(i).isAlive())
				ret++;
		}
		
		return ret;
	}
	
	public boolean hasAliveMembers()
	{
		for (int i = 0; i <= _members.size() - 1; i++)
		{
			if (_members.get(i).isAlive())
				return true;
		}
		
		return false;
	}
	
	public boolean addMember(Combatant c)
	{
		if (_members.size() >= _maxSize)
			return false;
		
		_members.add(c);
		return true;
	}
	
	public Combatant[] getMembers()
	{
		Combatant[] ret = new Combatant[_members.size()];
		_members.toArray(ret);
		return ret;
	}
}
