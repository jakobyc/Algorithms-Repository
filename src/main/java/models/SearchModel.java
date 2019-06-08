package main.java.models;

import java.util.HashMap;
import java.util.Map;

import main.java.Constants;
import main.java.algorithms.*;
import main.java.algorithms.search.*;
import main.java.algorithms.search.params.*;
import main.java.algorithms.search.results.*;

public class SearchModel 
{	
	private final Map<String, IAlgorithm<SearchResults, SearchParams>> ALGORITHM_MAP;
	
	public SearchModel()
	{
		ALGORITHM_MAP = new HashMap<String, IAlgorithm<SearchResults, SearchParams>>();
		ALGORITHM_MAP.put(Constants.Algorithms.Search.Linear, new LinearSearch());
		ALGORITHM_MAP.put(Constants.Algorithms.Search.Binary, new BinarySearch());
	}
	
	public SearchResults getResults(IAlgorithm<SearchResults, SearchParams> algorithm, int answer)
	{
		if (algorithm != null)
		{
			return algorithm.execute(new SearchParams(answer));
		}
		return null;
	}
	
	public String[] getAlgorithmOptions()
	{
		return new String[] { Constants.Algorithms.Search.Linear, Constants.Algorithms.Search.Binary };
	}
	
	public String[] getAlgorithmTypes()
	{
		return new String[] { 
								Constants.Algorithms.Search.Type, 
								Constants.Algorithms.Sort.Type, 
								Constants.Algorithms.Distance.Type 
						  	};
	}
	
	public IAlgorithm<SearchResults, SearchParams> getAlgorithm(String name)
	{
		if (ALGORITHM_MAP.size() > 0)
		{
			return ALGORITHM_MAP.get(name);
		}
		return null;
	}
}
