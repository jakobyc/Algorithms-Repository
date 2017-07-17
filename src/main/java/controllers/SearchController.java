package main.java.controllers;

import java.awt.event.ActionListener;

import main.java.algorithms.IAlgorithm;
import main.java.algorithms.results.ISearchResults;
import main.java.gui.listeners.SearchListener;
import main.java.models.SearchModel;
import main.java.models.viewmodels.ViewModel;
import main.java.views.IView;
import main.java.views.ViewFactory;
import main.java.views.ViewFactory.ViewType;

public class SearchController implements IAlgorithmController, ISearchController
{
	private SearchModel model;
	private IView view;
	private IAlgorithm algorithm;
	
	public SearchController(IView view)
	{
		this.view = view;
		this.model = new SearchModel();
		
		this.addActionListener(new SearchListener(view, this));
	}
	
	public void random()
	{
		double answer = Math.ceil(Math.random() * 100);
		
		this.algorithm = view.getAlgorithm(answer);
		calculateSearch(answer);
	}
	
	public void setAnswer()
	{
		String answer = view.getAnswer();
		int maxValue = view.getGUI().rangeButtons.length - 1;

		try
		{
			double parsedAnswer = Double.parseDouble(answer);
			
			if (parsedAnswer >= 0 && parsedAnswer <= maxValue)
			{	
				this.algorithm = view.getAlgorithm(parsedAnswer);
				calculateSearch(parsedAnswer);
			}
			else
			{
				throw new Exception();
			}
		}
		catch (Exception e)
		{
			ViewModel.Algorithm.Search viewModel = new ViewModel.Algorithm.Search();
			viewModel.Error = "Input was not a number between 0 and " + maxValue;
			view.update(viewModel);
			view.displayError();
		}
	}
	
	public void addActionListener(ActionListener listener)
	{
		view.addActionListener(listener);
	}
	
	public IAlgorithm getAlgorithm()
	{
		return this.algorithm;
	}
	
	public SearchModel getModel()
	{
		return this.model;
	}
	
	public void changeView(ViewType type)
	{
		// TODO: Binary search hard-coded until I decide how I want to change views:
		view.removeActionListeners();
		this.view = ViewFactory.GetView(type);
		view.addActionListener(new SearchListener(view, this));
	}
	
	private void calculateSearch(double answer)
	{
		ViewModel.Algorithm.Search viewModel = new ViewModel.Algorithm.Search();
		
		model.setAnswer(algorithm, answer);
		model.calculate(algorithm);
		
		ISearchResults results = (ISearchResults) algorithm.getResults();
		if (results != null)
		{
			viewModel.Answer = results.getAnswer();
			viewModel.Target = results.getTarget();
			viewModel.Attempts = results.getAttempts();
			viewModel.GuessData = results.getGuessData();
			// Ensure error isn't carried over from a previous request:
			viewModel.Error = null;
			view.update(viewModel);	
		}
	}
}
