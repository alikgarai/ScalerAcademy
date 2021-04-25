import java.util.Scanner;

public class ReadingNewspaper {

	public int solve(int A, int[] B) {
		int sum = B[0];
		int i;

		for (i = 1; i < B.length; i++) {
			sum += B[i];
		}

		if (A > sum) {
			A = A % sum;
		}

		for (i = 0; i < B.length; i++) {
			if (B[i] > 0) {
				A -= B[i];
				if (A <= 0) {
					break;
				}
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n, A[], B;
		B = s.nextInt();

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}

		ReadingNewspaper c = new ReadingNewspaper();
		System.out.println(c.solve(B, A));
		s.close();
	}
}
