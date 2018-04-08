package main.java.views.forms;

import main.java.algorithms.search.results.SearchResults;
import main.java.presenters.SearchPresenter;

public interface ISearchView
{
	void addActionListeners();
	void initialize();
	void setStatus(String message);
	void setPresenter(SearchPresenter presenter);
	void bindAlgorithms(String[] algorithms);
	void bindResults(SearchResults results);
	void dispose();
}
