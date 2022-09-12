package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Database0.ReadFile;
import Database0.WordArray0;

public class WordPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//public static JLabel wordLabel = new JLabel("word");
	public static JLabel kanjiLabel = new JLabel("");
	public static JLabel gifLabel = new JLabel("");
	public static JLabel wordLabel = new JLabel("");
	public static JLabel transcriptionLabel = new JLabel("");
	public static JLabel translationLabel = new JLabel("");
	
	public WordPanel() {
		setBackground(Color.white);
		//setBorder(BorderFactory.createEtchedBorder());
		
		setLayout(new GridBagLayout());
		var gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.weightx = 2;
		gc.insets = new Insets(10,30,0,0);
		//gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		add(kanjiLabel, gc);
		kanjiLabel.setForeground(Color.black);
		kanjiLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		
		gc.insets = new Insets(0,0,0,0);
		gc.gridy++;
		add(gifLabel, gc);
		gc.insets = new Insets(0,30,0,0);

		gc.gridy++;
		//gc.weighty = 1;
		add(wordLabel, gc);
		Font word1 = new Font("Arial", Font.PLAIN, 100);
		wordLabel.setFont(word1);
		//wordLabel.setBackground(Color.YELLOW);
		wordLabel.setForeground(Color.black);
		
		gc.insets = new Insets(0,40,0,0);
		gc.gridy++;
		//gc.weighty = 1;
		transcriptionLabel.setFont(new Font("Noto Serif CJK SC", Font.PLAIN, 40));
		//transcriptionLabel.setFont(new Font("Noto Sans CJK JP", Font.PLAIN, 30));
		//transcriptionLabel.setFont(new Font("FreeSerif", Font.PLAIN, 40));
		add(transcriptionLabel, gc);
		transcriptionLabel.setForeground(Color.black);
		
		gc.gridy++;
		//gc.fill = GridBagConstraints.HORIZONTAL;
		translationLabel.setFont(new Font("Noto Serif CJK SC", Font.PLAIN, 50));
		add(translationLabel, gc);
		translationLabel.setForeground(Color.black);
		
	}
	
	public static void changeContents0() {
		//System.out.println(WordArray0.words0[12][0][0]);
		Random random = new Random();
		int x = random.nextInt(WordArray0.words0.length);
		System.out.println(ReadFile.words1.get(x).getWritings());
		
		//char[] kanjis = ReadFile.words1.get(x).getAllKanji();
		var kanjis = ReadFile.words1.get(x).getAllKanji();
		/*var builder = new StringBuilder();
		builder.append(kanjis);*/
		kanjiLabel.setText(kanjis.toString());
		String gifs = kanjiToGif(kanjis);
		System.out.println(gifs);
		gifLabel.setText("<html>" + gifs + "</html>");
		
		//"<img src=\"http://www.yosida.com/images/kanji/984C.gif\">"
		//wordLabel.setText("<html><p style='font-size:4em'>" + word + "</html>");
		char c = ReadFile.words1.get(x).getWritings().charAt(0);
		//System.out.println(c);
		//System.out.println(Integer.toHexString((int) c));
		String sc = Integer.toHexString((int) c).toUpperCase();
		//System.out.println("http://www.yosida.com/images/kanji/" + sc + ".gif");
		wordLabel.setText("<html>"
				//+ "<img src='http://www.yosida.com/images/kanji/" + sc + ".gif'>"
				//+ "<img src='http://www.yosida.com/images/kanji/8336.gif'>"
				//+ "<p style='font-family:\"Noto Serif CJK JP\"; text-align:center'>"
				+ "<p style='font-family:\"Noto Serif CJK JP\";'>"
				//+ "<p style='font-family:\"Noto Serif CJK JP\"; font-size:7em; text-align:center'>"
				//+ "<p style='font-family:\"VL PGothic\"; font-size:7em; text-align:center'>"
				//+words[i][0] + "</p></html>");
				//+WordArray0.words0[x][0][0] + "</p></html>");
				+ ReadFile.words1.get(x).getWritings() + "</p></html>");
				
		//wordLabel.setBackground(Color.YELLOW);
		//wordLabel.setForeground(Color.RED);VL PGothic
		transcriptionLabel.setText(ReadFile.words1.get(x).getTranscriptions());
		//translationLabel.setText("<html><p style='font-family:\"FreeSerif\"; text-align:center; background-color:yellow '>"
		translationLabel.setText("<html><p style='font-family:\"FreeSerif\" '>"
		//translationLabel.setText("<html>"
		+ WordArray0.words0[x][2][0] + "</p><p>-</p></html>");
		//+ WordArray0.words0[x][2][0] + "</p><p style='width:1500'>wwwwwwwwwwwsdfudwwwwwwwwwwwwwwwwd</p></html>");
		//+ WordArray0.words0[x][2][0] + "</p><p style='color:white'>kasd fasdfa sdfasdfaswwwwwwwwwwwdfasdfasdfasdfudwwwwww wwwwwww wwwd</p></html>");
		//translationLabel.setText(WordArray0.words0[x][2][0]);
		ReadFile.words1.get(x).say();
	}
	
	private static String kanjiToGif(Set<Character> set) {
		var result = new StringBuilder();
		for(var c: set) {
			String code = Integer.toHexString((int) c).toUpperCase();
			result.append("<img src='http://www.yosida.com/images/kanji/" + code + ".gif'>");
		}
		return result.toString();
	}

}
