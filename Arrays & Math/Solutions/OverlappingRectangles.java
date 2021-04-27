package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class OverlappingRectangles {

	public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {

		if (A >= G || E >= C)
			return 0;
		if (F >= D || B >= H)
			return 0;
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		int d = s.nextInt();
		int e = s.nextInt();
		int f = s.nextInt();
		int g = s.nextInt();
		int h = s.nextInt();

		OverlappingRectangles or = new OverlappingRectangles();
		System.out.println(or.solve(a, b, c, d, e, f, g, h));
		s.close();
	}
}
