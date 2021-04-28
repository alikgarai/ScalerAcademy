package ib.scaler.day52_Mar30;

import java.util.Scanner;

public class RemoveDuplicates2 {

	public ListNode deleteDuplicates(ListNode A) {
		ListNode pre, nxt;
		boolean flg;

		while (A != null) {
			flg = false;
			while (A != null && A.next != null && A.val == A.next.val) {
				A = A.next;
				flg = true;
			}
			if (flg == true)
				A = A.next;
			else
				break;
		}

		if (A == null)
			return A;
		if (A.next == null)
			return A;

		pre = A;
		nxt = A.next;

		flg = false;
		while (nxt.next != null) {
			if (nxt.next.val == nxt.val) {
				nxt.next = nxt.next.next;
				flg = true;
			} else {
				if (flg == true) {
					pre.next = nxt.next;
					flg = false;
				} else {
					pre = nxt;
				}

				nxt = nxt.next;
			}
		}
		if (flg == true) {
			pre.next = null;
		}

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
		A = new RemoveDuplicates2().deleteDuplicates(A);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}

}
