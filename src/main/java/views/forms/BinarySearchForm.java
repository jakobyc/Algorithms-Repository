package main.java.views.forms;

import javax.swing.JOptionPane;
import main.java.views.*;

public class BinarySearchForm extends SearchForm implements ISearchView
{
	public BinarySearchForm(IBaseView baseView)
	{
		super(baseView);
	}
	
	public void addActionListeners()
	{
		randomButton.addActionListener(e -> { executeRandom(); });
		setAnswerButton.addActionListener(e -> { executeAnswer(); });
		algorithmsList.addActionListener(e -> { changeView(algorithmsList.getSelectedItem().toString()); });
	}
	
	public void bindAlgorithms(String[] algorithms)
	{
		super.bindAlgorithms(algorithms);
		
		algorithmsList.setSelectedIndex(1);
	}
	
	private void executeRandom()
	{
		setStatus("Executing binary search...");
		presenter.executeBinary();
		setStatus("Binary search executed.");
	}
	
	private void executeAnswer()
	{
		String input = JOptionPane.showInputDialog(viewPanel, "Enter an answer for the algorithm to find.", "<Whole number between 0 and 100>", JOptionPane.INFORMATION_MESSAGE);
		if (input != null && !input.isEmpty())
		{
			try
			{
				double answer = Double.parseDouble(input);
				int parsedAnswer = (int)answer;
			
				if (answer >= 0 && answer <= 100)
				{
					setStatus("Executing binary search...");
					presenter.executeBinary(parsedAnswer);
					setStatus("Binary search executed.");
				}
				else
				{
					JOptionPane.showMessageDialog(viewPanel, "Please input a number between 0 and 100.");
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(viewPanel, "Please input a number between 0 and 100.");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(viewPanel, "Please input a number between 0 and 100.");
		}
	}
}
