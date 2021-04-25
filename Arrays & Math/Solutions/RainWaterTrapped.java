// Problem Description: https://www.scaler.com/academy/mentee-dashboard/classroom/array-and-math-0eedd85d-7959-45c3-a09b-77ef76de3b6f/#assignment%2F47

public class RainWaterTrapped {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n, A[];
		n = s.nextInt();
		A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}

		int a[] = new int[A.length];
		int b[] = new int[A.length];

		int max = 0;

		for (int i = 1; i < A.length; i++) {
			if (max < A[i - 1]) {
				max = A[i - 1];
			}
			a[i] = max;
		}
		max = 0;
		for (int i = A.length - 2; i >= 0; i--) {
			if (max < A[i + 1]) {
				max = A[i + 1];
			}
			b[i] = max;
		}

		int sum = 0, min;

		for (int i = 0; i < A.length; i++) {
			min = a[i] > b[i] ? b[i] : a[i];
			sum += (min - A[i]) > 0 ? (min - A[i]) : 0;
		}
		System.out.println(sum);

		s.close();
	}
}
