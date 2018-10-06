package com.ibits.trie;

/*
 * https://www.geeksforgeeks.org/trie-insert-and-search/
 */

public class TrieOperations {
	static TrieNode root;

	public static void main(String[] args) {
		root = new TrieNode();
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };
		for (int i = 0; i < keys.length; i++)
			insertKey(keys[i]);
		// searchKey for different keys
		if (searchKey("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (searchKey("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (searchKey("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (searchKey("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);
	}

	private static void insertKey(String str) {
		TrieNode p = root;

		int length = str.length();
		for (int i = 0; i < length; i++) {
			int index = str.charAt(i) - 'a';
			if (p.children[index] == null)
				p.children[index] = new TrieNode();
			p = p.children[index];
		}

		// mark the last word
		p.isEnd = true;
	}

	private static boolean searchKey(String str) {
		TrieNode p = root;

		int length = str.length();
		for (int i = 0; i < length; i++) {
			int index = str.charAt(i) - 'a';
			if (p.children[index] == null)
				return false;
			p = p.children[index];
		}

		return (p != null && p.isEnd == true);
	}

}
