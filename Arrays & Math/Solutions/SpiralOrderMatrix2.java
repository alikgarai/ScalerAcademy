import java.util.Scanner;

public class Spiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int A[][], count, n, val = 1;

		n = s.nextInt();
		count = n * n;
		A = new int[n][n];

		int k = 0, l = n, i, j;

		while (val <= count) {
			i = k;
			for (j = k; j < l; j++) {
				A[i][j] = val++;
			}
			j = (j >= l) ? j - 1 : j;

			for (i = k + 1; i < l; i++) {
				A[i][j] = val++;
			}
			i = (i >= l) ? i - 1 : i;

			for (j = l - 2; j >= k; j--) {
				A[i][j] = val++;
			}
			j = (j < k) ? j + 1 : j;

			for (i = l - 2; i > k; i--) {
				A[i][j] = val++;
			}
			k++;
			l--;
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		s.close();
	}

}
