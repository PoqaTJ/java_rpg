import java.util.*;
import com.poqagames.Combatants.*;
import java.lang.StringBuilder;

public class Test {
	public static void main(String[] args) 
	{
		ArrayList<Combatant> combatants = new ArrayList<Combatant>();
		
		for (int i = 0; i < 100; i++)
		{
			combatants.add(new Combatant());
			printStats(combatants.get(i));
		}
	}
	
	private static void printStats(Combatant c)
	{
		StringBuilder s = new StringBuilder();
		
		try
		{
			s.append(c.getStat(Stats.Strength));
			s.append(", ");
			s.append(c.getStat(Stats.Dexterity));
			s.append(", ");
			s.append(c.getStat(Stats.Constitution));
			s.append(", ");
			s.append(c.getStat(Stats.Intelligence));
			s.append(", ");
			s.append(c.getStat(Stats.Wisdom));
			s.append(", ");
			s.append(c.getStat(Stats.Charisma));
			s.append(", ");
			
			System.out.println(s.toString());
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
