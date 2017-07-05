package main.java.models.viewmodels;

// View Models for filtering client's access to model data:
public class ViewModel 
{
	public static class Algorithm
	{
		public static class Search extends Algorithm
		{
			public double Answer,
						  Target;
			public int Attempts;
			public String Error;
		}
		
		public static class Sort extends Algorithm
		{
			
		}
	}
}
