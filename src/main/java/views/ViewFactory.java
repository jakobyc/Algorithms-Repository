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
	
	public static IView GetView(ViewType type)
	{
		switch(type)
		{
		case LINEAR_SEARCH:
			return new LinearSearchView();
		case BINARY_SEARCH:
			return new BinarySearchView();
	    default:
	    	return null;
		}
	}
	
	public static ISearchView GetSearchView(ViewType type)
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
	
	public enum ViewType
	{
		LINEAR_SEARCH,
		BINARY_SEARCH
	}
}
