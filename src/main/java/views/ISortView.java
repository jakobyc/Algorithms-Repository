package main.java.views;

import main.java.algorithms.sort.results.SortResults;
import main.java.presenters.SortPresenter;;

public interface ISortView extends IAlgorithmView<SortResults, SortPresenter>
{
	void bindResults(SortResults results);
	void setPresenter(SortPresenter presenter);
}
