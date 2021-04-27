package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class NoOfOpenDoors {

	public int solve(int A) {
		return (int) Math.sqrt(A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		NoOfOpenDoors od = new NoOfOpenDoors();
		System.out.println(od.solve(n));
		s.close();
	}
}
