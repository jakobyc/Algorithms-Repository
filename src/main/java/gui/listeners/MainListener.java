package main.java.gui.listeners;

import main.java.gui.forms.GUIMain;
import main.java.views.View;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class MainListener implements ActionListener
{
	private GUIMain gui;
	private View view;
	
	public MainListener(GUIMain gui, View view)
	{	
		this.gui = gui;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == gui.userButtons[0])
		{
			view.calculate();
		}
		
		if (e.getSource() == gui.userButtons[1])
		{
			view.setAnswer();
		}
	}

	//Add Action Listeners to every user button ("Reset", "Set Answer", etc.):
	public void addActionListeners()
	{		
		for (JButton button: gui.userButtons)
		{
			button.addActionListener(this);
		}
	}
	
	// Removes all ActionListeners from the user buttons ("Reset", "Set Answer", etc.):
	public void removeActionListeners()
	{
		for (JButton button : gui.userButtons)
		{
			for (ActionListener act : button.getActionListeners())
			{
				button.removeActionListener(act);
			}
		}
	}
}
