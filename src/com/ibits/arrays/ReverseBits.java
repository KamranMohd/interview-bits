package com.ibits.arrays;

public class ReverseBits {

	public static void main(String[] args) {
		//long a = 4294967295l;
		//long a = 3l;
		long a = 15l;
		System.out.println(reverseBits(a));
	}
	
	public static long reverseBits(long a){
		long reverse = 0L, power = 31;
        while(a >= 1){
            int rem = (int)(a & 1);
            reverse = reverse + (long)(Math.pow(2, power)) * rem;
            power--;
            a = a >> 1;
        }
        return reverse;
	}
	
	/*
	 * Method 2: 
	 */
	public long reverse(long A) {
	    long rev = 0;
	    
	    for (int i = 0; i < 32; i++) {
	        rev <<= 1;
	        if ((A & (1 << i)) != 0)
	            rev |= 1;
	    }
	    
	    return rev;
	    
	}

}
