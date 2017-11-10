package main.java.algorithms.search;

import java.util.ArrayList;
import java.util.List;

import main.java.algorithms.IAlgorithm;
import main.java.algorithms.search.results.*;
import main.java.algorithms.search.params.*;

public class BinarySearch implements IAlgorithm<SearchResults, SearchParams>
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
	
	public SearchResults execute(SearchParams parameters) 
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
		
		return getResults();
	}

	public void reset() 
	{
		this.attempts = 0;
		this.min = 0;
		this.max = 100;
		this.target = ((min + max) / 2);
	}

	// Accessors:
	public SearchResults getResults() 
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
