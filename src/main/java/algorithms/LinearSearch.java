package main.java.algorithms;

import java.util.List;
import java.util.ArrayList;

public class LinearSearch implements Algorithm, Search
{
	private int attempts;
	
	private double answer, 
				   target;
	
	public LinearSearch(double answer) 
	{
		this.answer = answer;
	}
	
	public void calculate() 
	{
		reset();
		
		List<Double> guessData = new ArrayList<Double>();
		
		while (true)
		{
			attempts += 1;
			
			if (answer > target)
			{
				guessData.add(target);
				target += 1;
			}
			else if (answer == target)
			{
				break;
			}
		}
	}

	public void reset() 
	{
		this.attempts = 0;
		this.target = 0;
	}
	
	// Accessors:
	public double getAnswer()
	{
		return this.answer;
	}
	
	public double getTarget()
	{
		return this.target;
	}
	
	public int getAttempts()
	{
		return this.attempts;
	}
	
	// Mutators:
	public void setAnswer(double answer)
	{
		this.answer = answer;
	}
	
	public void setTarget(double target)
	{
		this.target = target;
	}
}
