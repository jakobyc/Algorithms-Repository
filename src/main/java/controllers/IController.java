package main.java.controllers;

import java.awt.event.ActionListener;

import main.java.views.ViewFactory.ViewType;

public interface IController 
{
	void addActionListener(ActionListener listener);
	void changeView(ViewType type);
}
