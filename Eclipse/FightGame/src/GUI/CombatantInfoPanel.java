package GUI;

import com.poqagames.Combatants.*;

import javax.swing.*;

import java.awt.*;


public class CombatantInfoPanel extends JPanel
{
	private Combatant _combatant;
	
	public CombatantInfoPanel(Combatant c)
	{
		super();
		this.setSize(500,  300);
		_combatant = c;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY));
		JLabel name = new JLabel(_combatant.getName());
		this.add(name);
		this.add(createStatsLabel());
	}
	
	public JLabel createStatsLabel()
	{
		StringBuilder s = new StringBuilder();
		
		for (Stats stat : new Stats[] {Stats.Strength, Stats.Dexterity, Stats.Constitution, Stats.Intelligence, Stats.Wisdom, Stats.Charisma})
		{
			s.append(stat.name() + ": ");
			s.append(Integer.toString(_combatant.getStat(stat)));
			s.append(" ");
		}
		
		return new JLabel(s.toString());
	}
}
