import java.util.*;
public class AnagramSolver {
	
	
	private List<String>chosenWords = new ArrayList<String>();
	private Map<String, LetterInventory> inventories = new HashMap<String, LetterInventory>();

	AnagramSolver(List<String> list){
		for(String i : list) {
			LetterInventory temp = new LetterInventory(i);
			inventories.put(i, temp);
		}
	}
	
	/*void print(String phrase, int num) {
		//prune(phrase);
		recursiveMethod(phrase, num);
	}*/
	
	/*void prune(String phrase) {
		LetterInventory lettersInventory = new LetterInventory(phrase);
		//List<Integer> removeIndexes = new ArrayList<Integer>();
		for(String i: inventories.keySet()) {
			LetterInventory difference = lettersInventory.subtract(inventories.get(i));
			if(difference == null) {
				
			}	
		}
	}*/
	
	void print(String phrase, int num) {
		if(num != 0 && phrase.isEmpty() && chosenWords.size() <= num) {
			System.out.println(chosenWords);
		}
		else if(phrase.isEmpty() && num == 0) {
			System.out.println(chosenWords);
		}
		
		
		for(String i: inventories.keySet()) {
			LetterInventory lettersInventory = new LetterInventory(phrase);
			LetterInventory difference = lettersInventory.subtract(inventories.get(i));
			//System.out.println(phrase + " " + inventories.get(i).toString());
			if(difference != null) {
				chosenWords.add(i);
				print(difference.toString(), num);
			}	
		}
		if(chosenWords.size()>0) {
			chosenWords.remove(chosenWords.size()-1);
		}
	}
}
