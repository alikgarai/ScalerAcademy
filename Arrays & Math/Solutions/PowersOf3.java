package ib.scaler.day24_Feb25;

import java.util.ArrayList;
import java.util.Scanner;

public class PowersOf3 {

	public ArrayList<Integer> solve(int A) {

		ArrayList<Integer> B = new ArrayList<>();
		int po3[] = new int[19];
		int i;
		for (i = 0; i < 19; i++)
			po3[i] = (int) Math.pow(3, i);

		i--;
		while (i >= 0) {
			if (A >= po3[i]) {
				B.add(po3[i]);
				A -= po3[i];
			} else
				i--;
		}

		return B;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n;
		n = s.nextInt();

		PowersOf3 po3 = new PowersOf3();
		System.out.print(po3.solve(n));
		s.close();
	}

}
