package main.java.algorithms.search.results;

import java.util.List;

public interface ISearchResults 
{
	int getAttempts();

	int getAnswer();

	List<Integer> getGuessData();
}
