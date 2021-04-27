package ib.scaler.day25_Feb26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NQueens {

	ArrayList<ArrayList<String>> A = new ArrayList<>();
	int l = 0;

	public boolean isValid(int r, int c, int C[]) {
		if (c == C.length)
			return false;

		for (int i = 0; i < r; i++) {
			if ((c == C[i]) || (r - i == c - C[i]) || (r + c == i + C[i]))
				return false;
		}
		return true;
	}

	boolean nQueens(int r, int[] C) {
		if (r == C.length)
			return true;

		for (int i = 0; i < C.length; i++) {
			if (isValid(r, i, C)) {
				C[r] = i;
				if (nQueens(r + 1, C)) {
					A.add(new ArrayList<>());
					String str = String.join("", Collections.nCopies(C.length, "."));
					String s;
					for (int x = 0; x < C.length; x++) {
						s = str.substring(0, C[x]) + 'Q' + str.substring(C[x] + 1);
						A.get(l).add(s);
					}
					l++;
				}
			}
		}
		return false;
	}

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		int C[] = new int[a];

		nQueens(0, C);

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		ArrayList<ArrayList<String>> A = new NQueens().solveNQueens(n);

		for (int i = 0; i < A.size(); i++)
			System.out.println(A.get(i));

		s.close();
	}

}