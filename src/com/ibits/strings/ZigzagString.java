package com.ibits.strings;

/*
 * https://www.interviewbit.com/problems/zigzag-string/
 */
public class ZigzagString {

	public static void main(String[] args) {
		//String str = "PAYPALISHIRING";
		//int n = 3;
		//String str = "ABCD";
		//int n = 2;
		//String str = "A";
		//int n = 1;
		String str = "kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS";
		int n = 1;
		System.out.println(getZigzap(str, n));
	}

	public static String getZigzag(String str, int n) {
		if(n==1)
			return str;
		//	Create an array of string to hold the string row-wise
		String rows[] = new String[n];
		for(int i=0;i<n;i++)
			rows[i] = "";
		int j=0,i=0;
		boolean toAddOrSubtract=true;
		while(j < str.length()) {
			rows[i]+=str.charAt(j);
			j++;
			if(i==0)
				toAddOrSubtract = true;
			else if(i==n-1)
				toAddOrSubtract = false;
			if(toAddOrSubtract)
				i++;
			else
				i--;
		}
		
		//	Concatenate all the strings arrays
		String result = "";
		for(i=0;i<n;i++)
			result+=rows[i];
		return result;
	}
	public static String getZigzap(String str, int n) {
		String result = "";
        if(n==1)
            return str;
        for (int i = 0; i < n; i++) {
            int j = i, k = 0;
            while (j < str.length()) {
                result += str.charAt(j);
                if (i == 0 || i == n - 1)
                    j += 2 * (n - 1);
                else if (k % 2 == 0) {
                    j += 2 * (n - i - 1);
                    k = 1;
                } else {
                    j += 2 * i;
                    k = 0;
                }
            }
        }
        return result;
	}

}
