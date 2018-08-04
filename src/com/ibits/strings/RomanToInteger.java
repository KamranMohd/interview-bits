package com.ibits.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		String roman = "XC";
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		System.out.println(convertRomanToInteger(roman, map));
	}
	
	public static int convertRomanToInteger(String roman, Map<Character, Integer> map) {
		int n = roman.length(), result=0;
		for(int i=0;i<n;i++) {
			if(i+1 < n && map.get(roman.charAt(i+1)) > map.get(roman.charAt(i))) {
				result += (map.get(roman.charAt(i+1)) - map.get(roman.charAt(i)));
				i++;
			}
			else 
				result += map.get(roman.charAt(i));
		}
		return result;
	}

}
