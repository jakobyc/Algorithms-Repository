package main.java.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch implements ISearch
{
	private double answer;
	
	private int target,
				attempts,
				min,
				max;
	
	private List<Integer> guessData;
	
	public BinarySearch(double answer)
	{
		this.answer = answer;
	}
	
	public void calculate() 
	{	
		reset();
		
		guessData = new ArrayList<Integer>();
		
		while(true)
		{
			attempts += 1;
			
			if (target > answer)
			{
				max = target - 1;
				guessData.add(target);
			}
			else if (target < answer)
			{
				min = target + 1;
				guessData.add(target);
			}
			else if (target == answer)
			{
				break;
			}
			
			target = ((min + max) / 2);
		}
	}

	public void reset() 
	{
		this.attempts = 0;
		this.min = 0;
		this.max = 100;
		this.target = ((min + max) / 2);
	}

	// Accessors:
	public int getAttempts() 
	{
		return this.attempts;
	}

	public double getAnswer() 
	{
		return this.answer;
	}

	public int getTarget() 
	{
		return this.target;
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
