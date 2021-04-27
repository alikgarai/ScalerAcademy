package ib.scaler.day27_Feb28;

import java.util.ArrayList;
import java.util.Scanner;

public class GrayCode {

	ArrayList<Integer> ans = new ArrayList<>();

	void create(int n, int a) {
		if (n == a)
			return;

		for (int i = ans.size() - 1; i >= 0; i--) {
			int val = (1 << n) + ans.get(i);
			ans.add(val);
		}
		create(n + 1, a);
	}

	public ArrayList<Integer> grayCode(int a) {

		ans.add(0);
		ans.add(1);

		create(1, a);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new GrayCode().grayCode(s.nextInt()));
		s.close();
	}
}
