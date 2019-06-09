package main.java.views;

import main.java.presenters.AlgorithmPresenter;

public interface IAlgorithmView<Results, Presenter extends AlgorithmPresenter<?, ?>> extends IView<Presenter>
{
	void bindAlgorithms(String[] algorithms);
	void bindAlgorithmTypes(String[] types);
	void bindResults(Results results);
}
