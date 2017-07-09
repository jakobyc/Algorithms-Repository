package main.java;

import main.java.gui.forms.GUIMain;
import main.java.controllers.AlgorithmController;
import main.java.views.*;

public class Main 
{
	public static void main(String[] args)
	{
		GUIMain gui = new GUIMain();
		gui.Initialize();
		
		// Initial View:
		IView view  = new LinearSearchView(gui);
				
		AlgorithmController controller = new AlgorithmController(view);
	}
}
