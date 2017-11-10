package main.java.algorithms.search.results;

import java.util.List;

public interface ISearchResults 
{
	int getTarget();

	int getAttempts();

	double getAnswer();

	List<Integer> getGuessData();
}
