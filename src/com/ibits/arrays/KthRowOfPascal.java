package com.ibits.arrays;

public class KthRowOfPascal {

	public static void main(String[] args) {
		int k=4;
		kthPascalRow(k);
	}
	
	public static void kthPascalRow(int k){
		int c = 1;
		for(int i=1;i<=k;i++){
			System.out.print(c + " ");
			c = c * (k-i)/i;
		}
	}

}
