package com.ibits.hashing;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */
public class MaxSubstringWithNoRepeatingCharacter {

	public static void main(String[] args) {
		//String str = "geeksforgeeks";
		String str = "ABDEFGABEF";
		int n = str.length();
		System.out.println(longestSubstringWithoutRepeatingCharacters(str, n));

	}

	private static int longestSubstringWithoutRepeatingCharacters(String str, int n) {
		int maxLength = Integer.MIN_VALUE;
		// Create an array that will hold the last index of a character
		// A hashmap can also be used
		int lastIndex[] = new int[256];

		// Initialize the array with -1 which means the character is not
		// yet encountered in the string
		Arrays.fill(lastIndex, -1);

		lastIndex[str.charAt(0)] = 0;
		int currentLength = 1;
		
		String longestString = "";

		for (int i = 1; i < n; i++) {
			int index = lastIndex[str.charAt(i)];

			// if the character is not present, or it's last index is outside of
			// our current substring, then increase the current length
			if (index == -1 || i - index > currentLength)
				currentLength++;

			// The repeating character is present inside the current window
			else {
				// Change the max length
				if(currentLength > maxLength) {
					maxLength = currentLength;
					//	Store the longest string
					longestString = str.substring(index, i);
				}
				

				// Shrink the window/substring by starting from the next character
				// after the previous index of the character
				currentLength = i - index;
			}
			
			//	Update the index of the character visited
			lastIndex[str.charAt(i)] = i;
		}
		System.out.println("Longest substring without repeating characters : " + longestString);
		return maxLength;
	}

}
