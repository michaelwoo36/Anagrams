
public class LetterInventory {
	
	private int size;
	private int[]letters = new int[length];
	
	public static final int length = 26;
	
	//Post: Adds count of each letter to array
	public LetterInventory(String word) {
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != ' ') {
			char letter = Character.toLowerCase(word.charAt(i));
			letters[letter-97]++;
			size++;
			}
		}
	}
	
	//Pre: char alphabetic (throws IllegalArgumentException if not)
	//Post: returns count for letter
	public int get(char letter) {
		
		if((letter - 97) > 25 || (letter - 97) < 0) {
			throw new IllegalArgumentException("Enter alphabetical Char");
		}
		return letters[Character.toLowerCase(letter)-97];
	}
	
	//Pre: Alphabetic Char and non-negative value for int (throws IllegalArgumentException if not)
	//Post: Assigns array letter index to value
	public void set(char letter, int value) {
		
		if((letter - 97) > 25 || (letter - 97) < 0) {
			throw new IllegalArgumentException("Enter alphabetical Char");
		}
		else if(value < 0) {
			throw new IllegalArgumentException("Enter non-negative value");
		}
		else {
			size += (value - letters[Character.toLowerCase(letter) - 97]);
			letters[Character.toLowerCase(letter)-97] = value;
		}
		
	}
	
	//Post: returns size
	public int size() {
		
		return size;
	}
	
	//Post: returns true if letters array is empty
	public boolean isEmpty() {
		
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Post: Puts letters array of integers into string of char
	public String toString() {
		
		return toStringHelper(letters);
	}
	
	//Post: adds array index values of like char values
	public LetterInventory add(LetterInventory other) {
		
		String sum = toString() + other.toString();
		return new LetterInventory(sum);
	}
	
	//Post: subtracts array index values of like char values
	public LetterInventory subtract(LetterInventory other) {
		
		int[] sum = letters;
		for(int i = 0; i < length; i++) {
			if(sum[i] >= other.letters[i]) {
				sum[i] -= other.letters[i];
			}
			else {
				return null;
			}
		}
		
		return new LetterInventory(toStringHelper(sum));
	
	}
	
	// puts array of integers into string of alphabetical chars
	private String toStringHelper(int[]arr) {
		
		String string = "";
		for(int i = 0; i < arr.length; i++) {
			for(int k = 0; k < arr[i]; k++) {
				
				string += (char) (i+97);
			}
		}
		
		return string;
	}
}
