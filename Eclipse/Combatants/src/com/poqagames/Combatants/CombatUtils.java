package com.poqagames.Combatants;

import com.poqagames.Combatants.Classes.*;

import java.util.*;

public class CombatUtils {
	
	static CombatUtils _combatUtils;
	Random _random;
	String[] names =
		{
			"Tanner",
			"Lilly",
			"Yoshi",
			"Yulia",
			"Victor",
			"Derrick",
			"Tina",
			"Liliana",
		};
	
	ArrayList<String> _usedNames;
	
	public void clearUsedNames()
	{
		_usedNames = new ArrayList<String>();
	}
	
	public CombatUtils()
	{
		_random = new Random();
		clearUsedNames();
	}
	
	public static CombatUtils getInstance()
	{
		if (_combatUtils == null)
			_combatUtils = new CombatUtils();
		return _combatUtils;
	}
	
	public Random getRandom()
	{
		return _random;
	}

	public String getRandomName() 
	{
		String name = "";
		int counter = 1000;
		
		while ((name == "" ||
				_usedNames.contains(name)) &&
				counter-- > 0)
		{
			name = names[getRandom().nextInt(names.length)];
		}
		
		_usedNames.add(name);
		
		return name;
	}
}
