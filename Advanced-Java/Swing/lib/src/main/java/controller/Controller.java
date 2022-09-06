package controller;

import gui.MainFrame;
import gui.MainPanel;
import gui.MyFrame;

public class Controller {
	private MainFrame mainFrame;
	private MainPanel mainPanel;
	private MyFrame myFrame;
	
	public Controller() {
		mainPanel = new MainPanel();
		mainFrame = new MainFrame();
		myFrame = new MyFrame();
		
		mainFrame.setContentPane(mainPanel);
	}
}
