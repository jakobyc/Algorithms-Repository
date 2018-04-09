package main.java;

public final class Constants 
{
	public final static class Algorithms
	{
		public final static class Search
		{
			public final static String Binary = "Binary Search",
									   Linear = "Linear Search" ;
			
			public final static String GetName()
			{
				return "Search";
			}
		}
		
		public final static class Sort
		{
			public final static String Bubble = "Bubble Sort",
									   Selection = "Selection Sort",
									   Quick = "Quick Sort";
			
			public final static String GetName()
			{
				return "Sort";
			}
		}
		
		public final static class Distance
		{
			public final static String Levenshtein = "Levenshtein Distance";
		
			public final static String GetName()
			{
				return "Distance";
			}
		}
	}
}
