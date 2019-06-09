package main.java.views;

import main.java.views.forms.*;

public class ViewFactory 
{
	private final static IBaseView baseView;
	
	static
	{
		baseView = new BaseForm();
	}
	
	public static ISearchView getSearchView()
	{
		return new SearchForm(baseView);
		
		/*switch(type)
		{
			case LINEAR_SEARCH:
				return new LinearSearchForm(baseView);
			case BINARY_SEARCH:
				return new BinarySearchForm(baseView);
			default:
				return null;
		}*/
	}
	
	public static ISortView getSortView()
	{
		return new SortForm(baseView);
		/*switch(type)
		{
			case SELECTION_SORT:
				return new SelectionSortForm(baseView);
			default:
				return null;
		}*/
	}
	
	public enum ViewType
	{
		// Search:
		LINEAR_SEARCH,
		BINARY_SEARCH,
		// Sort:
		SELECTION_SORT
	}
}
