package main.java.controllers;

import main.java.models.AlgorithmModel;
import main.java.models.viewmodels.ViewModel;
import main.java.views.*;

import java.awt.event.ActionListener;

import main.java.algorithms.*;
import main.java.gui.listeners.MainListener;



public class AlgorithmController implements IAlgorithmController
{
	private AlgorithmModel model;
	private IView view;
	private IAlgorithm algorithm;
	
	public AlgorithmController(IView view)
	{
		this.view = view;
		this.model = new AlgorithmModel();
		
		// TODO: Add interfaces for listeners
		addActionListener(new MainListener(view, this));
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
	
	public void changeView()
	{
		// TODO: Binary search hard-coded until I decide how I want to change views:
		view.removeActionListeners();
		this.view = new BinarySearchView(view.getGUI());
		view.addActionListener(new MainListener(view, this));
	}
	
	private void calculateSearch(double answer)
	{
		ViewModel.Algorithm.Search viewModel = new ViewModel.Algorithm.Search();
		
		// Validate type safety before downcasting:
		if (algorithm instanceof ISearch)
		{
			ISearch searchAlgorithm = (ISearch) algorithm;
			model.setAnswer(searchAlgorithm, answer);
			model.calculate(searchAlgorithm);
			
			viewModel.Answer = searchAlgorithm.getAnswer();
			viewModel.Target = searchAlgorithm.getTarget();
			viewModel.Attempts = searchAlgorithm.getAttempts();
			viewModel.GuessData = searchAlgorithm.getGuessData();
			// Ensure error isn't carried over from a previous request:
			viewModel.Error = null;
			view.update(viewModel);	
		}
		else
		{
			viewModel.Error = "Not the correct instance for this algorithm.";
			view.update(viewModel);
			view.displayError();
		}
		
	}
}