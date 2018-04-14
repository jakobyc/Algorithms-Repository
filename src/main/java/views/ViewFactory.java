package main.java.views;

import main.java.views.*;
import main.java.views.forms.*;

@SuppressWarnings("unused")
public class ViewFactory 
{
	private final static IBaseView baseView;
	
	static
	{
		baseView = new BaseForm("Algorithms Repository");
	}
	
	public static ISearchView getSearchView(ViewType type)
	{
		switch(type)
		{
			case LINEAR_SEARCH:
				return new LinearSearchForm(baseView);
			case BINARY_SEARCH:
				return new BinarySearchForm(baseView);
			default:
				return null;
		}
	}
	
	public static ISortView getSortView(ViewType type)
	{
		switch(type)
		{
			case SELECTION_SORT:
				return new SelectionSortForm(baseView);
			default:
				return null;
		}
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
