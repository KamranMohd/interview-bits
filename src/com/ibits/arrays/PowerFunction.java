package com.ibits.arrays;

public class PowerFunction {

	public static void main(String[] args) {
		//int x = -1, n = 1, d = 13;
		//int x = -8, n = 5, d = 11;
		int x = 94775252, n = 42920349, d = 55283899;
		System.out.println(power(x, n, d));
	}
	
	public static int power(int x, int n, int d){
		if (n==0)
            return 1%d;
        if (n==1) {
            if (x<0) 
                return (x+d)%d;
            return x%d;
        }
        long result = 1;
        long prod = x%d;
        long longd = (long)d;
        while (n!=0) {
            int div = n/2;
            int mod = n%2;
            if (mod==1)
                result = (result*prod)%longd;
            n = div;
            prod = (prod*prod)%longd;
        }
        return (int) ((result+d)%d);
	}

}
