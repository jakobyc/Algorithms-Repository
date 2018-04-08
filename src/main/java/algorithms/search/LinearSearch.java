package main.java.algorithms.search;

import java.util.List;

import main.java.algorithms.IAlgorithm;
import main.java.algorithms.search.results.*;
import main.java.algorithms.search.params.*;

import java.util.ArrayList;

public class LinearSearch implements IAlgorithm<SearchResults, SearchParams>
{
	public LinearSearch() { }
	
	public SearchResults execute(SearchParams parameters) 
	{
		int attempts = 0,
		    target = 0;
		
		List<Integer> guessData = new ArrayList<Integer>();

		guessData = new ArrayList<Integer>();
		
		while (parameters.answer != target)
		{
			attempts += 1;
			
			if (parameters.answer > target)
			{
				guessData.add(target);
				target += 1;
			}
		}
		
		return new SearchResults(attempts, parameters.answer, guessData);
	}
}
