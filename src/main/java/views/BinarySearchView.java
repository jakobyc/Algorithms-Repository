package main.java.views;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.java.algorithms.IAlgorithm;
import main.java.algorithms.search.BinarySearch;
import main.java.algorithms.search.params.SearchParams;
import main.java.algorithms.search.results.SearchResults;
import main.java.gui.forms.SearchForm;
import main.java.models.viewmodels.ViewModel;

public class BinarySearchView implements IView
{
	private ViewModel.Algorithm.Search viewModel;
	
	private SearchForm gui;
	
	public BinarySearchView()
	{
		this.gui = new SearchForm();
		gui.Initialize();
		gui.setTitle("Binary Search");
		gui.setSelectedAlgorithm("Binary Search");
		
		hideComponents();
	}
	
	public SearchForm getGUI() 
	{
		return this.gui;
	}
	
	public IAlgorithm<SearchResults, SearchParams> getAlgorithm(double answer)
	{
		return null;
		//return new BinarySearch(answer);
	}

	public String getAnswer() 
	{
		String answer = JOptionPane.showInputDialog(gui.getFrame(), "Enter an answer for the algorithm to find.", "<Whole number between 0 and 100>", JOptionPane.INFORMATION_MESSAGE);
		return answer;
	}

	public void displayError() 
	{
		JOptionPane.showMessageDialog(gui.getFrame(), viewModel.Error, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void hideComponents() 
	{
		gui.userButtons[2].setVisible(false);
	}
	
	public void updateGUI() 
	{
		gui.resetRangeButtons();
		
		int castAnswer = (int) viewModel.Answer;
		gui.rangeButtons[castAnswer].setSelected(false);
		gui.rangeButtons[castAnswer].setBackground(Color.CYAN);
		
		if (gui.guessCheck.isSelected())
		{
			for (int i = 0; i < viewModel.GuessData.size(); i++)
			{
				gui.rangeButtons[viewModel.GuessData.get(i)].setSelected(false);
				gui.rangeButtons[viewModel.GuessData.get(i)].setBackground(Color.ORANGE);
			}
		}
	}

	public void update(Object o) 
	{
		this.viewModel = (ViewModel.Algorithm.Search)o;
		if (viewModel.Error == null)
		{
			updateGUI();
			showData();
		}
	}

	public void addActionListener(ActionListener listener) 
	{
		for (JButton button : gui.userButtons)
		{
			button.addActionListener(listener);
		}
		
		gui.algList.addActionListener(listener);
	}

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

	private void showData()
	{
		String output = String.format("Answer is: %1s \nAttempts taken: %2s", viewModel.Answer, viewModel.Attempts);
		gui.myTextArea.setText(output);
		System.out.println(output);
	}
}
