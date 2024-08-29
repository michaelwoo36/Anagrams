import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of the dictionary file");
		File txt = new File(input.nextLine());
		Scanner dictionaryMaker = new Scanner(txt);
		List<String>dictionary = new ArrayList<String>();
		while(dictionaryMaker.hasNextLine()) {
			String line = dictionaryMaker.nextLine();
			Scanner lineScanner = new Scanner(line);
			while(lineScanner.hasNext()) {
				dictionary.add(lineScanner.nextLine());
			}
		}
		AnagramSolver solve = new AnagramSolver(dictionary);
		System.out.println("Enter your phrase:"); 
        String phrase = input.nextLine();
		
		
		System.out.println("Max words to include (0 for no max)");
		int num = input.nextInt();
	    solve.print(phrase, num);
	}

}
