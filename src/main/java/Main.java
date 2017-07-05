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
		
		AlgorithmController controller = new AlgorithmController();
		// Initial View:
		View view  = controller.linearSearch(gui);
	}
}
