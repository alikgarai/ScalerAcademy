package ib.scaler.day23_Feb24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Subset {

	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	public void findSubsets(ArrayList<Integer> curr, int start, ArrayList<Integer> A) {

		ans.add(new ArrayList<Integer>(curr));

		for (int i = start; i < A.size(); i++) {
			curr.add(A.get(i));
			findSubsets(curr, i + 1, A);
			curr.remove(curr.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<Integer> curr = new ArrayList<>();
		Collections.sort(A);
		findSubsets(curr, 0, A);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- > 0)
			A.add(s.nextInt());
		System.out.println(new Subset().subsets(A));
		s.close();
	}

}
