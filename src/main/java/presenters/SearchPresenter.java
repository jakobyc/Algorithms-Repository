package main.java.presenters;

import main.java.Constants;
import main.java.models.SearchModel;
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
	
	public void detachView()
	{
		if (view != null)
		{
			view.dispose();
			view = null;
		}
	}
	
	public void execute(String algorithmName)
	{
		int answer = (int)Math.ceil(Math.random() * 100);

		execute(algorithmName, answer);
	}
	
	public void execute(String algorithmName, int answer)
	{
		view.bindResults(model.getResults(model.getAlgorithm(algorithmName), answer));
	}
}
