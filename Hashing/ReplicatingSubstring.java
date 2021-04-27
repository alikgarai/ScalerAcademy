package ib.scaler.day38_Mar13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReplicatingSubstring {

	public int solve(int A, String B) {
		HashMap<Character, Integer> hm = new HashMap<>();
		char c;

		for (int i = 0; i < B.length(); i++) {
			c = B.charAt(i);
			if (hm.containsKey(c))
				hm.replace(c, hm.get(c) + 1);
			else
				hm.put(c, 1);
		}
		for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
			if (entry.getValue() % A != 0)
				return -1;
		}

		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		String B = s.next();

		System.out.print(new ReplicatingSubstring().solve(A, B));
		s.close();
	}

}
