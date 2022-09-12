package application;

import javax.swing.SwingUtilities;

import Database0.ReadFile;
import gui.MainFrame;
import gui.WordKanjiPanel;

class Controller {
	private static MainFrame mainFrame;
	//public static MainFrame mainFrame;
	private static WordKanjiPanel wordsPanel;
	
	public Controller() {
		mainFrame = new MainFrame();
		wordsPanel = new WordKanjiPanel();
		
		mainFrame.setContentPane(wordsPanel);
	}
}

public class App {

	public static void main(String[] args) {
		
		new ReadFile();
		//Controller controller = new Controller();
		//SwingUtilities.invokeLater(controller);
		SwingUtilities.invokeLater(Controller::new);
		//System.out.println(Controller.mainFrame.getContentPane().getSize());

	}

}
