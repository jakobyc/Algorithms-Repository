package main.java.controllers;

import main.java.models.AlgorithmModel;
import main.java.models.viewmodels.ViewModel;
import main.java.views.*;
import main.java.algorithms.*;
import main.java.gui.forms.GUIMain;

public class AlgorithmController 
{
	private AlgorithmModel model;
	private View view;
	private Algorithm algorithm;
	
	public AlgorithmController()
	{
		this.model = new AlgorithmModel();
	}
	
	public View linearSearch(GUIMain gui)
	{		
		double answer = Math.ceil(Math.random() * 100);
		algorithm = new LinearSearch(answer);
		ViewModel.Algorithm.Search viewModel = new ViewModel.Algorithm.Search();
		this.view = new LinearSearchView(this, viewModel, gui);
		return view;
	}
	
	public ViewModel.Algorithm.Search calculate(ViewModel.Algorithm.Search viewModel)
	{
		double answer = Math.ceil(Math.random() * 100);
		
		return calculateSearch(viewModel, answer);
	}
	
	public ViewModel.Algorithm.Search setAnswer(ViewModel.Algorithm.Search viewModel, String answer, int maxValue)
	{
		try
		{
			double parsedAnswer = Double.parseDouble(answer);
			
			if (parsedAnswer >= 0 && parsedAnswer <= maxValue)
			{
				// Ensure error isn't carried over from a previous request:
				viewModel.Error = null;
				return calculateSearch(viewModel, parsedAnswer);
			}
			else
			{
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		catch (Exception e)
		{
			viewModel.Error = "Input was not a number between 0 and " + maxValue;
		}
		
		return viewModel;
	}
	
	private ViewModel.Algorithm.Search calculateSearch(ViewModel.Algorithm.Search viewModel, double answer)
	{
		Search searchAlgorithm = (Search) algorithm;
		model.setAnswer(searchAlgorithm, answer);
		model.calculate(searchAlgorithm);
		
		viewModel.Answer = searchAlgorithm.getAnswer();
		viewModel.Target = searchAlgorithm.getTarget();
		viewModel.Attempts = searchAlgorithm.getAttempts();
		return viewModel;
	}
}
