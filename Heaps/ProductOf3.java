package ib.scaler.day68_Apr15;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOf3 {

	void heapify(int[] A) {
		int tmp;

		if (A[0] > A[1]) {
			tmp = A[0];
			A[0] = A[1];
			A[1] = tmp;
		}
		if (A[0] > A[2]) {
			tmp = A[0];
			A[0] = A[2];
			A[2] = tmp;
		}
	}

	public int[] solve(int[] A) {
		int mH[] = new int[3];
		int ans[] = new int[A.length];
		int prod = 1;

		if (A.length < 3) {
			Arrays.fill(ans, -1);
			return ans;
		}

		for (int i = 0; i < 3; i++) {
			mH[i] = A[i];
			prod *= A[i];
			ans[i] = -1;
		}
		ans[2] = prod;
		heapify(mH);

		for (int i = 3; i < A.length; i++) {
			if (mH[0] < A[i]) {
				prod = (prod / mH[0]) * A[i];
				mH[0] = A[i];
				heapify(mH);
			}
			ans[i] = prod;
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
		System.out.println(Arrays.toString(new ProductOf3().solve(A)));

		s.close();
	}

}
