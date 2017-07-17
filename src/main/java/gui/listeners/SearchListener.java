package main.java.gui.listeners;

import main.java.controllers.SearchController;
import main.java.gui.forms.SearchForm;
import main.java.views.IView;
import main.java.views.ViewFactory.ViewType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchListener implements ActionListener
{
	private SearchForm gui;
	private SearchController controller;
	
	public SearchListener(IView view, SearchController controller)
	{	
		this.gui = view.getGUI();
		
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		if (e.getSource() == gui.algList)
		{
			ViewType type;
			
			switch(gui.algList.getSelectedItem().toString())
			{
				case("Linear Search"):
					type = ViewType.LINEAR_SEARCH;
					break;
				case("Binary Search"):
					type = ViewType.BINARY_SEARCH;
					break;
				default:
					type = ViewType.LINEAR_SEARCH;
					break;
			}
			
			controller.changeView(type);
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
