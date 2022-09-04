package gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		super("Swing Demo");
		
		setSize(1000, 800); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); //clothes app when main window is closed
		setVisible(true);// shows the window
	}
}
