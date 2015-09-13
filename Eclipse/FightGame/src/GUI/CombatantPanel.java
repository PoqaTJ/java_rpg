package GUI;

import com.poqagames.Combatants.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CombatantPanel  extends JPanel
{
	private Combatant _combatant;
	
	public CombatantPanel(Combatant c)
	{
		super();
		_combatant = c;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY));
		JLabel name = new JLabel(_combatant.getName());
		this.add(name);
		JLabel description = new JLabel(createDescription());
		this.add(description);
		JLabel hpbar = new JLabel("HP: 10/10");
		this.add(hpbar);
		JLabel epbar = new JLabel("EP: 10/10");
		this.add(epbar);
		this.addMouseListener(new MouseAdapter()
		{
	          public void mousePressed(MouseEvent me) 
	          { 
	              //testGui.changeInfoPanel(_combatant);
	              testGui.refresh();
	          } 
		});
		
	}
	
	private String createDescription()
	{
		StringBuilder s = new StringBuilder();
		s.append("Level ");
		s.append(Integer.toString(_combatant.getLevel()));
		s.append(" ");
		s.append(_combatant.getClassType());
		return s.toString();
	}
}
