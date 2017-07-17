package main.java.algorithms;

import main.java.algorithms.results.ISearchResults;

public interface ISearch extends IAlgorithm
{
	ISearchResults getResults();
	
	void setAnswer(double answer);
	void setTarget(int target);
}
