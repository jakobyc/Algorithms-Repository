package main.java.algorithms;

import java.util.List;

public interface ISearch extends IAlgorithm
{
	int getAttempts();
	int getTarget();
	
	double getAnswer();

	List<Integer> getGuessData();
	
	void setAnswer(double answer);
	void setTarget(int target);
}
