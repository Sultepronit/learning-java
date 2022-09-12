package Database0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import application.PlayMP3;

public class Word {
	private int id;
	
	private String[] mainWritings;
	private boolean isUsed;
	private String[] additionalWritings;
	private String[] mainTranscriptions;
	//private int[] isMuted;
	private HashSet<Integer> isMuted = new HashSet<>();
	private String[] additionalTranscriptions;
	private String translation;
	private int example;
	
	public Word(String mw, boolean iu, String aw, String mt, String at, String tr, int ex) {
		mainWritings = mw.split(", ");
		isUsed = iu;
		additionalWritings = aw.split(", ");
		if(additionalWritings[0] == "") additionalWritings = new String[0];
		mainTranscriptions = mt.split(", ");
		additionalTranscriptions = at.split(", ");
		if(additionalTranscriptions[0] == "") additionalTranscriptions = new String[0];
		translation = tr;
		example = ex;
	}
	
	public String getWritings() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < mainWritings.length; i++) {
			result.append(mainWritings[i]);
			if(i + 1 == mainWritings.length) break;
			result.append("　");
		}
		if(!isUsed) {
			result.insert(0, "<span style='color:blue'>");
			result.append("</span>");
		}
		if(additionalWritings.length > 0) {
			result.append("　<span style='color:gray'>");
			for(int i = 0; i < additionalWritings.length; i++) {
				result.append(additionalWritings[i]);
				if(i + 1 == additionalWritings.length) break;
				result.append("　");
			}
			result.append("</span>");
		}
		return result.toString();
	}
	
	//public char[] getAllKanji() {
	public LinkedHashSet<Character> getAllKanji() {
		var builder = new StringBuilder();
		for(int i = 0; i < mainWritings.length; i++) {
			builder.append(mainWritings[i]);
		}
		for(int i = 0; i < additionalWritings.length; i++) {
			builder.append(additionalWritings[i]);
		}
		//builder.replace(id, example, translation)
		//builder.toString().replace("[あ-ん]", "");
		//return builder.toString().replace("[あ-゜]", "").toCharArray();
		//return builder.toString().replace("る", "").toCharArray();
		var string =  builder.toString();
		//builder.delete(id, example);
		var set = new LinkedHashSet<Character>();
		var builder2 = new StringBuilder();
		for(char c: string.toCharArray()) {
			//if(c > 'ん') builder2.append(c);
			//if(c > '゜') set.add(c);
			//if(c > 'ヶ') set.add(c);
			if(c > 'ー') set.add(c);
			
		}
		var array = builder2.toString().toCharArray();
		return set;
		
	}
	
	public String getTranscriptions() {
		var result = new StringBuilder();
		for(int i = 0; i < mainTranscriptions.length; i++) {
			result.append(mainTranscriptions[i]);
			if(i + 1 == mainTranscriptions.length) break;
			result.append("　");
		}
		if(additionalTranscriptions.length > 0) {
			result.append("　(");
			for(int i = 0; i < additionalTranscriptions.length; i++) {
				result.append(additionalTranscriptions[i]);
				if(i + 1 == additionalTranscriptions.length) break;
				result.append("/");
			}
			result.append(")");
		}
		return result.toString();
	}
	
	public void say() {
		int length = mainTranscriptions.length - isMuted.size();
		String[] list = new String[length];
		for(int i = 0, j = 0; i < mainTranscriptions.length; i++) {
			list[j++] = "https://assets.languagepod101.com/dictionary/japanese/audiomp3.php?kana="
					+ mainTranscriptions[i] + "&kanji=" + mainWritings[0];
		}
		PlayMP3.play(list);
	}

	@Override
	public String toString() {
		return "{" + id + "\n" + Arrays.toString(mainWritings) + "\n" + isUsed
				+ "\n" + Arrays.toString(additionalWritings) + "\n"
				+ Arrays.toString(mainTranscriptions) + "\n"
				+ Arrays.toString(additionalTranscriptions) + "\n" + translation + "\n" + example
				+ "}";
	}
	
}
