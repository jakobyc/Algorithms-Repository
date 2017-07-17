package main.java.models;

import main.java.algorithms.IAlgorithm;
import main.java.algorithms.ISearch;

public class SearchModel 
{
	public double Answer, Target;

	public void calculate(IAlgorithm algorithm)
	{
		algorithm.calculate();
	}
	
	public void setAnswer(IAlgorithm algorithm, double answer)
	{
		ISearch searchAlgorithm = (ISearch)algorithm;
		searchAlgorithm.setAnswer(answer);
	}
}
