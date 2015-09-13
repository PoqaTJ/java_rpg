package GUI;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import com.poqagames.Combatants.*;

public class testGui
{
	static JFrame frame;
	static JPanel panel;
	//static CombatantInfoPanel combatantInfo;
	static Party playerParty; 

	public static void main(String[] args) 
	{
		frame = new JFrame("Test");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createCharacters();
		
		frame.setResizable(false);
		frame.getContentPane().validate();
		frame.pack();

		frame.repaint();
		frame.setVisible(true);
	}
	
	private static void onResetClicked()
	{
		frame.remove(panel);
		//frame.remove(combatantInfo);
		createCharacters();
	}
	
	public static void refresh()
	{
		frame.getContentPane().validate();
		frame.pack();
		frame.repaint();
	}
	
	private static void createCharacters()
	{
		CombatUtils.getInstance().clearUsedNames();
		
		playerParty = new Party(4);
		playerParty.addMember(new Combatant());
		playerParty.addMember(new Combatant());
		playerParty.addMember(new Combatant());
		playerParty.addMember(new Combatant());
		
		frame.getContentPane().invalidate();
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
//		JButton reset = new JButton("Reset");
//		reset.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e)
//			{
//				onResetClicked();
//			}
//		}
//				);
//		panel.add(reset);

		panel.setPreferredSize(new Dimension(500, 500));
		
		Combatant[] members = playerParty.getMembers();
		
		for (int i = 0; i <= members.length - 1; i++)
		{
			//panel.add(new CombatantPanel(members[i]), BorderLayout.WEST);
		}
		
		//PartyPanel pp = new PartyPanel();
		panel.add(new PartyPanel(), BorderLayout.WEST);

		frame.getContentPane().add(panel);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem resetAction = new JMenuItem("Reset");
		fileMenu.add(resetAction);
		resetAction.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt)
			{
				onResetClicked();
			}
		});
		panel.add(menuBar, BorderLayout.PAGE_START);
		
		//changeInfoPanel(members[0]);
		
		frame.getContentPane().validate();
		frame.pack();
		frame.repaint();
	}
	
//	public static void changeInfoPanel(Combatant combatant)
//	{
//		if (combatantInfo != null)
//			frame.remove(combatantInfo);
//		frame.getContentPane().invalidate();
//		combatantInfo = new CombatantInfoPanel(combatant);
//		frame.getContentPane().add(combatantInfo, BorderLayout.SOUTH);
//	}
}
