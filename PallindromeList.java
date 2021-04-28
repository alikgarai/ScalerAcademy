package ib.scaler.day44_Mar20;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PallindromeList {

	public int lPalin(ListNode A) {
//		int cnt = 0;
//		String S = "";
//
//		while (A != null) {
//			S += A.val;
//			A = A.next;
//			cnt++;
//		}
//		int i = 0;
//		int j = cnt - 1;
//		while (i < j) {
//			if (S.charAt(i) != S.charAt(j))
//				return 0;
//			i++;
//			j--;
//		}
//		return 1;
		int cnt = 0;
		Stack<Integer> S = new Stack<>();

		while (A != null) {
			S.push(A.val);
			A = A.next;
			cnt++;
		}
		ArrayList<Integer> x = new ArrayList<>();
		for (int i = 0; i < cnt / 2; i++)
			x.add(S.pop());

		if (cnt % 2 == 1)
			S.pop();

		for (int i = cnt / 2 - 1; i >= 0; i--) {
			if ((int) S.peek() != x.get(i))
				return 0;
			else
				S.pop();
		}

		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int val = s.nextInt();
		ListNode ln = new ListNode(val);
		ListNode temp = ln;

		for (int i = 1; i < n; i++) {
			val = s.nextInt();
			ln.next = new ListNode(val);
			ln = ln.next;
		}
		PallindromeList pl = new PallindromeList();
		System.out.println(pl.lPalin(temp));
		s.close();
	}
}
