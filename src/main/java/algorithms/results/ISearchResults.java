package main.java.algorithms.results;

import java.util.List;

public interface ISearchResults extends IAlgorithmResults {
	int getTarget();

	int getAttempts();

	double getAnswer();

	List<Integer> getGuessData();
}
