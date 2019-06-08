package main.java.views.forms;

import java.awt.*;
import javax.swing.*;
import main.java.views.IBaseView;

public class BaseForm implements IBaseView
{
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JPanel mainPanel;
	private JPanel viewPanel;
	private JLabel statusBar;
	
	public BaseForm()
	{
		initialize();
	}
	
	private void initialize()
	{
		// Frame:
		frame = new JFrame("Algorithms Repository");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,  450);
		
		// Menu:
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		menuItem = new JMenuItem("Options");
		
		menu.add(menuItem);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		// Main Panel:
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		frame.add(mainPanel);
		
		// View Panel:
		viewPanel = new JPanel();
		viewPanel.setLayout(new BorderLayout());
		mainPanel.add(viewPanel);
		
		// Status Bar:
		statusBar = new JLabel(" Ready");
		statusBar.setPreferredSize(new Dimension(frame.getWidth(), 25));
		statusBar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mainPanel.add(statusBar, BorderLayout.SOUTH);
		
		// Null parameter = center screen:
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void repaint()
	{
		this.frame.validate();
		this.frame.repaint();
	}
	
	public void setStatus(String message)
	{
		statusBar.setText(message);
	}
	
	public void setTitle(String title)
	{
		this.frame.setTitle(title);
	}
	
	public JPanel getViewPanel()
	{
		return viewPanel;
	}
}
