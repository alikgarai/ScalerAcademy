package ib.scaler.day25_Feb26;

import java.util.Scanner;

public class UniquePaths3 {

	int ans = 0;
	int cnt = 0;
	int B = 0;
	int x1, y1;
	int visited[][];

	void check(int[][] A, int x, int y) {

		if (x < 0 || y < 0 || x == A.length || y == A[0].length)
			return;

		if (visited[x][y] == 1 || A[x][y] == -1)
			return;

		if (A[x][y] == 2) {
			if (cnt == B)
				ans++;
			return;
		}

		visited[x][y] = 1;
		if (A[x][y] == 0)
			cnt++;

		check(A, x - 1, y);
		check(A, x + 1, y);
		check(A, x, y - 1);
		check(A, x, y + 1);

		visited[x][y] = 0;
		if (A[x][y] == 0)
			cnt--;
	}

	public int solve(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		visited = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == 0)
					B++;
				else if (A[i][j] == 1) {
					x1 = i;
					y1 = j;
				}
			}
		}

		check(A, x1, y1);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int A[][] = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = s.nextInt();

		System.out.println(new UniquePaths3().solve(A));
		s.close();
	}

}
