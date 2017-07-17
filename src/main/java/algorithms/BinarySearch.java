package main.java.algorithms;

import java.util.ArrayList;
import java.util.List;

import main.java.algorithms.results.ISearchResults;
import main.java.algorithms.results.SearchResults;

public class BinarySearch implements IAlgorithm, ISearch
{
	private double answer;
	
	private int target,
				attempts,
				min,
				max;
	
	private List<Integer> guessData;
	
	public BinarySearch(double answer)
	{
		this.answer = answer;
	}
	
	public void calculate() 
	{	
		reset();
		
		guessData = new ArrayList<Integer>();
		
		while(true)
		{
			attempts += 1;
			
			if (target > answer)
			{
				max = target - 1;
				guessData.add(target);
			}
			else if (target < answer)
			{
				min = target + 1;
				guessData.add(target);
			}
			else if (target == answer)
			{
				break;
			}
			
			target = ((min + max) / 2);
		}
	}

	public void reset() 
	{
		this.attempts = 0;
		this.min = 0;
		this.max = 100;
		this.target = ((min + max) / 2);
	}

	// Accessors:
	public ISearchResults getResults() 
	{
		return new SearchResults(target, attempts, answer, guessData);
	}
	
	// Mutators:
	public void setAnswer(double answer) 
	{
		this.answer = answer;
	}

	public void setTarget(int target) 
	{
		this.target = target;
	}
}
