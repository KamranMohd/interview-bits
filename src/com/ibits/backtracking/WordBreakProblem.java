package com.ibits.backtracking;

/*
 * https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
 */
public class WordBreakProblem {

	public static void main(String[] args) {
		String words[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
				  "cream", "icecream", "man", "go", "mango", "and"};
		//String sentence = "ilikesamsungmobile";
		String sentence = "ilikeicecreamandmango";
		printValidSentenceWithWords(words, sentence, "", 0);
	}

	private static void printValidSentenceWithWords(String[] words, String sentence, String currentStr, int currentPos) {
		//	Base condition : If the currentPos equal to the length of the sentence,
		//	then print and return
		//System.out.println(currentPos +  " " + sentence.length() + " " + currentStr);
		if(currentPos==sentence.length()) {
			System.out.println(currentStr);
			return;
		}
		
		//	Check for all the words in the word array
		for(int i=0;i<words.length;i++) {
			//	Check if the current word in words is found in the string
			int len = words[i].length();
			if((currentPos+len) <= sentence.length()) {
				if(sentence.substring(currentPos, currentPos+len).equals(words[i])) {
					String original = currentStr;
					currentStr += words[i] + " ";
					currentPos += len;
					printValidSentenceWithWords(words, sentence, currentStr, currentPos);
					currentStr = original;
					currentPos -= len;
				}
			}
			
		}
	}

}
