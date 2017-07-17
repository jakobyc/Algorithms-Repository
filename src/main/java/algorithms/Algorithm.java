package main.java.algorithms;

import main.java.algorithms.results.IAlgorithmResults;

public abstract class Algorithm implements IAlgorithm
{
	abstract public void calculate();
	abstract public void reset();
	public IAlgorithmResults getResults()
	{
		return null;
	}
}
