package ib.scaler.day31_Mar4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BClosestPoints {

	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		HashMap<Long, ArrayList<ArrayList<Integer>>> hm = new HashMap<>();
		int n = A.size();
		long dist;
		ArrayList<ArrayList<Integer>> tmp;
		PriorityQueue<Long> minHeap = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			dist = (long) (Math.pow(A.get(i).get(0), 2) + Math.pow(A.get(i).get(1), 2));
			minHeap.add(dist);

			if (hm.containsKey(dist)) {
				hm.get(dist).add(A.get(i));
			} else {
				tmp = new ArrayList<>();
				tmp.add(A.get(i));
				hm.put(dist, tmp);
			}
		}

		while (B-- > 0) {
			dist = minHeap.remove();
			tmp = hm.get(dist);
			ans.add(tmp.get(0));
			tmp.remove(0);
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		ArrayList<Integer> tmp;

		for (int i = 0; i < n; i++) {
			tmp = new ArrayList<>();
			tmp.add(s.nextInt());
			tmp.add(s.nextInt());
			A.add(tmp);
		}
		int B = s.nextInt();
		System.out.println(new BClosestPoints().solve(A, B));
		s.close();
	}

}
