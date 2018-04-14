package main.java.presenters;

import main.java.views.ViewFactory;
import main.java.views.ViewFactory.ViewType;

public class PresenterFactory 
{
	// TODO: Create IPresenter interface and merge these methods into one createPresenter:
	public static SearchPresenter createSearchPresenter()
	{
		return new SearchPresenter(ViewFactory.getSearchView(ViewType.LINEAR_SEARCH));
	}
	
	public static SortPresenter createSortPresenter()
	{
		return new SortPresenter(ViewFactory.getSortView(ViewType.SELECTION_SORT));
	}
}
