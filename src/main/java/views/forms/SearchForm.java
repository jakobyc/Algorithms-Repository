package main.java.views.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.java.algorithms.search.results.SearchResults;
import main.java.presenters.SearchPresenter;
import main.java.views.IBaseView;

public abstract class SearchForm
{
	protected IBaseView baseView;
	protected SearchPresenter presenter;
	
	// Components:
	protected JPanel viewPanel;
	protected JPanel buttonsPanel;
	protected JPanel operationPanel; 
	protected JPanel logPanel;
	protected JPanel userPanel;
	protected JToggleButton[] rangeButtons;
	protected JScrollPane logScroll;
	protected JTextArea log;
	// User buttons:
	protected JButton randomButton;
	protected JButton setAnswerButton;
	protected JComboBox<String> algorithmsList;
	protected JComboBox<String> algorithmTypes;
	
	public SearchForm(IBaseView baseView)
	{
		this.baseView = baseView;
		this.viewPanel = baseView.getViewPanel();
	}
	
	
	protected void changeType()
	{
		presenter.changeAlgorithmType(algorithmTypes.getSelectedItem().toString());
	}
	
	protected void changeView()
	{
		presenter.changeView(algorithmsList.getSelectedItem().toString());
	}
	
	
	public void initialize()
	{
		// Panels:
		viewPanel.setLayout(new BorderLayout());
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(4, 0));
		operationPanel = new JPanel();
		operationPanel.setLayout(new BorderLayout());
		operationPanel.setBorder(new EmptyBorder(10, 25, 10, 25));
		
		// Range buttons:
		rangeButtons = new JToggleButton[101];
		for (int i = 0; i < rangeButtons.length; i++)
		{
			rangeButtons[i] = new JToggleButton("" + i);
			rangeButtons[i].setSelected(true);
			rangeButtons[i].setPreferredSize(new Dimension(55, 50));
			
			buttonsPanel.add(rangeButtons[i]);
		}
		viewPanel.add(buttonsPanel, BorderLayout.NORTH);
		viewPanel.add(operationPanel, BorderLayout.CENTER);
		
		userPanel = new JPanel();
		operationPanel.add(userPanel, BorderLayout.WEST);
		logPanel = new JPanel();
		operationPanel.add(logPanel, BorderLayout.EAST);

		// Log:
		log = new JTextArea(5, 25);
		log.setEditable(false);
		log.setText("Waiting for operation...");
		log.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), 
														 BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		logScroll = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		logPanel.add(logScroll);

		// User buttons/lists:
		algorithmTypes = new JComboBox<String>();
		algorithmsList = new JComboBox<String>();
		randomButton = new JButton("Random");
		setAnswerButton = new JButton("Set Answer");

		userPanel.add(algorithmTypes);
		userPanel.add(algorithmsList);
		userPanel.add(randomButton);
		userPanel.add(setAnswerButton);
		
		// Paint:
		baseView.repaint();
	}
	
	protected void bindAlgorithms(String[] algorithms)
	{
		if (algorithms != null)
		{
			algorithmsList.removeAllItems();
			for (String algorithm : algorithms)
			{
				algorithmsList.addItem(algorithm);
			}
		}
	}
	
	protected void bindAlgorithmTypes(String[] types)
	{
		if (algorithmTypes != null)
		{
			algorithmTypes.removeAllItems();
			for (String algorithm : types)
			{
				algorithmTypes.addItem(algorithm);
			}
		}
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
		log.setText("");
		for (int attempt = 0; attempt < results.getGuessData().size(); attempt++)
		{
			int guess = results.getGuessData().get(attempt);
			
			if (log.getText().equals(""))
			{
				log.setText(String.format("Attempt %s: %s", (attempt + 1), guess));
			}
			else
			{
				log.append(String.format("\nAttempt %s: %s", (attempt + 1), guess));
			}
		}
		log.append(String.format("\nAnswer, %s, found in %s attempts.", results.getAnswer(), results.getAttempts()));
	}
	
	public void dispose()
	{
		viewPanel.removeAll();
		
		for (ActionListener listener : randomButton.getActionListeners())
		{
			randomButton.removeActionListener(listener);
		}
		
		for (ActionListener listener : setAnswerButton.getActionListeners())
		{
			setAnswerButton.removeActionListener(listener);
		}
		
		for (ActionListener listener : algorithmsList.getActionListeners())
		{
			algorithmsList.removeActionListener(listener);
		}
	}
	
	public void setStatus(String message)
	{
		baseView.setStatus(message);
	}
	
	public void setPresenter(SearchPresenter presenter)
	{
		this.presenter = presenter;
	}
}
