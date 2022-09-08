package controller;

import gui.MainFrame;
import gui.MainPanel;
import gui.MyFrame;
import gui.MyPanel;

public class Controller {
	private static MainFrame mainFrame;
	private static MainPanel mainPanel;
	private MyFrame myFrame;
	private static MyPanel myPanel; 
	
	public Controller() {
		mainPanel = new MainPanel();
		mainFrame = new MainFrame();
		//myFrame = new MyFrame();
		myPanel = new MyPanel();
		
		mainFrame.setContentPane(mainPanel);
		//mainFrame.setContentPane(myPanel);
	}
	
	public static void changePanel() {
		mainFrame.setContentPane(myPanel);
	}
	
	public static void changePanel1() {
		mainFrame.setContentPane(mainPanel);
	}
}
