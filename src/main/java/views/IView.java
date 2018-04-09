package main.java.views;

public interface IView 
{
	void addActionListeners();
	void dispose();
	void initialize();
	void setStatus(String message);
}
