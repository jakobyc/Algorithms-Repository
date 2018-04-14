package main.java.presenters;

import main.java.models.SortModel;
import main.java.views.ISortView;

public class SortPresenter 
{
	private ISortView view;
	private SortModel model;
	
	public SortPresenter(ISortView view)
	{
		this.model = new SortModel();
		
		attachView(view);
	}
	
	public void attachView(ISortView newView)
	{
		if (newView != null)
		{
			view = newView;
			view.initialize();
			view.bindAlgorithms(model.getAlgorithmOptions());
			view.bindAlgorithmTypes(model.getAlgorithmTypes());
			view.setPresenter(this);
			view.addActionListeners();
		}
	}
	
	public void changeAlgorithmTypes(String[] algorithmType)
	{
		
	}
	
	public void changeView(String viewName)
	{
		
	}
	
	public void detachView()
	{
		
	}
	
	public void executeSelection()
	{
		
	}
}
