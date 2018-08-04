package com.ibits.strings;

public class StrStr {

	public static void main(String[] args) {
		String text = "bbbbbbbbab";
		String pattern = "baba";
		System.out.println(getFirstOccurence(text, pattern));
	}
	
	public static int getFirstOccurence(String text, String pattern) {
		int m = pattern.length(), n = text.length();
		if(m==0 || n==0)
			return -1;
		if(m > n)
			return -1;
		int lps[] = getlps(pattern);
		int i=0,j=0;
		while(i < n) {
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}
			if(j==m) {
				return (i-j);
			}
			else if(i < n && pattern.charAt(j)!=text.charAt(i)) {
				if(j!=0)
					j = lps[j-1];
				else {
					i++;
				}
			}
		}
		return -1;
	}
	
	public static int[] getlps(String pattern) {
		int n = pattern.length();
		int lps[] = new int[n];
		lps[0] = 0;
		int j=0, i=1;
		while(i < n) {
			if(pattern.charAt(i)==pattern.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			}
			else {
				if(j!=0)
					j = lps[j-1];
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

}
