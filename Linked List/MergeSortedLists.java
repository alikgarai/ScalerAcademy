package ib.scaler.day52_Mar30;

import java.util.Scanner;

public class MergeSortedLists {

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode ans, tmp;

		if (A == null)
			return B;
		if (B == null)
			return A;

		if (A.val < B.val) {
			ans = A;
			A = A.next;
		} else {
			ans = B;
			B = B.next;
		}
		tmp = ans;

		while (A != null && B != null) {
			if (A.val < B.val) {
				tmp.next = A;
				A = A.next;
			} else {
				tmp.next = B;
				B = B.next;
			}
			tmp = tmp.next;
		}
		if (A == null)
			tmp.next = B;
		else
			tmp.next = A;

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		MergeSortedLists msl = new MergeSortedLists();
		ListNode A = new ListNode(s.nextInt());
		ListNode tail = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}
		n = s.nextInt();
		ListNode B = new ListNode(s.nextInt());
		tail = B;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}
		A = msl.mergeTwoLists(A, B);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}

}
