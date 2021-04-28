package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class SwapPairs {

	public ListNode swapPairs(ListNode A) {
		int n = 0;
		ListNode tmp = A, n1, n2;
		while (tmp != null) {
			n++;
			tmp = tmp.next;
		}
		if (n == 1)
			return A;
		n = n / 2 - 1;

		n1 = A;
		n2 = A.next;
		tmp = n2.next;
		A = n2;

		while (n-- > 0) {
			n2.next = n1;
			n1.next = tmp.next;
			n1 = tmp;
			n2 = tmp.next;
			tmp = n2.next;
		}
		n2.next = n1;
		n1.next = tmp;

		return A;
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
		A = new SwapPairs().swapPairs(A);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}

}
