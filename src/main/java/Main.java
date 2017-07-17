package main.java;

import main.java.controllers.IAlgorithmController;
import main.java.controllers.SearchController;
import main.java.views.*;

public class Main 
{
	public static void main(String[] args)
	{		
		// Initial View:
		IView view  = new LinearSearchView();
				
		IAlgorithmController controller = new SearchController(view);
	}
}
