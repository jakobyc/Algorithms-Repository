package main.java.models;

import main.java.Constants;
import main.java.algorithms.*;
import main.java.algorithms.search.params.SearchParams;
import main.java.algorithms.search.results.SearchResults;

public class SearchModel 
{	
	public SearchResults getResults(IAlgorithm<SearchResults, SearchParams> algorithm, int answer)
	{
		return algorithm.execute(new SearchParams(answer));
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
}
