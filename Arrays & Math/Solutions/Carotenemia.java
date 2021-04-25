import java.util.Scanner;

public class Carotenemia {

	public int solve(int[] A, int B) {

		for (int i = 0; i < A.length; i++) {
			B -= A[i];
			if (B <= 0) {
				return i;
			}
		}
		if (B > 0) {
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n, A[], B;
		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		B = s.nextInt();

		Carotenemia c = new Carotenemia();
		System.out.println(c.solve(A, B));
		s.close();
	}

}
