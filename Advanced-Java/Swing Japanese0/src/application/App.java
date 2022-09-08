package application;

import javax.swing.SwingUtilities;

import gui.MainFrame;

class Controller {
	private static MainFrame mainFrame;
	
	public Controller() {
		mainFrame = new MainFrame();
	}
}

public class App {

	public static void main(String[] args) {
		
		//Controller controller = new Controller();
		//SwingUtilities.invokeLater(controller);
		SwingUtilities.invokeLater(Controller::new);

	}

}
