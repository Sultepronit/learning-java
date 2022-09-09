package application;

import javax.swing.SwingUtilities;

import gui.MainFrame;
import gui.WordKanjiPanel;

class Controller {
	private static MainFrame mainFrame;
	private static WordKanjiPanel wordsPanel;
	
	public Controller() {
		mainFrame = new MainFrame();
		wordsPanel = new WordKanjiPanel();
		
		mainFrame.setContentPane(wordsPanel);
	}
}

public class App {

	public static void main(String[] args) {
		
		//Controller controller = new Controller();
		//SwingUtilities.invokeLater(controller);
		SwingUtilities.invokeLater(Controller::new);

	}

}
