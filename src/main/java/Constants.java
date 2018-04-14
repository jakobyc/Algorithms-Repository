package main.java;

public final class Constants 
{
	public final static class Algorithms
	{
		public final static String[] Types = new String[]
		{
			Distance.Type,
			Search.Type,
			Sort.Type
		};
		public final static class Search
		{
			public final static String[] Names = new String[]
			{
					Search.Binary,
					Search.Linear
			};
			public final static String Type = "Search",
									   Binary = "Binary Search",
									   Linear = "Linear Search";
		}
		
		public final static class Sort
		{
			public final static String[] Names = new String[]
			{
					Sort.Bubble,
					Sort.Selection,
					Sort.Quick
			};
			public final static String Type = "Sort",
									   Bubble = "Bubble Sort",
									   Selection = "Selection Sort",
									   Quick = "Quick Sort";
		}
		
		public final static class Distance
		{
			public final static String[] Names = new String[]
			{
					Distance.Levenshtein
			};
			public final static String Type = "Distance",
									   Levenshtein = "Levenshtein Distance";
		}
	}
}
