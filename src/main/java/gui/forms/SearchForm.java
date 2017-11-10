package main.java.gui.forms;

import javax.swing.*;

import java.awt.*;

public class SearchForm extends MainForm
{
	private String[] algorithmList = {"Linear Search", "Binary Search", "Selection Sort"};
	
	// GUI components (all static to be used in the static GUI() method):
	protected JPanel panel01;
	protected JPanel panel02;
	protected JPanel panel03;
	public JToggleButton[] rangeButtons;
	public JButton[] userButtons;
	public JTextArea myTextArea;	
	// Drop-down menu for the algorithms:
	public JComboBox<String> algList;
	// Shows guesses on the GUI when checked:
	public JCheckBox guessCheck;
	
	// Constraints for the GridBagLayout:
	private GridBagConstraints c;
	
	public SearchForm()
	{
		panel01 = new JPanel(new GridLayout(5, 20)); 
		panel02 = new JPanel(new GridBagLayout());	
		panel03 = new JPanel();			
		rangeButtons = new JToggleButton[101];		
		userButtons = new JButton[3];  		    
		myTextArea = new JTextArea();	   	
		algList = new JComboBox<String>(algorithmList);
		guessCheck = new JCheckBox("Show Guesses (Orange)");
		c = new GridBagConstraints();
	}
	
	public void Initialize()
	{
		// Set/change constraints for the above GridBagConstraints and apply 
		// constraints to panels:
		setConstraints("Horizontal", 0, 1, 0, 100, 0, 0);
		mainPanel.add(panel01, c);
		setConstraints("None", 0.5, 0.5, 450, 0, 0, 1);
		mainPanel.add(panel02, c);
		setConstraints("None", 0.25, 0, 0, 100, 1, 0);
		mainPanel.add(panel03, c);
		
		// Create buttons based on type and assign them to a panel:
		createButtons(rangeButtons, panel01);
		createButtons(userButtons, panel02);
		
		// Add algorithm list and "show guess" checkbox to panel02:
		panel02.add(algList);
		panel02.add(guessCheck);
		
		// Defaults to Linear Search
		algList.setSelectedIndex(0);
		
		// Configure text area and add it to panel 03:
		configureTextArea(myTextArea);
		panel03.add(myTextArea);
	}
	
	public void createButtons(JToggleButton[] buttons, JPanel panel)
	{
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new JToggleButton("" + i);
			buttons[i].setSelected(true);
			buttons[i].setPreferredSize(new Dimension(55, 50));
			
			panel.add(buttons[i]);
		}
	}
	
	public void createButtons(JButton[] buttons, JPanel panel)
	{
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new JButton("");
			buttons[i].setSelected(true);
			buttons[i].setPreferredSize(new Dimension(100, 25));
			
			panel.add(buttons[i]);
			
			switch(i)
			{
				case(0):
				{
					buttons[i].setText("Random");
					break;
				}
				case(1):
				{
					buttons[i].setText("SetAnswer");
					break;
				}
				case(2):
				{
					buttons[i].setText("Set All");
					break;
				}
			}
		}
	}
	
	public void configureTextArea(JTextArea area)
	{
		area.setPreferredSize(new Dimension(150, 250));
		area.setBorder(BorderFactory.createEtchedBorder());
		area.setEditable(false);
	}
	
	
	public void resetRangeButtons()
	{
		for (JToggleButton button: rangeButtons)
		{
			button.setSelected(true);
			button.setBackground(null);
		}
	}
	
	public void setSelectedAlgorithm(String option)
	{
		algList.setSelectedItem(option);
	}

	/**
	*  Add constraints to global GridBagConstraints variable to format panels.
	*/
	private void setConstraints(String fill, double weightx, double weighty, int ipadx, int ipady, int gridx, int gridy)
	{
		switch(fill)
		{
			case("Horizontal"):
			{
				c.fill = GridBagConstraints.HORIZONTAL;
			}
			default:
			{
				c.fill = GridBagConstraints.NONE;
			}
		}
		
		c.weightx = weightx;
		c.weighty = weighty;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.gridx = gridx;
		c.gridy = gridy;
	}
}
