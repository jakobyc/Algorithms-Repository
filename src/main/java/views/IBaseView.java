package main.java.views;

import javax.swing.JPanel;

// Container for all views:
public interface IBaseView 
{
	JPanel getViewPanel();
	void repaint();
	void setStatus(String message);
}
