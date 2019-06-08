package main.java.views.forms;

import main.java.views.*;

public class LinearSearchForm extends SearchForm implements ISearchView
{
	public LinearSearchForm(IBaseView baseView)
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
		
		algorithmsList.setSelectedIndex(0);
	}
	
	public void bindAlgorithmTypes(String[] types)
	{
		super.bindAlgorithmTypes(types);
		
		algorithmTypes.setSelectedIndex(0);
	}*/
}
