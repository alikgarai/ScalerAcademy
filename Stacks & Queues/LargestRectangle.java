package ib.scaler.day46_Mar23;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

	class Node {
		int x;
		int val;

		Node(int index, int value) {
			this.x = index;
			this.val = value;
		}
	}

	class Nod {
		int l;
		int r;
	}

	public int largestRectangleArea(int[] A) {

		int l = A.length;
		Stack<Node> S = new Stack<>();
		Node T;
		Nod ans[] = new Nod[l];
		for (int i = 0; i < l; i++)
			ans[i] = new Nod();

		ans[0].l = -1;
		T = new Node(0, A[0]);
		S.push(T);

		for (int i = 1; i < l; i++) {
			while (S.peek().val >= A[i]) {
				S.pop();
				if (S.empty())
					break;
			}
			if (S.empty())
				ans[i].l = -1;
			else
				ans[i].l = S.peek().x;

			T = new Node(i, A[i]);
			S.push(T);
		}

		S.clear();
		ans[l - 1].r = l - 1;
		T = new Node(l - 1, A[l - 1]);
		S.push(T);

		for (int i = l - 2; i >= 0; i--) {
			while (S.peek().val >= A[i]) {
				S.pop();
				if (S.empty())
					break;
			}
			if (S.empty())
				ans[i].r = l - 1;
			else
				ans[i].r = S.peek().x - 1;

			T = new Node(i, A[i]);
			S.push(T);
		}

		int maxarea = (ans[0].r - ans[0].l) * A[0];

		for (int i = 1; i < l; i++) {
			maxarea = Math.max(maxarea, ((ans[i].r - ans[i].l) * A[i]));
		}

		return maxarea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.print(new LargestRectangle().largestRectangleArea(A));
		s.close();
	}

}
