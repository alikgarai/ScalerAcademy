package ib.scaler.day13_Feb10;

import java.util.Scanner;

public class CutTheChocolate {

	public int solve(int A, int B) {
		if ((A % 2 * B % 2) % 2 == 1)
			return 0;
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		CutTheChocolate ctc = new CutTheChocolate();
		System.out.println(ctc.solve(a, b));
		s.close();
	}
}
