import java.util.*;
public class AnagramSolver {
	
	private List<String>dictionary;
	private List<String>chosenWords;

	AnagramSolver(List<String> list){
		dictionary = list;	
	}
	
	void print(String phrase, int num) {
		
		if(phrase.isEmpty() && chosenWords.size() == num) {
			System.out.print(chosenWords);
		}
		for(String i: dictionary) {
			LetterInventory inventory = new LetterInventory(phrase);
			LetterInventory dicWordInventory = new LetterInventory(i);
			LetterInventory difference = inventory.subtract(dicWordInventory);
			if(difference != null) {
				chosenWords.add(i);
				print(difference.toString(), num);
			}	
		}
	}	
}
