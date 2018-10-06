package com.ibits.trie;

/*
 * https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
 */
import java.util.ArrayList;

class TrieNodeFreq {
	static final int MAX = 256;
	TrieNodeFreq[] children = new TrieNodeFreq[MAX];
	int freq;

	public TrieNodeFreq() {
		freq = 1;
		for (int i = 0; i < MAX; i++)
			children[i] = null;
	}
}

public class ShortestUniquePrefix {
	static TrieNodeFreq root;
	static final int MAX = 256;
	// Maximum length of an input word
	static final int MAX_WORD_LEN = 500;
	static ArrayList<String> result = new ArrayList<>();

	public static void main(String[] args) {
		root = new TrieNodeFreq();
		root.freq = 0;
		String arr[] = { "Zebra", "dog", "duck", "dot" };
		int n = arr.length;
		// System.out.println((char)(23 + 'a'));
		for (int i = 0; i < n; i++)
			insertKey(arr[i]);

		char[] prefix = new char[MAX_WORD_LEN];
		// findPrefixes(root, prefix, 0);
		// System.out.println(result);
		for (int i = 0; i < n; i++)
			findPrefixesForString(arr[i]);

	}

	public static void findPrefixes(TrieNodeFreq root, char[] prefix, int ind) {

		if (root == null)
			return;
		if (root.freq == 1) {
			prefix[ind] = '\0';
			result.add(new String(prefix));
			/*
			 * int i = 0; while (prefix[i] != '\0')
			 * System.out.print(prefix[i++]); System.out.println();
			 */
			// System.out.println(new String(prefix));
			return;
		}
		for (int i = 0; i < MAX; i++) {
			if (root.children[i] != null) {
				prefix[ind] = (char) i;
				// System.out.println(ind + " " + new String(prefix));
				findPrefixes(root.children[i], prefix, ind + 1);
			}

		}
	}

	public static void findPrefixesForString(String str) {
		TrieNodeFreq p = root;
		int j = 0;
		char[] prefix = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i);
			if (p.children[index] != null) {
				prefix[j++] = (char) index;
				if (p.children[index].freq == 1)
					break;
				p = p.children[index];
			}
		}
		System.out.println("*" + new String(prefix) + "*");
	}

	public static void insertKey(String str) {
		int n = str.length();
		TrieNodeFreq p = root;
		for (int i = 0; i < n; i++) {
			int index = str.charAt(i);
			if (p.children[index] == null)
				p.children[index] = new TrieNodeFreq();
			else
				p.children[index].freq++;
			p = p.children[index];
		}
	}

}
