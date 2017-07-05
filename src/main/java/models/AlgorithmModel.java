package main.java.models;

import main.java.algorithms.Algorithm;
import main.java.algorithms.Search;

public class AlgorithmModel 
{
	public double Answer,
			      Target;
	
	public void calculate(Algorithm algorithm)
	{
		algorithm.calculate();
	}
	
	public void setAnswer(Algorithm algorithm, double answer)
	{
		Search searchAlgorithm = (Search)algorithm;
		searchAlgorithm.setAnswer(answer);
	}
}
