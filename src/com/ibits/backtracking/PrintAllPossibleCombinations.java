package com.ibits.backtracking;

import java.util.ArrayList;

/*
 * https://www.interviewbit.com/problems/combinations/
 */
public class PrintAllPossibleCombinations {
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		/*int A = 2;
		int B = 1;*/
		int A = 4;
		int B = 2;
		ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=1;i<=A;i++)
            nums.add(i);
        getCombinations(nums, A,B);
        System.out.println(result.toString());
	}
	
	public static void getCombinations(ArrayList<Integer> arr, int n, int k) {
        ArrayList<Integer> combo = new ArrayList<>();
        getCombinationsUtils(arr, 0, n, k, combo, 0);
    }

    
    public static void getCombinationsUtils(ArrayList<Integer> arr, int currentEleCount, int n, int k, ArrayList<Integer> combo,int i) {

        // If the sum is zero, then we have a combination
    	//System.out.println(currentEleCount + " " + i + " " + k);
        if (currentEleCount == k) {
            //    We have added a new object, because if we add combo
            //    directly then values will disappear between recursion calls
            //    and the result list would become empty
            result.add(new ArrayList<>(combo));
            return;
        }

        // If sum becomes less than zero, then we must return
        if (currentEleCount > k)
            return;

        // We consider elements one by one such that the element is less than the sum
        while(i < n) {
            //    Add the element to the combo list
            combo.add(arr.get(i));
            //    Recur for other combinations
            getCombinationsUtils(arr, currentEleCount + 1, n, k, combo, i + 1);
            
            //    Increase the index of the starting element and remove it
            //    from the combo list
            i++;
            combo.remove(combo.size()-1); // Backtrack step
            
        }
    }

}
