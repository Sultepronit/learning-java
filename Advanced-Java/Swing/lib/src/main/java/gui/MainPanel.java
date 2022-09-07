package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public MainPanel() {
		//setBackground(Color.YELLOW);
		
		var formLabel = new JLabel("Add User");
		formLabel.setFont(new Font("URW Bookman", Font.PLAIN, 30));
		
		var nameLabel = new JLabel("Name:");
		var passLabel = new JLabel("Password:");
		
		var nameField = new JTextField(15);//15 characters long
		//nameField.setFont(new Font("Serif", 20, 40));
		var passField = new JTextField("媒鳥");
		//passField.setFont(new Font("FreeSans", 40, 40));
		
		var addButton = new JButton("Save");
		
		/*setLayout(new BorderLayout());
		add(formLabel, BorderLayout.NORTH);
		add(nameLabel, BorderLayout.CENTER);*/
		
		setLayout(new GridBagLayout());
		var gc = new GridBagConstraints();
		
		var rightPad = new Insets(0,0,0,10);
		var zeroPad = new Insets(0,0,0,0);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1; 
		
		gc.weighty = 30;
		gc.gridwidth = 2;
		add(formLabel, gc);
		
		gc.gridwidth = 1;
		gc.weighty = 0.1;
		
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = rightPad;
		add(nameLabel, gc);
		gc.insets = zeroPad;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc); 
		
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = rightPad;
		add(passLabel, gc);
		gc.insets = zeroPad;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(passField, gc);
		
		gc.weighty = 30;
		
		gc.gridy++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(addButton, gc);
		
	}

}
