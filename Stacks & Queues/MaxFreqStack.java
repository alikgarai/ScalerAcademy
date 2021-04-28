package ib.scaler.day44_Mar20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MaxFreqStack {

	public int popStack(Stack<Integer> S, HashMap<Integer, Integer> H, int f) {
		int val, tmp;
		if (H.get(S.peek()) == f) {
			return S.pop();
		} else {
			tmp = S.pop();
			val = popStack(S, H, f);
			S.push(tmp);
		}
		return val;
	}

	@SuppressWarnings("deprecation")
	public int[] solve(int[][] A) {

		HashMap<Integer, Integer> H = new HashMap<>();
		Stack<Integer> S = new Stack<>();
		ArrayList<Integer> X = new ArrayList<>();
		int maxf, maxv = 0, i, j;
		int ans[] = new int[A.length];

		for (i = 0; i < A.length; i++) {
			if (A[i][0] == 1) {
				S.push(A[i][1]);
				if (!X.contains(A[i][1])) {
					X.add(A[i][1]);
					H.put(A[i][1], 1);
				} else {
					H.replace(A[i][1], H.get(A[i][1]) + 1);
				}
				ans[i] = -1;
			} else {
				maxf = Integer.MIN_VALUE;
				for (j = X.size() - 1; j >= 0; j--) {
					if (maxf < H.get(X.get(j)))
						maxf = H.get(X.get(j));

				}
				maxv = popStack(S, H, maxf);

				H.replace(maxv, H.get(maxv) - 1);
				if (H.get(maxv) == 0) {
					H.remove(maxv);
					X.remove(new Integer(maxv));
				}
				ans[i] = maxv;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			A[i][0] = s.nextInt();
			A[i][1] = s.nextInt();
		}
		MaxFreqStack mfs = new MaxFreqStack();
		int B[] = mfs.solve(A);
		for (int i = 0; i < n; i++)
			System.out.print(B[i] + " ");
		s.close();
	}

}
