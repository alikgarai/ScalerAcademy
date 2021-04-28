import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A[] = new int[45];
		A[0] = 0;
		A[1] = 1;
		for (int i = 2; i < 45; i++)
			A[i] = A[i - 1] + A[i - 2];

		System.out.println(A[s.nextInt()]);
		s.close();
	}
}
