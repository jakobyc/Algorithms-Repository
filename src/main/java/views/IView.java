package main.java.views;

public interface IView<Presenter>
{
	void addActionListeners();
	void dispose();
	void initialize();
	void setStatus(String message);
	void setPresenter(Presenter presenter);
}
