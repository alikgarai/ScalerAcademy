package ib.scaler.day13_Feb10;

import java.util.Scanner;

public class ToAndFro {

	public int solve(int A) {
		if (A % 2 == 1)
			return A / 2;
		return (A / 2 - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		ToAndFro tf = new ToAndFro();
		System.out.println(tf.solve(a));
		s.close();
	}
}
