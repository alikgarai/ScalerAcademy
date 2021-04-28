package ib.scaler.day42_Mar18;

import java.util.Scanner;

public class AddBinary {

	public String addBinary(String A, String B) {
		String ans = "";
		int carry = 0, x, y;
		int l1 = A.length();
		int l2 = B.length();

		x = l1 - 1;
		y = l2 - 1;

		while (x >= 0 && y >= 0) {
			int sum = Integer.parseInt("" + A.charAt(x)) + Integer.parseInt("" + B.charAt(y)) + carry;
			carry = (sum >= 2) ? 1 : 0;
			ans = (sum % 2) + ans;
			x--;
			y--;
		}
		while (y >= 0) {
			int sum = Integer.parseInt("" + B.charAt(y)) + carry;
			carry = (sum >= 2) ? 1 : 0;
			ans = (sum % 2) + ans;
			y--;
		}
		while (x >= 0) {
			int sum = Integer.parseInt("" + A.charAt(x)) + carry;
			carry = (sum >= 2) ? 1 : 0;
			ans = (sum % 2) + ans;
			x--;
		}
		if (carry == 1) {
			ans = carry + ans;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.next();
		String B = s.next();
		AddBinary ab = new AddBinary();
		System.out.print(ab.addBinary(A, B));
		s.close();
	}

}
