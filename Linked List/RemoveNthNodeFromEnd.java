package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class RemoveNthNodeFromEnd {

	public ListNode removeNthFromEnd(ListNode A, int B) {
		int n = 0;
		ListNode tmp = A;

		while (tmp != null) {
			n++;
			tmp = tmp.next;
		}

		if (B > n)
			return A.next;

		n = n - B + 1;
		if (n == 1)
			return A.next;

		tmp = A;
		while (n-- > 2)
			tmp = tmp.next;

		tmp.next = tmp.next.next;

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		RemoveNthNodeFromEnd rn = new RemoveNthNodeFromEnd();
		ListNode A = new ListNode(s.nextInt());
		ListNode tail = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}
		int B = s.nextInt();
		A = rn.removeNthFromEnd(A, B);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}
}
