package main.java.controllers;

import java.awt.event.ActionListener;

public interface IController 
{
	void addActionListener(ActionListener listener);
	void changeView();
}
