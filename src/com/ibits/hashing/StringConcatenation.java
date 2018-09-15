package com.ibits.hashing;

/*
 * https://www.geeksforgeeks.org/find-starting-indices-substrings-string-s-made-concatenating-words-listl/
 */
import java.util.ArrayList;
import java.util.HashMap;

public class StringConcatenation {

	public static void main(String[] args) {
		//String arr[] = { "foo", "bar" };
		String arr[] = { "aaa", "aaa", "aaa", "aaa", "aaa" };
		// String arr[] = { "cabccbbbc", "abbccabbc", "bbbcbbbaa", "acbaabcab",
		// "ccacabccb", "bbacaabca", "acacbaacb",
		// "aabbcccab", "ccccbbcaa" };// , "baaccaabc" };
		// String arr[] = {"cat", "ate", "bat"};
		// String arr[] = {"ab", "ab", "cd"};
		ArrayList<String> list = new ArrayList<String>();
		for (String str : arr)
			list.add(str);

		//String string = "barfoothefoobarman";
		String string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		// String string = "acaaacbcbccbaabaccabcbbcaaccbbbbcbabaacbbcbccababb";
		// String string = "catbatatecatatebat";
		// String string = "abcdababcd";
		ArrayList<Integer> result = new ArrayList<>();
		getStartingIndices(result, string, list);
		System.out.println(result.toString());

	}

	private static void getStartingIndices(ArrayList<Integer> result, String string, ArrayList<String> list) {
		// Create a hashmap that contains the word and their frequency
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : list) {
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}

		// Get the size of the substring that can be formed using all the words
		// in the list exactly once. All words are of same length
		int word_length = list.get(0).length();
		int num_of_words = list.size();
		int total_length = word_length * num_of_words;

		int string_length = string.length();

		if (total_length > string_length)
			return;

		// Find all the substring of the string of length total_length
		for (int i = 0; i <= string_length - total_length; i++) {
			// Create temporary map and initialize it with the
			// original map
			HashMap<String, Integer> temp_map = new HashMap<>(map);
			int j = i;
			while (j < (i + total_length)) {
				String substring = string.substring(j, j + word_length);
				if (!temp_map.containsKey(substring))
					break;
				else
					temp_map.put(substring, temp_map.get(substring) - 1);
				j += word_length;
			}

			// Check if all the keys are set to zero
			int count = 0;
			for (String key : temp_map.keySet()) {
				if (temp_map.get(key) > 0)
					count++;
			}
			if (count == 0)
				result.add(i);
		}
	}
}