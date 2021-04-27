package ib.scaler.day25_Feb26;

import java.util.ArrayList;
import java.util.Scanner;

public class KthPermutationSequence {

	int cnt = 0;
	int freq[];
	String ans = "";

	void solve(ArrayList<Integer> curr, int A, int B) {

		if (curr.size() == A) {
			cnt++;
			if (cnt == B) {
				while (!curr.isEmpty()) {
					ans += String.valueOf(curr.get(0));
					curr.remove(0);
				}
			}
			return;
		}

		for (int i = 0; i < A; i++) {
			if (freq[i] == 0) {
				curr.add(i + 1);
				freq[i] = 1;
				solve(curr, A, B);
				if (cnt == B)
					return;
				freq[i] = 0;
				curr.remove(curr.size() - 1);
			}
		}
	}

	public String getPermutation(int A, int B) {

		ArrayList<Integer> curr = new ArrayList<>();
		freq = new int[A];
		solve(curr, A, B);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		System.out.println(new KthPermutationSequence().getPermutation(A, B));
		s.close();
	}

}
