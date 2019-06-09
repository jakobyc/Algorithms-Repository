package main.java.views.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import main.java.algorithms.search.results.SearchResults;
import main.java.presenters.SearchPresenter;
import main.java.views.IBaseView;
import main.java.views.ISearchView;

public class SearchForm extends AlgorithmForm implements ISearchView
{
	protected SearchPresenter presenter;
	
	// Components:
	protected JPanel buttonsPanel;
	protected JPanel operationPanel; 
	protected JToggleButton[] rangeButtons;
	protected JButton randomButton;
	protected JButton setAnswerButton;
	
	public SearchForm(IBaseView baseView)
	{
		super(baseView);
	}
	
	public void initialize()
	{
		// Panels:
		contentPanel.setLayout(new BorderLayout());
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(7, 0));
		
		// Range buttons:
		rangeButtons = new JToggleButton[101];
		for (int i = 0; i < rangeButtons.length; i++)
		{
			rangeButtons[i] = new JToggleButton("" + i);
			rangeButtons[i].setSelected(true);
			rangeButtons[i].setPreferredSize(new Dimension(55, 50));
			
			buttonsPanel.add(rangeButtons[i]);
		}
		contentPanel.add(buttonsPanel, BorderLayout.NORTH);
	
		// Control Panel:
		randomButton = new JButton("Random");
		setAnswerButton = new JButton("Set Answer");
		setControlPanel(new Component[] { randomButton, setAnswerButton });
		
		// Repaint:
		super.repaint();
	}
	
	public void bindResults(SearchResults results)
	{
		// Reset range buttons:
		for (int button = 0; button < rangeButtons.length; button++)
		{
			rangeButtons[button].setSelected(true);
			rangeButtons[button].setBackground(null);
		}
		
		// Show attempts:
		for (int i : results.getGuessData())
		{
			rangeButtons[i].setSelected(false);
			rangeButtons[i].setBackground(Color.ORANGE);
		}
		
		// Show answer:
		rangeButtons[results.getAnswer()].setSelected(false);
		rangeButtons[results.getAnswer()].setBackground(Color.CYAN);
		
		// Log results:
		clearLog();
		for (int attempt = 0; attempt < results.getGuessData().size(); attempt++)
		{
			int guess = results.getGuessData().get(attempt);
			
			log(String.format("\nAttempt %s: %s", (attempt + 1), guess));
		}
		log(String.format("\nAnswer, %s, found in %s attempts.", results.getAnswer(), results.getAttempts()));
	}
	
	public void setPresenter(SearchPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	public void addActionListeners()
	{
		randomButton.addActionListener(e -> { presenter.execute(getAlgorithm()); });
		setAnswerButton.addActionListener(e -> { executeAnswer(getAlgorithm());});
		addAlgTypeListener(presenter);
	}
	
	private void executeAnswer(String algorithm)
	{
		String input = JOptionPane.showInputDialog(contentPanel, "Enter an answer for the algorithm to find.", "<Whole number between 0 and 100>", JOptionPane.INFORMATION_MESSAGE);
		if (input != null && !input.isEmpty())
		{
			try
			{
				double answer = Double.parseDouble(input);
				int parsedAnswer = (int)answer;
			
				if (answer >= 0 && answer <= 100)
				{
					setStatus("Executing binary search...");
					presenter.execute(algorithm, parsedAnswer);
					setStatus("Binary search executed.");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPanel, "Please input a number between 0 and 100.");
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(contentPanel, "Please input a number between 0 and 100.");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(contentPanel, "Please input a number between 0 and 100.");
		}
	}
}
