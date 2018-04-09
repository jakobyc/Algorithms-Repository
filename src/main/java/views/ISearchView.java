package main.java.views;

import main.java.algorithms.search.results.SearchResults;
import main.java.presenters.SearchPresenter;

public interface ISearchView extends IView
{
	// Consider abstracting to IAlgorithmView
	void bindAlgorithms(String[] algorithms);
	// Consider using generics and abstracting to IView/IAlgorithmView:
	void bindResults(SearchResults results);
	void setPresenter(SearchPresenter presenter);
}
