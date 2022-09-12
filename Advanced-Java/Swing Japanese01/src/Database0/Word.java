package Database0;

import java.util.Arrays;
import java.util.HashSet;

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
	
	public Word(String mw, boolean iu, String aw, String mt, String at, String tr) {
		mainWritings = mw.split(", ");
		isUsed = iu;
		additionalWritings = aw.split(", ");
		mainTranscriptions = mt.split(", ");
		additionalTranscriptions = at.split(", ");
		translation = tr;
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
