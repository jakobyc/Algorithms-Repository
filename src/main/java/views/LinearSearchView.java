package main.java.views;

import main.java.controllers.AlgorithmController;
import main.java.gui.forms.GUIMain;
import main.java.gui.listeners.MainListener;
import main.java.models.viewmodels.ViewModel;

import java.awt.Color;

import javax.swing.JOptionPane;

public class LinearSearchView implements View
{
	// Controller connected to this view:
	private AlgorithmController controller;
	
	// View model returned from controller:
	private ViewModel.Algorithm.Search model;
	
	private GUIMain gui;
	private MainListener listener;
	
	public LinearSearchView(AlgorithmController controller, ViewModel.Algorithm.Search model, GUIMain gui)
	{
		this.controller = controller;
		this.model = model;
		this.gui = gui;
		
		hideComponents();
		
		// Hook listeners to view:
		listener = new MainListener(gui, this);
		// Clean-up existing listeners before adding new ones:
		listener.removeActionListeners();
		listener.addActionListeners();
	}
	
	public void calculate()
	{
		model = this.controller.calculate(model);
		updateGUI();
		showData();
	}
	
	public void hideComponents()
	{
		gui.userButtons[2].setVisible(false);
	}
	
	public void setAnswer()
	{
		String answer = JOptionPane.showInputDialog(gui.getFrame(), "Enter an answer for the algorithm to find.", "<Whole number between 0 and 100>", JOptionPane.INFORMATION_MESSAGE);
		model = this.controller.setAnswer(model, answer, gui.rangeButtons.length - 1);
		if (model.Error == null)
		{
			updateGUI();
			showData();
		}
		else
		{
			JOptionPane.showMessageDialog(gui.getFrame(), model.Error, "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void updateGUI()
	{
		gui.resetRangeButtons();
		
		int castAnswer = (int) model.Answer;
;		gui.rangeButtons[castAnswer].setSelected(false);
		gui.rangeButtons[castAnswer].setBackground(Color.CYAN);
		
		if (gui.guessCheck.isSelected())
		{
			for (int i = 0; i < castAnswer; i++)
			{
				gui.rangeButtons[i].setSelected(false);
				gui.rangeButtons[i].setBackground(Color.ORANGE);
			}
		}
	}
	
	private void showData()
	{	
		String output = String.format("Answer is: %1s \nAttempts taken: %2s", model.Answer, model.Attempts);
		gui.myTextArea.setText(output);
		System.out.println(output);
	}
}
