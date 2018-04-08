package main.java;

import main.java.presenters.*;
import main.java.views.ViewFactory;
import main.java.views.ViewFactory.*;

public class Main 
{
	public static void main(String[] args)
	{		
		SearchPresenter presenter = new SearchPresenter(ViewFactory.GetSearchView(ViewType.LINEAR_SEARCH));
	}
}
