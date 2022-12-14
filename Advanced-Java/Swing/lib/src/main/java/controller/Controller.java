package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import gui.MainFrame;
import gui.MainPanel;
import gui.MyFrame;
import model.Database;
import model.Profile;
import model.User;
import model.UserDao;
import model.UserDaoImpl;

public class Controller {
	private static MainFrame mainFrame;
	private static MainPanel mainPanel;
	private MyFrame myFrame;
	//private static MyPanel myPanel; 
	
	public Controller() {
		var props = Profile.getProperties("db");
		var db = Database.instance();
		try {
			db.connect(props);
		} catch (SQLException e) {
			System.out.println("Cannot connect to database!");
			return;
		}
		System.out.println("Connected to database");
		UserDao userDao = new UserDaoImpl();
		
		mainPanel = new MainPanel();
		mainPanel.setFormListener((username, password) -> {
			System.out.println(username + ": " + password);
			userDao.save(new User(username, password));
		});
		
		mainFrame = new MainFrame();
		
		mainFrame.setContentPane(mainPanel);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				try {
					db.close();
				} catch (SQLException e) {
					System.out.println("Cannot close database connection!");
				}
			}
		});
		
		
	}
	
	public static void changePanel() {
		//mainFrame.setContentPane(myPanel);
	}
	
	public static void changePanel1() {
		mainFrame.setContentPane(mainPanel);
	}
}
