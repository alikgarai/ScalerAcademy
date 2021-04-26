package ib.scaler.day07_Feb3;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeIntervals {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		int count = intervals.size();

		if (newInterval.start > newInterval.end) {
			int tmp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = tmp;
		}
		int i;
		for (i = 0; i < count; i++) {
			if (newInterval.start < intervals.get(i).start) {
				intervals.add(i, newInterval);
				count++;
				break;
			}
		}
		if (i == count) {
			intervals.add(i, newInterval);
			count++;
		}
		for (i = 0; i < count - 1; i++) {
			if (intervals.get(i).end >= intervals.get(i + 1).start) {
				if (intervals.get(i).end < intervals.get(i + 1).end) {
					intervals.get(i).end = intervals.get(i + 1).end;
				}
				intervals.remove(i + 1);
				count--;
				i--;
			}
		}

		return intervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n;

		n = s.nextInt();
		ArrayList<Interval> A = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Interval x = new Interval();
			x.start = s.nextInt();
			x.end = s.nextInt();

			A.add(i, x);
		}
		Interval B = new Interval();
		B.start = s.nextInt();
		B.end = s.nextInt();

		MergeIntervals c = new MergeIntervals();
		A = c.insert(A, B);
		for (int i = 0; i < A.size(); i++) {
			System.out.print("[" + A.get(i).start + "," + A.get(i).end + "] ");
		}
		s.close();
	}
}
