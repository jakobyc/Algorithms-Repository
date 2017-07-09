package main.java.algorithms;

import java.util.List;
import java.util.ArrayList;

public class LinearSearch implements ISearch
{
	private int target,
				attempts;
	
	private double answer;
	
	private List<Integer> guessData;
	
	public LinearSearch(double answer) 
	{
		this.answer = answer;
	}
	
	public void calculate() 
	{
		reset();
		
		guessData = new ArrayList<Integer>();
		
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
	
	public int getTarget()
	{
		return this.target;
	}
	
	public int getAttempts()
	{
		return this.attempts;
	}
	
	public List<Integer> getGuessData()
	{
		return this.guessData;
	}
	
	// Mutators:
	public void setAnswer(double answer)
	{
		this.answer = answer;
	}
	
	public void setTarget(int target)
	{
		this.target = target;
	}
}
