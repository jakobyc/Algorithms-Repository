package main.java.views;

import java.awt.event.ActionListener;

import main.java.algorithms.IAlgorithm;
import main.java.gui.forms.SearchForm;;

public interface IView 
{
	SearchForm getGUI();
	IAlgorithm getAlgorithm(double answer);
	
	String getAnswer();

	void displayError();
	void hideComponents();
	void updateGUI();
	void update(Object o);
	// Hook view to controller through an ActionListener:
	void addActionListener(ActionListener listener);
	// Remove ActionListeners on View change:
	void removeActionListeners();
}
