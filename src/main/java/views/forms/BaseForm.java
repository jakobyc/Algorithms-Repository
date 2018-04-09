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
	public JPanel viewPanel;
	private JLabel statusBar;
	
	public BaseForm(String title)
	{
		initialize(title);
	}
	
	private void initialize(String title)
	{
		// Frame:
		frame = new JFrame(title);
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
		mainPanel.add(viewPanel, BorderLayout.CENTER);
		
		// Status Bar:
		statusBar = new JLabel(" Ready");
		statusBar.setPreferredSize(new Dimension(frame.getWidth(), 25));
		statusBar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mainPanel.add(statusBar, BorderLayout.SOUTH);
		
		// Null parameter = center screen:
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void setStatus(String message)
	{
		statusBar.setText(message);
	}
	
	public JPanel getViewPanel()
	{
		return viewPanel;
	}
}
