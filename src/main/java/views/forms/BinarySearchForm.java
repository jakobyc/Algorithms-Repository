package main.java.views.forms;

import main.java.views.*;

public class BinarySearchForm extends SearchForm implements ISearchView
{
	public BinarySearchForm(IBaseView baseView)
	{
		super(baseView);
	}
	
	/*public void addActionListeners()
	{
		algorithmsList.addActionListener(e -> { changeView(); });
		algorithmTypes.addActionListener(e -> changeType());
	}
	
	public void bindAlgorithms(String[] algorithms)
	{
		super.bindAlgorithms(algorithms);
		
		algorithmsList.setSelectedIndex(1);
	}
	
	public void bindAlgorithmTypes(String[] types)
	{
		super.bindAlgorithmTypes(types);
		
		algorithmTypes.setSelectedIndex(0);
	}*/
}
