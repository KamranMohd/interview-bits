package com.ibits.hashing;

/*
 * https://www.interviewbit.com/problems/3-sum-zero/
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ThreeSumZero {

	public static void main(String[] args) {
		int arr[] = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
		ArrayList<Integer> A = new ArrayList<>();
		for(int num : arr)
			A.add(num);
		System.out.println(threeSum(A).toString());

	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        /*for(int n : A)
        	System.out.print(n + " ");*/
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = A.size();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<n-1;i++){
            int l = i+1;	
            int r = n-1;
            while(l < r){
               if((A.get(i) + A.get(l) + A.get(r))==0){
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(A.get(i));
                    triplet.add(A.get(l));
                    triplet.add(A.get(r));
                    l++;
                    r--;
                    if(!set.contains(triplet)) {
                    	result.add(triplet);
                    	set.add(triplet);
                    }
                }
                else if((A.get(i) + A.get(l) + A.get(r)) < 0)
                    l++;
                else
                    r--; 
            }
        }
        //System.out.println("==================");
        return result;
    }

}
