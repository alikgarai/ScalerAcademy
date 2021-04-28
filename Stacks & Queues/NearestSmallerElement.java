package ib.scaler.day46_Mar23;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NearestSmallerElement {

	public int[] prevSmaller(int[] A) {
		Stack<Integer> S = new Stack<>();
		int ans[] = new int[A.length];
		ans[0] = -1;
		S.push(A[0]);

		for (int i = 1; i < A.length; i++) {
			while (S.peek() >= A[i]) {
				S.pop();
				if (S.empty())
					break;
			}
			if (S.empty())
				ans[i] = -1;
			else
				ans[i] = S.peek();

			S.push(A[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.print(Arrays.toString(new NearestSmallerElement().prevSmaller(A)));
		s.close();
	}

}
