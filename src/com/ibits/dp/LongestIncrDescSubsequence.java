package com.ibits.dp;

/*
 * https://www.interviewbit.com/problems/length-of-longest-subsequence/
 */
public class LongestIncrDescSubsequence {

	public static void main(String[] args) {
		//int arr[] = { 1, 11, 2, 10, 4, 5, 2, 1 };
		int arr[] = {};
		// int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		if(n==0 || n==1)
           System.exit(0);
		
		int lis[] = getLIS(arr);
		int lds[] = getLDS(arr);
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max = Math.max(max, lis[i] + lds[i] - 1);
		}
		System.out.println(max);
	}

	public static int[] getLIS(int[] arr) {
		int n = arr.length;
		int[] lis = new int[n];

		lis[0] = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && (lis[j] + 1) > lis[i])
					lis[i] = lis[j] + 1;
			}
		}
		printArr(lis);
		return lis;
	}

	public static int[] getLDS(int[] arr) {
		int n = arr.length;
		int lds[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			lds[i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j] && lds[j] + 1 > lds[i])
					lds[i] = lds[j] + 1;
			}
		}
		printArr(lds);
		return lds;
	}

	private static void printArr(int[] arr) {
		for(int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}
}
