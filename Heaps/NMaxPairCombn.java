package ib.scaler.day70_Apr17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NMaxPairCombn {

	class QueueComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] > o2[0])
				return -1;
			else if (o1[0] < o2[0])
				return 1;
			else
				return 0;
		}
	}

	public int[] solve(int[] A, int[] B) {
		PriorityQueue<int[]> mH = new PriorityQueue<>(new QueueComparator());
		Set<int[]> hs = new TreeSet<>((a1, a2) -> {
			if (Arrays.equals(a1, a2))
				return 0;
			if (a1[0] != a2[0])
				return Integer.valueOf(a1[0]).compareTo(Integer.valueOf(a2[0]));
			return Integer.valueOf(a1[1]).compareTo(Integer.valueOf(a2[1]));
		});

		int n = A.length;
		int ans[] = new int[n];
		int x[];
		int k = 0, l = n - 1;

		Arrays.parallelSort(A);
		Arrays.parallelSort(B);

		mH.add(new int[] { A[l] + B[l], l, l });
		hs.add(new int[] { l, l });

		while (k < n) {
			int p = mH.peek()[1];
			int q = mH.peek()[2];

			ans[k++] = mH.remove()[0];

			x = new int[] { p - 1, q };
			if (!hs.contains(x) && p > 0) {
				mH.add(new int[] { A[p - 1] + B[q], p - 1, q });
				hs.add(x);
			}
			x = new int[] { p, q - 1 };
			if (!hs.contains(x) && q > 0) {
				mH.add(new int[] { A[p] + B[q - 1], p, q - 1 });
				hs.add(x);
			}
		}

		return ans;
	}

//	class Pair {
//		int a, b;
//
//		Pair(int x, int y) {
//			a = x;
//			b = y;
//		}
//
//		public boolean equals(Pair p) {
//			if (p.a == this.a && p.b == this.b)
//				return true;
//			else
//				return false;
//		}
//	}
//
//	class Triplet {
//		int sum;
//		Pair p;
//
//		Triplet(int x, Pair y) {
//			sum = x;
//			p = y;
//		}
//	}
//
//	class QueueComparator implements Comparator<Triplet> {
//		@Override
//		public int compare(Triplet p1, Triplet p2) {
//			// TODO Auto-generated method stub
//			if (p1.sum == p2.sum)
//				return 0;
//			else if (p1.sum < p2.sum)
//				return 1;
//			else
//				return -1;
//		}
//	}
//
//	public int[] solve(int[] A, int[] B) {
//		PriorityQueue<Triplet> mH = new PriorityQueue<>(new QueueComparator());
//		HashSet<Pair> hs = new HashSet<>();
//		int n = A.length;
//		int ans[] = new int[n];
//		Pair p;
//		int k = 0, x, y;
//
//		Arrays.parallelSort(A);
//		Arrays.parallelSort(B);
//
//		p = new Pair(n - 1, n - 1);
//		mH.add(new Triplet(A[n - 1] + B[n - 1], p));
//		hs.add(p);
//
//		while (k < n) {
//			x = mH.peek().p.a;
//			y = mH.peek().p.b;
//
//			ans[k++] = mH.remove().sum;
//
//			p = new Pair(x - 1, y);
//			if (!hs.contains(p) && x > 0) {
//				mH.add(new Triplet(A[x - 1] + B[y], p));
//				hs.add(p);
//			}
//			p = new Pair(x, y - 1);
//			if (!hs.contains(p) && y > 0) {
//				mH.add(new Triplet(A[x] + B[y - 1], p));
//				hs.add(p);
//			}
//		}
//
//		return ans;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();

		System.out.println(Arrays.toString(new NMaxPairCombn().solve(A, B)));
		s.close();
	}

}
