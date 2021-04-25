public class MaximumAbsoluteDifference {

	public int maxArr(int[] A) {

		int max_a = A[0], max_b = A[0], min_a = A[0], min_b = A[0];
		int val_a, val_b;

		for (int i = 0; i < A.length; i++) {
			val_a = A[i] + i;
			val_b = A[i] - i;

			if (max_a < val_a) {
				max_a = val_a;
			}
			if (max_b < val_b) {
				max_b = val_b;
			}
			if (min_a > val_a) {
				min_a = val_a;
			}
			if (min_b > val_b) {
				min_b = val_b;
			}
		}
		return ((max_a - min_a) > (max_b - min_b)) ? (max_a - min_a) : (max_b - min_b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];
		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}

		MaximumAbsoluteDifference c = new MaximumAbsoluteDifference();
		System.out.println(c.maxArr(A));
		s.close();
	}

}
