package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode A) {
		ListNode tmp = A;

		while (tmp.next != null) {
			if (tmp.next.val == tmp.val)
				tmp.next = tmp.next.next;
			else
				tmp = tmp.next;
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
		A = new RemoveDuplicates().deleteDuplicates(A);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}
}
