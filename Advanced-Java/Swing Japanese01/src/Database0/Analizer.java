package Database0;

import java.util.Arrays;
import java.util.Random;

public class Analizer {

	public static void main(String[] args) {
		Random random = new Random();
		int x = random.nextInt(WordArray0.words0.length);
		//System.out.println(WordArray0.words0[x][0][0]);
		var wordList = Arrays.asList(WordArray0.words0[x][0]);
		//System.out.println(wordList);
		var transcList = Arrays.asList(WordArray0.words0[x][1]);
		//System.out.println(transcList);
		
		//for(int i = 0; i < 100; i++) {
		for(int i = 0; i < WordArray0.words0.length; i++) {
			wordList = Arrays.asList(WordArray0.words0[i][0]);
			//System.out.println(wordList);
			var mainWritings = new StringBuilder();
			var isUsed = false;
			var isAdditional = false;
			var isBrackets = false;
			int j = 0;
			/*for(; j < WordArray0.words0[i][0].length; j++) {
				if(WordArray0.words0[i][0][j] == "[") {
					isUsed = true;
					System.out.print("[] ");
					continue;
				}
				if(WordArray0.words0[i][0][j] == "1") {
					isBrackets = true;
					continue;
				}
				mainWritings.append(WordArray0.words0[i][0][j]);
				
				if(j + 1 == WordArray0.words0[i][0].length) break;
				if(WordArray0.words0[i][0][j + 1] == "(") {
					isAdditional = true;
					break;
				}
				mainWritings.append(", ");
			}
			if(isBrackets) mainWritings.insert(0, "<");
			System.out.println(mainWritings);
			
			if(isAdditional) {
				isBrackets = false;
				System.out.print("() ");
				j += 2;
				var additionalWritings = new StringBuilder();
				for(; j < WordArray0.words0[i][0].length; j++) {
					if(WordArray0.words0[i][0][j] == "1") {
						isBrackets = true;
						continue;
					}
					additionalWritings.append(WordArray0.words0[i][0][j]);
					
					if(j + 1 == WordArray0.words0[i][0].length) break;
					additionalWritings.append(", ");
				}
				if(isBrackets) additionalWritings.insert(0, "<");
				System.out.println(additionalWritings);
			}*/
			/////////////////transcription
			transcList = Arrays.asList(WordArray0.words0[i][1]);
			System.out.println(transcList);
			isAdditional = false;
			var mainTranscriptions = new StringBuilder();
			j = 0;
			for(; j < WordArray0.words0[i][1].length; j++) {
				if(WordArray0.words0[i][1][j] == "1") {
					mainTranscriptions.append("m");
					continue;
				}
				
				mainTranscriptions.append(WordArray0.words0[i][1][j]);
				
				if(j + 1 == WordArray0.words0[i][1].length) break;
				if(WordArray0.words0[i][1][j + 1] == "(") {
					isAdditional = true;
					break;
				}
				mainTranscriptions.append(", ");
			}
			System.out.println(mainTranscriptions);
			
			System.out.println();
			
		}
	}

}
