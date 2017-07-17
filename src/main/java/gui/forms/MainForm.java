package main.java.gui.forms;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class MainForm 
{
	// Same frame and main panel are re-used for every view:
	protected static JFrame myFrame = new JFrame();
	protected static JPanel mainPanel = new JPanel(new GridBagLayout());
	
	public MainForm()
	{
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(1500,  450);
		// Null parameter = center screen:
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
		resetGUI();
	}
	
	// Invoked when changing views to reset the main panel for the next view:
	public void resetGUI()
	{
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();
	}
}
