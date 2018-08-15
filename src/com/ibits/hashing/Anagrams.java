package com.ibits.hashing;

/*
 * https://www.interviewbit.com/problems/anagrams/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Anagrams {

	public static void main(String[] args) {
		//String strings[] = {"cat","dog", "god", "tca"};
		//String strings[] = {"caat", "taac", "dog", "god", "acta"};
		String strings[] = {
				"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba",
				"abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa",
				"babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab",
				"bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb",
				"abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab",
				"aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba",
				"abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa",
				"aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb" };
		List<String> A = new ArrayList<>();
		for (String str : strings)
			A.add(str);

		ArrayList<ArrayList<Integer>> result = anagrams(A);
		System.out.println(result.size());
		for (ArrayList i : result) {
			System.out.print("[");
			for (Object j : i) {
				System.out.print(j + ",");
			}
			System.out.print("],");
		}
	}

	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		int n = A.size();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < n ; i++) {
			ArrayList<Integer> group = new ArrayList<>();
			//System.out.println(visited.contains(i+1) +  " " + i);
			if (!visited.contains(i + 1)) {
				group.add(i + 1);
				visited.add(i + 1);
			}
			for (int j = i + 1; j < n; j++) {
				boolean isAnagram = isAnagram(A.get(i), A.get(j));
				if (isAnagram) {
					if (!visited.contains(j + 1)) {
						group.add(j + 1);
						visited.add(j + 1);
					}
				}
			}
			if (group.size() != 0)
				result.add(group);

		}
		return result;
	}

	public static boolean isAnagram(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		if (m != n)
			return false;
		int[] countChars = new int[26];
		// Initialize with zero
		for (int i = 0; i < 26; i++)
			countChars[i] = 0;

		for (int i = 0; i < n; i++) {
			countChars[str1.charAt(i) - 'a'] += 1;
			countChars[str2.charAt(i) - 'a'] -= 1;
		}

		for (int num : countChars) {
			if (num != 0)
				return false;
		}
		return true;
	}

}
