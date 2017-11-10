package main.java;

import main.java.controllers.*;
import main.java.views.*;

public class Main 
{
	public static void main(String[] args)
	{		
		// Initial View:
		IView view  = new LinearSearchView();
				
		ISearchController controller = new SearchController(view);
	}
}
