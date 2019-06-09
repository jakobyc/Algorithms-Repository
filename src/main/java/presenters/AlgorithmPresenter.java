package main.java.presenters;

import java.util.HashMap;
import java.util.Map;

import main.java.Constants;
import main.java.views.IAlgorithmView;

public abstract class AlgorithmPresenter<Result, Presenter extends AlgorithmPresenter<?, ?>> 
{
	protected IAlgorithmView<Result, Presenter> view;
	
	private final Map<String, Runnable> ALGORITHM_TYPE_MAP;

	public AlgorithmPresenter()
	{
		ALGORITHM_TYPE_MAP = new HashMap<String, Runnable>();
		ALGORITHM_TYPE_MAP.put(Constants.Algorithms.Search.Type, () -> PresenterFactory.createSearchPresenter());
		ALGORITHM_TYPE_MAP.put(Constants.Algorithms.Sort.Type, () -> PresenterFactory.createSortPresenter());
	}
	
	public void attachView(IAlgorithmView<Result, Presenter> newView, String[] algorithms, String[] types)
	{
		if (newView != null)
		{
			view = newView;
			view.initialize();
			view.bindAlgorithms(algorithms);
			view.bindAlgorithmTypes(types);
			view.addActionListeners();
		}
	}
	
	public void changeAlgorithmType(String algorithmType)
	{
		if (ALGORITHM_TYPE_MAP.size() > 0)
		{
			detachView();
			ALGORITHM_TYPE_MAP.get(algorithmType).run();
		}
	}
	
	public void detachView()
	{
		if (view != null)
		{
			view.dispose();
			view = null;
		}
	}
}
