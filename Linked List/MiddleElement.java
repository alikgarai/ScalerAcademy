package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class MiddleElement {

	public int solve(ListNode A) {
		int n = 0, x;
		ListNode tmp = A;

		while (tmp != null) {
			n++;
			tmp = tmp.next;
		}
		tmp = A;
		x = n / 2;
		while (x-- > 0)
			tmp = tmp.next;

		return (x % 2 == 0) ? tmp.next.val : tmp.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ListNode A = new ListNode(s.nextInt());
		ListNode tail = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}

		System.out.print(new MiddleElement().solve(A));

		s.close();
	}

}
