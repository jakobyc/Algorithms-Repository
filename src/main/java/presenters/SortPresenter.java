package main.java.presenters;

import main.java.algorithms.sort.results.SortResults;
import main.java.models.SortModel;
import main.java.views.ISortView;

public class SortPresenter extends AlgorithmPresenter<SortResults, SortPresenter>
{
	private SortModel model;
	
	public SortPresenter(ISortView view)
	{
		this.model = new SortModel();
		
		attachView(view, model.getAlgorithmOptions(), model.getAlgorithmTypes());
		view.setPresenter(this);
	}
	
	public void executeSelection()
	{
		
	}
}
