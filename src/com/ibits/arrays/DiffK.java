package com.ibits.arrays;

/*
 * https://www.interviewbit.com/problems/diffk/
 */
import java.util.ArrayList;

public class DiffK {

	public static void main(String[] args) {
		//int arr[] = {0, 1, 9, 10, 13, 17, 17, 17, 23, 25, 29, 30, 37, 38, 39, 39, 40, 41, 42, 60, 64, 70, 70, 70, 72, 75, 85, 85, 90, 91, 91, 93, 95};
		//int B = 83;
		int arr[] = {0,1,3};
		int B = 0;
		ArrayList<Integer> A = new ArrayList<>();
		A = convertToList(arr);
		
		System.out.println(diffPossible(A, B));
	}
	
	public static int diffPossible(ArrayList<Integer> A, int B) {
        int n = A.size();
        if(n==1)
            return 0;
        int low = 0, high = 1;
        while(high < n){
            int diff = A.get(high) - A.get(low);
            if(diff==B)
                return 1;
            else if(diff > B){
                low++;
                if(high==low)
                    high++;
            }
                
            else
                high++;
        }
        return 0;
    }
	
	
	public static ArrayList<Integer> convertToList(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : arr)
			list.add(num);
		return list;
	}

}
