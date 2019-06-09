package main.java.presenters;

import main.java.algorithms.search.results.SearchResults;
import main.java.models.SearchModel;
import main.java.views.*;

public class SearchPresenter extends AlgorithmPresenter<SearchResults, SearchPresenter>
{
	private SearchModel model;
	
	public SearchPresenter(ISearchView view)
	{
		this.model = new SearchModel();
		
		attachView(view, model.getAlgorithmOptions(), model.getAlgorithmTypes());
		view.setPresenter(this);
	}
	
	public void execute(String algorithmName)
	{
		int answer = (int)Math.ceil(Math.random() * 100);

		execute(algorithmName, answer);
	}
	
	public void execute(String algorithmName, int answer)
	{
		view.bindResults(model.getResults(model.getAlgorithm(algorithmName), answer));
	}
}
