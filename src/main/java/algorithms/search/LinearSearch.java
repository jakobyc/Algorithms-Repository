package main.java.algorithms.search;

import java.util.List;

import main.java.algorithms.IAlgorithm;
import main.java.algorithms.search.results.*;
import main.java.algorithms.search.params.*;

import java.util.ArrayList;

public class LinearSearch implements IAlgorithm<SearchResults, SearchParams>
{
	private int target,
				attempts;
	
	private double answer;
	
	private List<Integer> guessData;
	
	public LinearSearch(double answer) 
	{
		this.answer = answer;
	}
	
	public SearchResults execute(SearchParams parameters) 
	{
		reset();
				
		guessData = new ArrayList<Integer>();
		
		while (true)
		{
			attempts += 1;
			
			if (answer > target)
			{
				guessData.add(target);
				target += 1;
			}
			else if (answer == target)
			{
				break;
			}
		}
		
		return getResults();
	}
	
	/*public void calculate() 
	{
		reset();
		
		guessData = new ArrayList<Integer>();
		
		while (true)
		{
			attempts += 1;
			
			if (answer > target)
			{
				guessData.add(target);
				target += 1;
			}
			else if (answer == target)
			{
				break;
			}
		}
	}*/

	public void reset() 
	{
		this.attempts = 0;
		this.target = 0;
	}
	
	public SearchResults getResults()
	{
		return new SearchResults(target, attempts, answer, guessData);
	}
	
	// Accessors:
	public double getAnswer()
	{
		return this.answer;
	}
	
	public int getTarget()
	{
		return this.target;
	}
	
	public int getAttempts()
	{
		return this.attempts;
	}
	
	public List<Integer> getGuessData()
	{
		return this.guessData;
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
