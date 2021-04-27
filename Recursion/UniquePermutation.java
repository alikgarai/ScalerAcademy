package ib.scaler.day23_Feb24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UniquePermutation {

	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	void solve(ArrayList<int[]> freq, ArrayList<Integer> curr, int n) {

		if (curr.size() == n) {
			ans.add(new ArrayList<>(curr));
			return;
		}

		for (int i = 0; i < freq.size(); i++) {
			if (freq.get(i)[1] > 0) {
				curr.add(freq.get(i)[0]);
				freq.get(i)[1]--;
				solve(freq, curr, n);
				freq.get(i)[1]++;
				curr.remove(curr.size() - 1);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

		ArrayList<int[]> freq = new ArrayList<>();
		ArrayList<Integer> curr = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = A.size();
		int val;

		for (int i = 0; i < n; i++) {
			val = A.get(i);
			if (hm.containsKey(val)) {
				hm.replace(val, hm.get(val) + 1);
			} else
				hm.put(val, 1);
		}

		hm.forEach((k, v) -> freq.add(new int[] { k, v }));
		solve(freq, curr, n);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++)
			A.add(s.nextInt());

		System.out.println(new UniquePermutation().permute(A));
		s.close();
	}

}
