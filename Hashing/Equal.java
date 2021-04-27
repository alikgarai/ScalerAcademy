package ib.scaler.day38_Mar13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Equal {
	class Pair {
		int x, y;

		Pair(int i, int j) {
			x = i;
			y = j;
		}
	}

	int ans[];

	void compare(Pair p, int x, int y) {
		if (ans == null)
			ans = new int[] { p.x, p.y, x, y };
		else {
			if ((p.x < ans[0]) || (p.x == ans[0] && p.y < ans[1]) || (p.x == ans[0] && p.y == ans[1] && x < ans[2])
					|| (p.x == ans[0] && p.y == ans[1] && x == ans[2] && y < ans[3])) {
				ans[0] = p.x;
				ans[1] = p.y;
				ans[2] = x;
				ans[3] = y;
			}
		}
	}

	public int[] equal(int[] A) {

		HashMap<Integer, Pair> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int sum = A[i] + A[j];
				if (map.containsKey(sum)) {
					Pair p = map.get(sum);
					if (p.x != i && p.x != j && p.y != i && p.y != j)
						compare(p, i, j);
				} else
					map.put(sum, new Pair(i, j));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		System.out.println(Arrays.toString(new Equal().equal(A)));
		s.close();
	}

}
