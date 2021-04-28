package ib.scaler.day80_Apr29;

import java.util.Scanner;

public class PallindromePartitioning2 {

	public int minCut(String A) {

		int n = A.length();
		int isPallindrome[][] = new int[n][n];

		for (int x = 0; x < n; x++) {
			for (int i = 0; i + x < n; i++) {
				int j = i + x;

				if (i == j)
					isPallindrome[i][j] = 1;

				else if (j == i + 1) {
					isPallindrome[i][j] = A.charAt(i) == A.charAt(j) ? 1 : 0;

				} else
					isPallindrome[i][j] = (isPallindrome[i + 1][j - 1] == 1 && A.charAt(i) == A.charAt(j)) ? 1 : 0;
			}
		}

		int minCuts[] = new int[n];

		for (int r = 0; r < n; r++) {
			if (isPallindrome[0][r] == 1)
				minCuts[r] = 0;
			else {
				minCuts[r] = Integer.MAX_VALUE;
				for (int l = 0; l < r; l++) {
					if (isPallindrome[l + 1][r] == 1) {
						minCuts[r] = Math.min(minCuts[r], 1 + minCuts[l]);
					}
				}
			}
		}

		return minCuts[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new PallindromePartitioning2().minCut(s.next()));
		s.close();
	}

}
