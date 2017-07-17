package main.java.algorithms.results;

import java.util.List;

public class SearchResults implements ISearchResults {
	private int target, attempts;

	private double answer;

	private List<Integer> guessData;

	public SearchResults(int target) {
		this.target = target;
	}

	public SearchResults(int target, int attempts) {
		this(target);
		this.attempts = attempts;
	}

	public SearchResults(int target, int attempts, double answer) {
		this(target, attempts);
		this.answer = answer;
	}

	public SearchResults(int target, int attempts, double answer, List<Integer> guessData) {
		this(target, attempts, answer);
		this.guessData = guessData;
	}

	public int getTarget() {
		return this.target;
	}

	public int getAttempts() {
		return this.attempts;
	}

	public double getAnswer() {
		return this.answer;
	}

	public List<Integer> getGuessData() {
		return this.guessData;
	}

}
