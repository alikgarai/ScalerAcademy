package ib.scaler.day25_Feb26;

import java.util.ArrayList;
import java.util.Scanner;

public class Combinations {

	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	public void findCombinations(ArrayList<Integer> curr, int start, int A, int B) {
		if (curr.size() == B) {
			ans.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = start; i <= A; i++) {
			curr.add(i);
			findCombinations(curr, i + 1, A, B);
			curr.remove(curr.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<Integer> tmp = new ArrayList<>();
		findCombinations(tmp, 1, A, B);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int B = s.nextInt();
		System.out.println(new Combinations().combine(A, B));
		s.close();
	}

}
