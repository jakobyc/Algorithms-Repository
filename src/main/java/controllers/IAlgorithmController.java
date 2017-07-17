package main.java.controllers;

import java.awt.event.ActionListener;

import main.java.algorithms.IAlgorithm;

public interface IAlgorithmController extends IController
{
	IAlgorithm getAlgorithm();
	
	void addActionListener(ActionListener listener);
}
