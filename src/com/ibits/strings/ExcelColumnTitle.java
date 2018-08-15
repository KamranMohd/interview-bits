package com.ibits.strings;

/*
 * https://www.geeksforgeeks.org/find-excel-column-name-given-number/
 */
public class ExcelColumnTitle {

	public static void main(String[] args) {
		int num = 28;
		System.out.println(getExcelColTitle(num));
	}

	public static String getExcelColTitle(int num) {
		StringBuilder title = new StringBuilder();
		while (num > 0) {
			int rem = num % 26;
			if (rem == 0) {
				title.append('Z');
				num = num / 26 - 1;
			} else {
				System.out.println((char) ((rem - 1) + 'A'));
				title.append((char) ((rem - 1) + 'A'));
				num = num / 26;
			}
		}
		return new String(title.reverse());
	}
}