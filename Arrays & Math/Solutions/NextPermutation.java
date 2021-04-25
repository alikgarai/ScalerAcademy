public class NextPermutation {

	public int[] nextPermutation(int[] A) {

		int l = A.length;
		int k, tmp;

		for (k = l - 2; k >= 0; k--) {
			if (A[k] < A[k + 1]) {
				break;
			}
		}

		if (k == -1) {
			Arrays.sort(A);
			return A;
		}

		for (int i = l - 1; i >= 0; i--) {
			if (A[i] > A[k]) {
				tmp = A[i];
				A[i] = A[k];
				A[k] = tmp;
				break;
			}
		}

		Arrays.sort(A, k + 1, l);

		return A;
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

		NextPermutation c = new NextPermutation();
		A = c.nextPermutation(A);
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}
		s.close();
	}
}
