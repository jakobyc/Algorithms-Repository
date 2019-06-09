package main.java.presenters;

import main.java.views.ViewFactory;

public class PresenterFactory 
{
	// TODO: Create IPresenter interface and merge these methods into one createPresenter:
	public static SearchPresenter createSearchPresenter()
	{
		return new SearchPresenter(ViewFactory.getSearchView());
	}
	
	public static SortPresenter createSortPresenter()
	{
		return new SortPresenter(ViewFactory.getSortView());
	}
}
