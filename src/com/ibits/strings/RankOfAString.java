package com.ibits.strings;

public class RankOfAString {

	public static void main(String[] args) {
		String str = "DTNGJPURFHYEW";
		System.out.println(findRank(str));

	}
	
	public static int findRank(String str) {
        int len = str.length();
        int mul = fact(len);
        int rank = 1;
        int countRight;
  
        for (int i = 0; i < len; ++i)
        {
            mul /= len - i;
  
            // count number of chars smaller 
            // than str[i] from str[i+1] to
            // str[len-1]
            countRight = findSmallerInRight(str, i, len-1);
            rank = rank + countRight*mul;
        }
         
        return rank % 1000003;
    }
	
    public static int fact(int n)
    {
        if(n==0 || n==1)
        	return 1;
        int fact = 1;
        for(int i=1;i<=n;i++)
        	fact = (fact * i);
        return fact;
    }
    
    public static int findSmallerInRight(String str, int low,
                                            int high)
    {
        int countRight = 0, i;
  
        for (i = low + 1; i <= high; ++i)
            if (str.charAt(i) < str.charAt(low))
                ++countRight;
  
        return countRight;
    }

}
