package main.java.controllers;

import main.java.algorithms.IAlgorithm;

public abstract class AlgorithmController implements IAlgorithmController
{
	private IAlgorithm algorithm;
	
	public IAlgorithm getAlgorithm()
	{
		return algorithm;
	}
	public void changeView()
	{
	}
}