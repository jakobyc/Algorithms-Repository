package main.java.views;

import javax.swing.JPanel;

// Container for all views:
public interface IBaseView 
{
	void setStatus(String message);
	
	JPanel getViewPanel();
}
