package main.java.presenters;

import main.java.Constants;
import main.java.algorithms.search.*;
import main.java.models.SearchModel;
import main.java.views.ViewFactory;
import main.java.views.ViewFactory.ViewType;
import main.java.views.forms.*;

public class SearchPresenter 
{
	private ISearchView view;
	private SearchModel model;
	
	private final String[] algorithms = new String[] { Constants.Algorithms.Search.Linear, Constants.Algorithms.Search.Binary };
	
	public SearchPresenter(ISearchView view)
	{
		attachView(view);
		
		this.model = new SearchModel();
	}
	
	public void attachView(ISearchView newView)
	{
		if (newView != null)
		{
			view = newView;
			view.initialize();
			view.bindAlgorithms(algorithms);
			view.setPresenter(this);
			view.addActionListeners();
		}
	}
	
	public void detachView()
	{
		if (view != null)
		{
			view.dispose();
			view = null;
		}
	}
	
	public void executeLinear()
	{
		int answer = (int)Math.ceil(Math.random() * 100);
		
		executeLinear(answer);
	}
	
	public void executeLinear(int answer)
	{
		view.bindResults(model.getResults(new LinearSearch(), answer));
	}
	
	public void executeBinary()
	{
		int answer = (int)Math.ceil(Math.random() * 100);
		
		executeBinary(answer);
	}
	
	public void executeBinary(int answer)
	{
		view.bindResults(model.getResults(new BinarySearch(), answer));
	}
	
	public void changeView(String viewName)
	{
		switch(viewName)
		{
			case(Constants.Algorithms.Search.Linear):
				if (view.getClass() != LinearSearchForm.class)
				{
					detachView();
					attachView(ViewFactory.GetSearchView(ViewType.LINEAR_SEARCH));
				}
				break;
			case(Constants.Algorithms.Search.Binary):
				if (view.getClass() != BinarySearchForm.class)
				{
					detachView();
					attachView(ViewFactory.GetSearchView(ViewType.BINARY_SEARCH));
				}
				break;
		}
	}
}
