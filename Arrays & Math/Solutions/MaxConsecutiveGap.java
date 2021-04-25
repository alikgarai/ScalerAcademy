Public class MaxConsecutiveGap {

	public int maximumGap(final int[] A) {
		if (A.length < 2)
			return 0;
		if (A.length == 2)
			return Math.abs(A[0] - A[1]);

		int max = A[0], min = A[0];

		for (int i = 1; i < A.length; i++) {
			if (max < A[i])
				max = A[i];
			if (min > A[i])
				min = A[i];
		}

		int max_gap = max - min;
		if (max_gap == 0)
			return 0;
		int min_gap = (max_gap % (A.length - 1) == 0) ? max_gap / (A.length - 1) : max_gap / (A.length - 1) + 1;

		int l = max / min_gap + 1;

		int min_bucket[] = new int[l];
		int max_bucket[] = new int[l];

		for (int i = 0; i < l; i++) {
			min_bucket[i] = Integer.MAX_VALUE;
			max_bucket[i] = Integer.MIN_VALUE;
		}
		int val;

		for (int i = 0; i < A.length; i++) {
			val = (A[i] % min_gap == 0) ? A[i] / min_gap - 1 : A[i] / min_gap;
			if (min_bucket[val] > A[i]) {
				min_bucket[val] = A[i];
			}
			if (max_bucket[val] < A[i]) {
				max_bucket[val] = A[i];
			}
		}

		int max_dis;
		max_dis = max = Integer.MIN_VALUE;

		for (int i = 0; i < l; i++) {
			if (min_bucket[i] == Integer.MAX_VALUE)
				continue;

			if (max == Integer.MIN_VALUE) {
				max = max_bucket[i];
				continue;
			}

			max_dis = (max_dis < (min_bucket[i] - max)) ? (min_bucket[i] - max) : max_dis;
			max = max_bucket[i];
		}

		return max_dis;
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

		MaxConsecutiveGap c = new MaxConsecutiveGap();
		System.out.println(c.maximumGap(A));
		s.close();
	}
}
