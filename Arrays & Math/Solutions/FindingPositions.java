package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class FindingPositions {

	public int solve(int A) {
		int i = (int) (Math.log(A) / Math.log(2));

		return (int) Math.pow(2, i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		FindingPositions fp = new FindingPositions();
		System.out.println(fp.solve(n));
		s.close();
	}

}
