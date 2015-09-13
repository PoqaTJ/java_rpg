package GUI;

import com.poqagames.Combatants.*;

import javax.swing.*;

import java.awt.*;

public class PartyPanel extends JPanel
{
	public PartyPanel()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY));
	}
}
