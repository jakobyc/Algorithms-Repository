package main.java.algorithms.search;

import java.util.ArrayList;
import java.util.List;

import main.java.algorithms.IAlgorithm;
import main.java.algorithms.search.results.*;
import main.java.algorithms.search.params.*;

public class BinarySearch implements IAlgorithm<SearchResults, SearchParams>
{
	public BinarySearch() { }
	
	public SearchResults execute(SearchParams parameters) 
	{
		int attempts = 0,
		    min = 0,
		    max = 100,
		    target = (min + max) / 2;
		
		List<Integer> guessData = new ArrayList<Integer>();
		
		while(true)
		{
			attempts += 1;
			
			if (target > parameters.answer)
			{
				max = target - 1;
				guessData.add(target);
			}
			else if (target < parameters.answer)
			{
				min = target + 1;
				guessData.add(target);
			}
			else if (target == parameters.answer)
			{
				break;
			}
			
			target = ((min + max) / 2);
		}
		
		return new SearchResults(attempts, parameters.answer, guessData);
	}
}
