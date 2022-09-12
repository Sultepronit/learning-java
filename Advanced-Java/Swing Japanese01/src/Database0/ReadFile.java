package Database0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	private static File db = new File("Test.txt");
	//public static Word words1 = new
	public static ArrayList<Word> words1 = new ArrayList<>();
	
	public ReadFile() {
		read();
	}
	
	//public static void main (String[] args) {
	private static void read() {
		System.out.println("Helllllo!");
		try {
			Scanner scanner = new Scanner(db);
			
			/*boolean isUser = scanner.nextBoolean();
			scanner.nextLine();
			System.out.println(isUser);
			String mainWritings = scanner.nextLine();
			System.out.println(mainWritings);
			String additionalWritings = scanner.nextLine();
			System.out.println(additionalWritings);
			String mainTranscriptions = scanner.nextLine();
			System.out.println(mainTranscriptions);
			String additionalTranscriptions = scanner.nextLine();
			System.out.println(additionalTranscriptions);
			String translation = scanner.nextLine();
			System.out.println(translation);*/
			/*Word word = new Word(mainWritings, isUser, additionalWritings, mainTranscriptions, additionalTranscriptions, translation);
			System.out.println(word);*/
			while(scanner.hasNext()) {
				/*String line = scanner.nextLine();
				System.out.println(line);*/
				boolean isUser = scanner.nextBoolean();
				scanner.nextLine();
				String mainWritings = scanner.nextLine();
				String additionalWritings = scanner.nextLine();
				String mainTranscriptions = scanner.nextLine();
				String additionalTranscriptions = scanner.nextLine();
				String translation = scanner.nextLine();
				Word word = new Word(mainWritings, isUser, additionalWritings, mainTranscriptions, additionalTranscriptions, translation);
				//System.out.println(word);
				words1.add(word);
			}
			System.out.println(words1.get(333));
			
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
