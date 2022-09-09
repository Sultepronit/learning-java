package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
		//gc.gridwidth = 2;
		gc.fill = GridBagConstraints.HORIZONTAL;
		//gc.insets = new Insets(0,20,0,20);
		//gc.anchor = GridBagConstraints.CENTER;
		gc.gridy++;
		var wordPanel = new WordPanel();
		add(wordPanel, gc);
		
		gc.gridy++;
		//gc.gridx++;
		//gc.gridwidth = 2;
		gc.weighty = 2;
		//gc.weightx = 2;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		add(new JLabel("#####"), gc);
		
	}
	
	public static String[][] words = {
			{"怪しい", "あやしい", "сумнівний, підозрілий"},
			{"趣味", "しゅみ", "інтерес, хобі, захоплення"},	
			{"燃える", "もえる", "горіти, палати <i>прям. і перен.</i>"},	
	};
	
	public static void changeContents0() {
		String word = "怪しい";
		String transc = "あやしい";
		String transl = "сумнівний, підозрілий";
		Random random = new Random();
		int i = random.nextInt(3);
		//"<img src=\"http://www.yosida.com/images/kanji/984C.gif\">"
		//wordLabel.setText("<html><p style='font-size:4em'>" + word + "</html>");
		char c = words[i][0].charAt(0);
		System.out.println(c);
		System.out.println(Integer.toHexString((int) c));
		String sc = Integer.toHexString((int) c).toUpperCase();
		System.out.println("http://www.yosida.com/images/kanji/" + sc + ".gif");
		wordLabel.setText("<html>"
				+ "<img src='http://www.yosida.com/images/kanji/" + sc + ".gif'>"
				+ "<img src='http://www.yosida.com/images/kanji/8336.gif'>"
				+ "<p style='font-family:\"Noto Serif CJK JP\"; text-align:center'>"
				//+ "<p style='font-family:\"Noto Serif CJK JP\"; font-size:7em; text-align:center'>"
				//+ "<p style='font-family:\"VL PGothic\"; font-size:7em; text-align:center'>"
				+words[i][0] + "</p></html>");
		//wordLabel.setBackground(Color.YELLOW);
		//wordLabel.setForeground(Color.RED);VL PGothic
		transcriptionLabel.setText(words[i][1]);
		//translationLabel.setText("<html><p style='font-family:\"FreeSerif\" '>"
		translationLabel.setText("<html><p style='color:blue'>"
		+ words[i][2] + "</p></html>");
		//PlayMP3.play();
		PlayMP3.audio("https://assets.languagepod101.com/dictionary/japanese/audiomp3.php?kana="
				+ words[i][1] + "&kanji=" + words[i][0]);
	}

}
