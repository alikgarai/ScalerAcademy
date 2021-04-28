package ib.scaler.day72_Apr20;

import java.util.ArrayList;
import java.util.Scanner;

public class Seats {

	public int seats(String A) {
		ArrayList<Integer> seats = new ArrayList<>();
		int n = A.length();
		int mod = 10000003;
		long sum = 0;

		for (int i = 0; i < n; i++) {
			if (A.charAt(i) == 'x')
				seats.add(i);
		}
		n = seats.size();
		int median = n / 2;

		for (int i = 0; i < n; i++)
			sum = (sum + Math.abs(seats.get(median) - Math.abs(seats.get(i))) - Math.abs(median - i)) % mod;

		return (int) sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new Seats().seats(s.next()));
		s.close();
	}

}
