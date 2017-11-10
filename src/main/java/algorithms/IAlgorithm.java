package main.java.algorithms;

// Strategy for the Strategy pattern:
public interface IAlgorithm<Results, Params>
{
	Results execute(Params parameters);
}