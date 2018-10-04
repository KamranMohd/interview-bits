package com.ibits.strings;

/*
 * https://www.interviewbit.com/problems/atoi/
 */
public class Atoi {

	public static void main(String[] args) {
		//String str = "-5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393";
		//String str = "V515V 5793K 627 23815945269 1 1249794L 631 8755 7";
		//String str = "-7";
		//String str = "++6";
		String str = "+6+2";
		System.out.println(atoi(str));
	}
	public static int atoi(String str){
		int result = 0, prev_res = 0;
        int n = str.length();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch==' ')
                break;
            if(!Character.isDigit(ch) && result!=0)
                break;
            if(!Character.isDigit(ch) && result==0 && ch!='+' && ch!='-')
                break;
            if(!Character.isDigit(ch) && result==0 && i > 0)
                break;
            if(!Character.isDigit(ch) && result==0)
                continue;
            prev_res = result;
            result = result*10 + (ch-'0');
            if(result/10 != prev_res)
                return str.charAt(0)!='-'?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return str.charAt(0)!='-'?result:-1 * result;
	}

}
