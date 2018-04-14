package main.java.presenters;

import main.java.Constants;
import main.java.algorithms.search.*;
import main.java.models.SearchModel;
import main.java.views.ViewFactory;
import main.java.views.ViewFactory.ViewType;
import main.java.views.forms.BinarySearchForm;
import main.java.views.forms.LinearSearchForm;
import main.java.views.*;

public class SearchPresenter 
{
	private ISearchView view;
	private SearchModel model;
	
	public SearchPresenter(ISearchView view)
	{
		this.model = new SearchModel();
		
		attachView(view);
	}
	
	public void attachView(ISearchView newView)
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
	
	public void changeAlgorithmType(String algorithmType)
	{
		switch(algorithmType)
		{
			case(Constants.Algorithms.Sort.Type):
				view.dispose();
				PresenterFactory.createSortPresenter();
				break;
			case(Constants.Algorithms.Distance.Type):
				break;
		}
	}
	
	public void changeView(String viewName)
	{
		switch(viewName)
		{
			case(Constants.Algorithms.Search.Linear):
				if (view.getClass() != LinearSearchForm.class)
				{
					detachView();
					attachView(ViewFactory.getSearchView(ViewType.LINEAR_SEARCH));
				}
				break;
			case(Constants.Algorithms.Search.Binary):
				if (view.getClass() != BinarySearchForm.class)
				{
					detachView();
					attachView(ViewFactory.getSearchView(ViewType.BINARY_SEARCH));
				}
				break;
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
}
