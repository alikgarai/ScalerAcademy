package ib.scaler.day13_Feb10;

import java.util.Scanner;

public class ExcelColumnTitle {

	public String convertToTitle(int A) {
		char a[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z' };
		String ans = "";
		int i = 0;

		while (A > 26) {
			i = (A + 25) % 26;
			ans = a[i] + ans;
			A = A / 26;
			if (i == 25)
				A--;
		}
		ans = a[(A + 25) % 26] + ans;

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		ExcelColumnTitle ect = new ExcelColumnTitle();
		System.out.println(ect.convertToTitle(a));
		s.close();
	}

}
