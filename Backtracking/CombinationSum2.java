package ib.scaler.day23_Feb24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CombinationSum2 {

	public void findSum(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int start, int B,
			ArrayList<Integer> A) {
		if (B == 0) {
			ans.add(new ArrayList<Integer>(curr));
			return;
		}
		if (B < 0)
			return;

		int prev = -1;
		int val;

		for (int i = start; i < A.size(); i++) {
			val = A.get(i);
			if (prev != val) {
				if (B - val < 0)
					break;
				curr.add(val);
				findSum(ans, curr, i + 1, B - val, A);
				curr.remove(curr.size() - 1);
				prev = val;
			}
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

		Collections.sort(a);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<>();
		findSum(ans, tmp, 0, b, a);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++)
			A.add(s.nextInt());
		int B = s.nextInt();

		CombinationSum2 cs = new CombinationSum2();
		ArrayList<ArrayList<Integer>> C = cs.combinationSum(A, B);
		for (int i = 0; i < C.size(); i++)
			System.out.println(C.get(i));
		s.close();
	}

}
