package com.ibits.trie;

public class TrieNode {
	final static int ALPHABET_SIZE = 26;
	TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	boolean isEnd;

	public TrieNode() {
		isEnd = false;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
	}
}