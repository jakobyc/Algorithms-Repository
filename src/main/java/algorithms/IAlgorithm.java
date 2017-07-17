package main.java.algorithms;

import main.java.algorithms.results.IAlgorithmResults;

// Strategy for the Strategy pattern:
public interface IAlgorithm
{
	// Performs mathematical computations for each implemented algorithm:
	void calculate();
	void reset();
	
	IAlgorithmResults getResults();
}
