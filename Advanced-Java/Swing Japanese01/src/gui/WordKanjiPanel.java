package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.PlayMP3;

class GetKey implements KeyListener {
	public void keyTyped(KeyEvent e) {
		System.out.print(e.getKeyChar());
		//WordKanjiPanel.changeContents0();
		WordPanel.changeContents0();
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}

public class WordKanjiPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//public static JLabel basicLabel = new JLabel("Progres...");
	public static JLabel wordLabel = new JLabel("word");
	public static JLabel transcriptionLabel = new JLabel("");
	public static JLabel translationLabel = new JLabel("");
	
	public WordKanjiPanel() {
		//setBackground(Color.white);
		
		var getKey = new GetKey();
		
		var basicLabel = new JLabel("<html>"
				+ "<p style='padding: 5px; background-color:#eeeeee'>"
				+ "Progres...</p></html>");
		basicLabel.setFocusable(true);
		basicLabel.addKeyListener(getKey);
		//basicLabel.addKeyListener(this);
		
		/*basicLabel.setBackground(Color.YELLOW);
		basicLabel.setForeground(Color.red);*/
		
		//var wordLabel = new JLabel("word");
		
		/*setLayout(new BorderLayout());
		add(basicLabel, BorderLayout.PAGE_START);
		var wordPanel = new WordPanel();
		//add(wordPanel, BorderLayout.PAGE_END);
		add(wordPanel, BorderLayout.CENTER);*/
		
		setLayout(new GridBagLayout());
		var gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.insets = new Insets(0,20,0,20);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(basicLabel, gc);
		
		
		gc.weightx = 3;
		gc.fill = GridBagConstraints.HORIZONTAL;
		//gc.insets = new Insets(0,20,0,20);
		//gc.anchor = GridBagConstraints.CENTER;
		gc.gridy++;
		var whitePanel = new JPanel();
		whitePanel.setBackground(Color.white);
		whitePanel.setBorder(BorderFactory.createEtchedBorder());
		whitePanel.setLayout(new GridBagLayout());
		add(whitePanel, gc);
		
		var nc = new GridBagConstraints();
		nc.gridx = 0;
		nc.gridy = 0;
		nc.fill = GridBagConstraints.HORIZONTAL;
		var wordPanel = new WordPanel();
		whitePanel.add(wordPanel, nc);
		/*var wordPanel = new WordPanel();
		add(wordPanel, gc);*/
		
		nc.gridy++;
		nc.weightx = 3;
		//nc.fill = GridBagConstraints.HORIZONTAL;
		var kanjiPanel = new KanjiPanel();
		whitePanel.add(kanjiPanel, nc);
		
		/*whitePanel.add(new JLabel("sdfsdfsdfsdfdf"));
		whitePanel.add(new JLabel("sdfsdfsdfsdfdf"));
		whitePanel.add(new JLabel("sdfsdfsdfsdfdf"));
		whitePanel.add(new JLabel("sdfsdfsdfsdfdf"));
		whitePanel.add(new JLabel("sdfsdfsdfsdfdf"));
		whitePanel.add(new JLabel("korekaradekakenakerebanarimasen"));
		whitePanel.add(new JLabel("korekaradekakenakerebanarimasen"));
		whitePanel.add(new JLabel("korekaradekakenakerebanarimasen"));
		whitePanel.add(new JLabel("korekaradekakenakerebanarimasen"));
		whitePanel.add(new JLabel("korekaradekakenakerebanarimasen"));*/
		
		gc.gridy++;
		//gc.gridx++;
		//gc.gridwidth = 2;
		gc.weighty = 2;
		//gc.weightx = 2;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		add(new JLabel("#####"), gc);
		
	}

}
