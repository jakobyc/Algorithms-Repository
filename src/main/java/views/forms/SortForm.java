package main.java.views.forms;

import main.java.algorithms.sort.results.SortResults;
import main.java.presenters.SortPresenter;
import main.java.views.IBaseView;
import main.java.views.ISortView;

public class SortForm extends AlgorithmForm implements ISortView
{
	private SortPresenter presenter;
	
	public SortForm(IBaseView baseView)
	{
		super(baseView);
	}

	public void addActionListeners() 
	{
		
	}

	public void initialize()
	{
		
	}

	public void bindResults(SortResults results)
	{
		
	}

	public void setPresenter(SortPresenter presenter) 
	{
		this.presenter = presenter;
		
	}
}
