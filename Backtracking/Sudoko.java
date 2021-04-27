package ib.scaler.day25_Feb26;

import java.util.ArrayList;
import java.util.Scanner;

public class Sudoko {

	boolean check(ArrayList<ArrayList<Character>> A, int r, int c, char val) {

		for (int i = 0; i < 9; i++)
			if (A.get(r).get(i) == val || A.get(i).get(c) == val)
				return false;

		int r1 = (r / 3) * 3;
		int c1 = (c / 3) * 3;

		for (int i = r1; i < r1 + 3; i++)
			for (int j = c1; j < c1 + 3; j++) {
				if (A.get(i).get(j) == val)
					return false;
			}

		A.get(r).remove(c);
		A.get(r).add(c, val);
		return true;
	}

	boolean sudoku(ArrayList<ArrayList<Character>> A, int r, int c) {

		if (c >= 9) {
			c = 0;
			r++;
		}
		if (r >= 9)
			return true;

		if (A.get(r).get(c) != '.')
			return sudoku(A, r, c + 1);

		for (int i = 1; i <= 9; i++) {
			if (check(A, r, c, (char) (i + '0')) && sudoku(A, r, c + 1))
				return true;
			A.get(r).remove(c);
			A.get(r).add(c, '.');
		}

		return false;
	}

	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		int n = a.size();
		if (n != 9)
			return;

		sudoku(a, 0, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayList<ArrayList<Character>> A = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			ArrayList<Character> tmp = new ArrayList<>();
			String str = s.next();
			for (int j = 0; j < 9; j++)
				tmp.add(str.charAt(j));
			A.add(tmp);
		}
		new Sudoko().solveSudoku(A);
		System.out.println(A);

		s.close();
	}
}
