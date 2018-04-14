package main.java.models;

import main.java.Constants;

public class SortModel 
{
	public String[] getAlgorithmOptions()
	{
		return Constants.Algorithms.Sort.Names;
	}
	
	public String[] getAlgorithmTypes()
	{
		return Constants.Algorithms.Types;
	}
}
