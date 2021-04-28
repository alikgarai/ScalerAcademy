package ib.scaler.day48_Mar25;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NintegersContaining123 {

	public int[] solve(int A) {
		Queue<Integer> q = new LinkedList<>();
		int ans[] = new int[A];
		int k = 0;
		q.add(1);
		q.add(2);
		q.add(3);
		int cnt = 3;

		while (cnt < A) {
			int x = q.remove();
			ans[k++] = x;
			x = x * 10;
			q.add(x + 1);
			q.add(x + 2);
			q.add(x + 3);
			cnt += 3;
		}

		for (int i = k; i < A; i++)
			ans[i] = q.remove();

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(Arrays.toString(new NintegersContaining123().solve(n)));
		s.close();
	}

}
