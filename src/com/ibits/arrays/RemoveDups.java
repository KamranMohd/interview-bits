package com.ibits.arrays;

import java.util.ArrayList;

public class RemoveDups {

	public static void main(String[] args) {
		int arr[] = {1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};
		ArrayList<Integer> a = new ArrayList<>();
		for(int n : arr)
			a.add(n);
		removeDuplicates(a);
	}
	
	public static int removeDuplicates(ArrayList<Integer> a) {
        if(a.size()==0 || a.size()==1)
            return a.size();
        int count = 1;
        for(int i=1;i<a.size();i++){
        	//System.out.println(i + " " + count);
            if(a.get(i).equals(a.get(i-1)) && count <2)
                count++;
            else if(a.get(i).equals(a.get(i-1))){
                a.remove(i);
                i--;
            }
            else if(!a.get(i).equals(a.get(i-1))){
                count = 1;
            }
        }
        for(int num : a)
        	System.out.print(num + " ");
        return a.size();
    }
}