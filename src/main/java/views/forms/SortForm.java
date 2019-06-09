package main.java.views.forms;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import main.java.algorithms.sort.results.SortResults;
import main.java.presenters.SortPresenter;
import main.java.views.IBaseView;
import main.java.views.ISortView;

public class SortForm extends AlgorithmForm implements ISortView
{
	private SortPresenter presenter;
	
	// Components:
	private JPanel buttonsPanel;
	private JButton executeButton;
	private JToggleButton[] rangeButtons;
	
	public SortForm(IBaseView baseView)
	{
		super(baseView);
	}

	public void addActionListeners() 
	{
		executeButton.addActionListener(e -> presenter.executeSelection());
	}

	public void initialize()
	{
		// Content Panel:
		contentPanel.setLayout(new BorderLayout());
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 0));
		
		// Range buttons:
		rangeButtons = new JToggleButton[11];
		for (int i = rangeButtons.length - 1; i > 0; i--)
		{
			rangeButtons[i] = new JToggleButton("" + i);
			rangeButtons[i].setSelected(true);
			rangeButtons[i].setPreferredSize(new Dimension(55, 50));
			
			buttonsPanel.add(rangeButtons[i]);
		}
		contentPanel.add(buttonsPanel, BorderLayout.NORTH);
		
		// Control Panel:
		executeButton = new JButton("Execute");
		setControlPanel(new Component[] { executeButton });
	}

	public void bindResults(SortResults results)
	{
		
	}

	public void setPresenter(SortPresenter presenter) 
	{
		this.presenter = presenter;
		
		addAlgTypeListener(presenter);
	}
}
