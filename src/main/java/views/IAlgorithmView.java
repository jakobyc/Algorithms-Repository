package main.java.views;

public interface IAlgorithmView<Results, Presenter> extends IView<Presenter>
{
	void bindAlgorithms(String[] algorithms);
	void bindAlgorithmTypes(String[] types);
	void bindResults(Results results);
}
