package com.poqagames.Combatants;
import java.util.*;

// Anything able to fight in a Battle is a combatant.
public class Combatant {
	
	protected Map<Stats, Integer> _stats;
	protected int _currentHP;
	protected int _maxHP;
	protected int _level;
	protected int _initiative;
	protected String _class = "Novice";
	protected String _name = "Test";
	
	public Combatant()
	{
		generateStats();
		_level = 1;
		_maxHP = CONSTANTS.BASE_HP;
		_currentHP = _maxHP;
		_initiative = CONSTANTS.BASE_INITIATIVE;
		_name = CombatUtils.getInstance().getRandomName();
	}
	
	private void generateStats()
	{
		_stats = Stats.rollBaseStats();
	}
	
	public int getStat(Stats s)
	{
		return _stats.get(s);
	}
	
	public int getHP()
	{
		return _currentHP;
	}
	
	public int getMaxHP()
	{
		return _maxHP;
	}
	
	public int getLevel()
	{
		return _level;
	}
	
	public int getInitiative()
	{
		return _initiative;
	}
	
	public void takeDamage(int damage)
	{
		_currentHP -= damage;
		
		if (_currentHP <= 0)
			onHPReachedZero();
	}
	
	public String getClassType()
	{
		return _class;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public boolean canAct()
	{
		return isAlive();
	}
	
	public boolean isAlive()
	{
		return _currentHP >= 0;
	}
	
	protected void onHPReachedZero()
	{
		
	}
}
