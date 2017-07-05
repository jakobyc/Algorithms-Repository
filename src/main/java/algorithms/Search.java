package main.java.algorithms;

public interface Search extends Algorithm
{
	int getAttempts();
	double getAnswer();
	double getTarget();
	
	void setAnswer(double answer);
	void setTarget(double target);
}
