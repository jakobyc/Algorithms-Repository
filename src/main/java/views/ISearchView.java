package main.java.views;

import main.java.algorithms.search.results.SearchResults;
import main.java.presenters.SearchPresenter;

public interface ISearchView extends IAlgorithmView
{
	// Consider using generics and abstracting to IView/IAlgorithmView:
	void bindResults(SearchResults results);
	void setPresenter(SearchPresenter presenter);
}
