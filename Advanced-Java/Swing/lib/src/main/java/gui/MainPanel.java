package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MainPanel() {
		//setBackground(Color.YELLOW);
		
		var formLabel = new JLabel("Add User");
		var nameLabel = new JLabel("Name:");
		var passLabel = new JLabel("Password:");
		
		var nameField = new JTextField(15);//15 characters long
		var passField = new JTextField(15);
		
		var addButton = new JButton("Save");
		
		/*setLayout(new BorderLayout());
		add(formLabel, BorderLayout.NORTH);
		add(nameLabel, BorderLayout.CENTER);*/
		
		setLayout(new GridBagLayout());
		var gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.gridwidth = 2;
		add(formLabel, gc);
		gc.gridwidth = 1;
		
		gc.gridy++;
		add(nameLabel, gc);
		
		gc.gridx = 1;
		add(nameField, gc); 
		
		gc.gridx = 0;
		gc.gridy++;
		add(passLabel, gc);
		
		gc.gridx = 1;
		add(passField, gc);
		
		gc.gridy++;
		add(addButton, gc);
		
	}

}
