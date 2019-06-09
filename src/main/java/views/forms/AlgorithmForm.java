package main.java.views.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.*;

import main.java.Constants;
import main.java.presenters.AlgorithmPresenter;
import main.java.views.IBaseView;

public abstract class AlgorithmForm 
{
	private IBaseView baseView;
	//private AlgorithmPresenter presenter;
	
	private JPanel controlPanel;
	protected JPanel contentPanel;

	
	// Log components:
	private JTextArea log;
	private JScrollPane logScroll;
	
	// Input components:
	private JComboBox<String> algorithmTypes;
	private JComboBox<String> algorithmList;
	
	public AlgorithmForm(IBaseView baseView)
	{
		this.baseView = baseView;
		
		initialize();
	}
	
	private void initialize()
	{
		// Control Panel:
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2, 1));
		
		// Content Panel:
		contentPanel = new JPanel();
		
		// View Panel:
		baseView.getViewPanel().add(controlPanel, BorderLayout.EAST);
		baseView.getViewPanel().add(contentPanel);
		
		baseView.repaint();
 	}
	
	protected void clearLog()
	{
		log.setText("");
	}
	
	protected String getAlgorithm()
	{
		return algorithmList.getSelectedItem().toString();
	}
	
	protected String getAlgorithmType()
	{
		return algorithmTypes.getSelectedItem().toString();
	}
	
	protected void log(String message)
	{
		if (!message.isEmpty())
		{
			if (log.getText() == "")
			{
				log.setText(message);
			}
			else
			{
				log.append(message);
			}
		}
	}
	
	protected void addAlgTypeListener(AlgorithmPresenter<?, ?> presenter)
	{
		algorithmTypes.addActionListener((e) -> presenter.changeAlgorithmType(getAlgorithmType()));
	}
	
	public void bindAlgorithms(String[] algorithms)
	{
		if (algorithms != null)
		{
			algorithmList.removeAllItems();
			for (String algorithm : algorithms)
			{
				algorithmList.addItem(algorithm);
			}
		}
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
	}
	
	public void dispose()
	{
		baseView.getViewPanel().removeAll();
	}
	
	protected void repaint()
	{
		baseView.repaint();
	}
	
	protected void setControlPanel(Component[] components)
	{
		// Input Panel:
		JPanel inputPanel = new JPanel();
		algorithmTypes = new JComboBox<String>();
		algorithmTypes.addItem(Constants.Algorithms.Search.Type);
		algorithmTypes.addItem(Constants.Algorithms.Sort.Type);
		algorithmTypes.addItem(Constants.Algorithms.Distance.Type);
		algorithmList = new JComboBox<String>();
		algorithmList.addItem(Constants.Algorithms.Search.Linear);
		algorithmList.addItem(Constants.Algorithms.Search.Binary);
		
		inputPanel.add(algorithmTypes);
		inputPanel.add(algorithmList);
		for (Component component : components)
		{
			inputPanel.add(component);
		}
		
		controlPanel.add(inputPanel);
		
		// Log:
		log = new JTextArea(5, 25);
		log.setEditable(false);
		log.setText("Waiting for operation...");
		log.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY), 
														 BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		logScroll = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		controlPanel.add(logScroll);
	}
	
	public void setStatus(String message)
	{
		baseView.setStatus(message);
	}
}
