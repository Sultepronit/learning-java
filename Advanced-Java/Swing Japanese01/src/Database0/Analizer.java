package Database0;

import java.util.Arrays;
import java.util.Random;

public class Analizer {

	public static void main(String[] args) {
		Random random = new Random();
		int x = random.nextInt(WordArray0.words0.length);
		//System.out.println(WordArray0.words0[x][0][0]);
		var wordList = Arrays.asList(WordArray0.words0[x][0]);
		System.out.println(wordList);
		var transcList = Arrays.asList(WordArray0.words0[x][1]);
		System.out.println(transcList);
	}

}
