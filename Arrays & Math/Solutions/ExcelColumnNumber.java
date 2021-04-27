package ib.scaler.day13_Feb10;

import java.util.Scanner;

public class ExcelColumnNumber {

	public int titleToNumber(String A) {
		int pow = 1;
		int val, sum = 0;

		for (int i = A.length() - 1; i >= 0; i--) {
			val = A.charAt(i) - 64;
			sum += pow * val;
			pow *= 26;
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		ExcelColumnNumber ecn = new ExcelColumnNumber();
		System.out.println(ecn.titleToNumber(str));
		s.close();
	}

}
