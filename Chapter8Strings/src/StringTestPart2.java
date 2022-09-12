import java.util.Scanner;

/**
 * @author yoderr
 *  This file serves as a demonstration file for our class using
 *  static methods, String objects and methods, and some loop review.
 *  
 *  Note: static methods do not require an object to be constructed
 *  in order to access them.  (Consider Math.random() or Math.sqrt(x)
 *  or System.out.println()... all which are static methods accessible 
 *  any time and anywhere.
 *  
 *  Non-static methods are only accessible WITHIN a class's code, or through
 *  dot-notation following the creation of an object with the defined 
 *  method in its repertoire.
 *  
 *  Because main() is designated as a static method, non-static methods
 *  cannot be invoked directly without an object to serve as the "caller".
 */
public class StringTestPart2 {

	/**
	 * Ch08 #12 Implementation of String class indexOf(ch,fromPos):
	 * @param ch   Char to be found.
	 * @param fromPos Start looking for ch at this position.
	 * @return pos of ch, if it occurs in String at or after fromPos;  
	 * 		-1 if not in String
	 */
	public static String str = "War Eagles forever!";
	
	public static int indexOf(String target, int fromPos) {
		
		return -1;
	}

	/**
	 * Ch08 #15
	 * @param str - given String object
	 * @return true, if only digits appear within str; false otherwise
	 */
	public static boolean hasOnlyDigits(String str) {
		try{Integer.parseInt(str);}
		catch(NumberFormatException e){ return false;}
		return true;
	}
	/**
	 * Ch08 #18a
	 * Palindromes are spelled the same backwards and forwards.
	 * @param word
	 * @return true, if word is a Palindrome; false otherwise
	 */
	public static boolean isPalindrome(String word) {
		String back="";
		for(int i=0;i<word.length()/2;i++){
			back+=word.charAt(word.length()-1-i);
		}
		return back.equals(word.substring(0,word.length()/2));
	}

	/**
	 * Ch08 #20  pg. 233 JMAP
	 * @param isbn
	 * @return true, if isbn is valid according to the guidelines
	 * establish a hold variable, add every digit to the hold variable and multiply every other digit by 3 (using parseInt()),
	 * then decide whether or not the end value is divisible by 10
	 */
	public static boolean isValidISBN(String isbn) {
		int hold=0;
		try{for(int i=0;i<isbn.length()-1;i+=2){
			hold=hold+Integer.parseInt(""+isbn.charAt(i))+Integer.parseInt(""+isbn.charAt(i+1))*3;
		}
		return hold%10==0;//Integer.parseInt(""+isbn.charAt(isbn.length()-1))==0;
	}
	catch(NumberFormatException e){return false;}
	}

	/**
	 * Ch08 #22  Shuffle rearranges all of the characters in
	 * word in random order. The method uses the StringBuffer
	 * class to assist in this process and Math.random().
	 * 
	 * swaps the last untouched character in the StringBuffer and a random character, loops until the entire StringBuffer is randomized
	 */
	public static String shuffle(String word) {
		StringBuffer str=new StringBuffer(word);
		char hold;
		int rand;
		for(int n=str.length();n>1;n--){
			rand=(int)(Math.random()*n);
			hold=str.charAt(rand);
			str.setCharAt(rand, str.charAt(n-1));
			str.setCharAt(n-1,hold);
		}
		return str.toString();
	}


	/**
	 * This method receives a String and counts the number of times the target
	 * appears within it.
	 * 
	 * For example, "Fred, Josie, Fritz, Anna, Carla, Joe" with target ", " would 
	 * yield 5.
	 * 
	 * @param str - the String given to be tokenized or parsed
	 * @param target - the marker, possibly longer than 1, to be counted
	 * @return an int representing the number of times target was found
	 */
	public static int numOccurrences(String str, String target) {
		int spot=str.indexOf(target);
		int count=0;
		while(spot!=-1){
			spot=indexOf(target, spot+target.length());
			count++;
		}
		return count;
	}
	

	

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String input;   //For use if input required for a problem to be tested.

		System.out.println("StringMethods Part 2:  loops and static! ");

		System.out.println();
		System.out.print("Enter a string: ");
		input = keyboard.nextLine();
		System.out.println(shuffle(input));
		//System.out.println("Looking for the char 'E' in phrase 'War Eagles Forever!'" + indexOf('W', 0));
		
		//System.out.println("Is " + str + "a palindrome?" + isPalindrome(str));
		
		//Do "cool"? stuffs... Test each method-- perhaps multiple times?
		
		
		
		keyboard.close();
	}

}
