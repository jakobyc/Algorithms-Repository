package main.java.views;

import main.java.views.*;

@SuppressWarnings("unused")
public class ViewFactory 
{
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
	
	public enum ViewType
	{
		LINEAR_SEARCH,
		BINARY_SEARCH
	}
}
