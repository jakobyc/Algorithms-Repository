package main.java.gui.listeners;

import main.java.controllers.AlgorithmController;
import main.java.gui.forms.GUIMain;
import main.java.views.IView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainListener implements ActionListener
{
	private GUIMain gui;
	private AlgorithmController controller;
	
	public MainListener(IView view, AlgorithmController controller)
	{	
		this.gui = view.getGUI();
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		if (e.getSource() == gui.algList)
		{
			controller.changeView();
		}		
		
		if (e.getSource() == gui.userButtons[0])
		{
			controller.random();
		}
		
		if (e.getSource() == gui.userButtons[1])
		{
			controller.setAnswer();
		}
	}
}
