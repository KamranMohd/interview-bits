package com.ibits.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {

	public static void main(String[] args) {
		int num = 1954;
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		System.out.println(getRoman(num, map));
	}

	private static String getRoman(int num, Map<Integer, String> map) {
		List<Integer> numbers = new ArrayList<>(map.keySet());
		Collections.sort(numbers);
		String roman = "";
		int n = numbers.size();
		while(num > 0) {
			int j = n-1;
			while(numbers.get(j) > num) {
				j--;
			}
			num -= (numbers.get(j));
			roman += map.get(numbers.get(j));
		}
		return roman;
	}

}
