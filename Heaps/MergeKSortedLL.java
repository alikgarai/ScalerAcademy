package ib.scaler.day70_Apr17;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeKSortedLL {

	void HeapUp(ListNode[] A, int n) {
		if (n == 0)
			return;
		int parent = (n - 1) / 2;
		if (A[parent].val > A[n].val) {
			ListNode tmp = A[parent];
			A[parent] = A[n];
			A[n] = tmp;
			HeapUp(A, parent);
		}
	}

	ListNode delMin(ListNode[] A, int n) {
		ListNode min = A[0];
		A[0] = A[n - 1];
		HeapDown(A, 0, --n);
		return min;
	}

	void HeapDown(ListNode[] A, int root, int n) {

		int lc = 2 * root + 1;
		int rc = 2 * root + 2;
		int minInd = root;
		ListNode tmp, min = A[root];

		if (lc < n) {
			minInd = A[lc].val < min.val ? lc : minInd;
			min = A[minInd];
		}
		if (rc < n)
			minInd = A[rc].val < min.val ? rc : minInd;

		if (lc == minInd) {
			tmp = A[root];
			A[root] = A[lc];
			A[lc] = tmp;
			HeapDown(A, lc, n);
		} else if (rc == minInd) {
			tmp = A[root];
			A[root] = A[rc];
			A[rc] = tmp;
			HeapDown(A, rc, n);
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		int n = a.size();
		ListNode X[] = new ListNode[n];
		ListNode tmp, head = null;

		for (int i = 0; i < n; i++) {
			X[i] = a.get(i);
			HeapUp(X, i);
		}
		head = X[0];
		tmp = head;

		while (n > 0) {
			if (tmp.next != null) {
				X[0] = tmp.next;
				HeapDown(X, 0, n);
			} else
				delMin(X, n--);

			tmp.next = X[0];
			tmp = tmp.next;
		}
		tmp.next = null;

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<ListNode> A = new ArrayList<>();
		ListNode tmp, head;

		for (int i = 0; i < n; i++) {
			int l = s.nextInt();
			head = new ListNode(s.nextInt());
			tmp = head;
			while (l-- > 1) {
				tmp.next = new ListNode(s.nextInt());
				tmp = tmp.next;
			}
			A.add(head);
		}
		head = new MergeKSortedLL().mergeKLists(A);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

		s.close();
	}

}
