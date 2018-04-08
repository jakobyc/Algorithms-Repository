package main.java.algorithms.search.results;

import java.util.List;

public class SearchResults implements ISearchResults 
{
	private int answer, 
				attempts;

	private List<Integer> guessData;


	public SearchResults(int attempts) {
		this.attempts = attempts;
	}

	public SearchResults(int attempts, int answer) {
		this(attempts);
		this.answer = answer;
	}

	public SearchResults(int attempts, int answer, List<Integer> guessData) {
		this(attempts, answer);
		this.guessData = guessData;
	}

	public int getAttempts() {
		return this.attempts;
	}

	public int getAnswer() {
		return this.answer;
	}

	public List<Integer> getGuessData() {
		return this.guessData;
	}

}
