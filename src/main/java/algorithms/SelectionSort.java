package main.java.algorithms;

import java.util.List;

import main.java.algorithms.results.IAlgorithmResults;

// Selection sort algorithm:
/* Pseudocode:
 * 1. Create a swap method that has two variables, startIndex and temp (temporary variable to store index data)
 * 2. Find the smallest number in the range and swap it with the first number (need to swap index values).
 * 3. Find the second smallest number in the range and swap it with the second number.
 * 4. Repeat process until entire range of numbers is sorted selectively. 
 */

public class SelectionSort implements IAlgorithm, ISort
{
	// Index with the smallest value and it's associated value:
	private int minIndex, minValue;
	
	private List<Integer> data;
	
	public SelectionSort(List<Integer> data)	
	{ 
		this.data = data;
	}
	
	public void calculate()
	{
		int min;
		
		for (int i = 0; i < data.size(); i++)
		{
			min = findMinimumIndex(i);
			swap(i, min);
		}
	}
	
	public void reset()
	{
		
	}
	
	private int findMinimumIndex(int startIndex)
	{
		// Default minimum value and index set to the first index in the subarray:
		minValue = data.get(startIndex);
		minIndex = startIndex;
		
		for (int i = minIndex + 1; i < data.size(); i++)
		{
			if (data.get(i) < minValue)
			{
				minIndex = i;
				minValue = data.get(i);
			}
		}
		
		return minIndex;
	}
	
	private void swap(int firstIndex, int secondIndex)
	{
		int temp = data.get(firstIndex);
		
		data.set(firstIndex, data.get(secondIndex));
		data.set(secondIndex, temp);
	}

	public IAlgorithmResults getResults() {
		// TODO Auto-generated method stub
		return null;
	}
}
