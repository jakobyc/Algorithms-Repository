package main.java.views.forms;

import java.awt.*;

import javax.swing.*;

import main.java.Constants;
import main.java.algorithms.sort.results.SortResults;
import main.java.presenters.SortPresenter;
import main.java.views.IBaseView;
import main.java.views.ISortView;

public class SelectionSortForm extends AlgorithmForm implements ISortView
{
	private SortPresenter presenter;
	
	private JPanel userPanel;
	private JComboBox<String> algorithmsList;
	private JComboBox<String> algorithmTypes;
	
	public SelectionSortForm(IBaseView baseView)
	{
		super(baseView);
	}

	public void bindAlgorithms(String[] algorithms) 
	{
		if (algorithms != null)
		{
			algorithmsList.removeAllItems();
			for (String algorithm : algorithms)
			{
				algorithmsList.addItem(algorithm);
			}
		}
		algorithmsList.setSelectedIndex(1);
	}

	public void bindAlgorithmTypes(String[] types)
	{
		if (algorithmTypes != null)
		{
			algorithmTypes.removeAllItems();
			for (String algorithm : types)
			{
				algorithmTypes.addItem(algorithm);
			}
		}
		algorithmTypes.setSelectedIndex(2);
	}

	@Override
	public void addActionListeners() 
	{
		// TODO Auto-generated method stub
		
	}

	public void dispose() 
	{
		contentPanel.removeAll();
	}

	public void initialize() 
	{
		contentPanel.setLayout(new BorderLayout());
		userPanel = new JPanel();
		
		algorithmsList = new JComboBox<String>();
		algorithmTypes = new JComboBox<String>();
		
		userPanel.add(algorithmTypes);
		userPanel.add(algorithmsList);
		contentPanel.add(userPanel, BorderLayout.NORTH);
		
		repaint();
	}

	@Override
	public void bindResults(SortResults results)
	{
		// TODO Auto-generated method stub
		
	}

	public void setPresenter(SortPresenter presenter) 
	{
		this.presenter = presenter;
	}

}
