package ib.scaler.day29_Mar2;

import java.util.Scanner;

public class InversionCount {

	int temp[];
	long count = 0;

	void merge(int[] A, int s, int m, int e) {
		int i = s, j = m, k = s;

		while (i < m && j <= e) {
			if (A[i] <= A[j]) {
				temp[k] = A[i];
				i++;
			} else {
				count += m - i;
				temp[k] = A[j];
				j++;
			}
			k++;
		}
		while (i < m) {
			temp[k++] = A[i++];
		}
		while (j <= e) {
			temp[k++] = A[j++];
		}
		for (int x = s; x <= e; x++)
			A[x] = temp[x];

		count = count % 1000000007;
	}

	void mergeSort(int[] A, int s, int e) {
		if (s >= e)
			return;
		int mid = (s + e) / 2;
		mergeSort(A, s, mid);
		mergeSort(A, mid + 1, e);
		merge(A, s, mid + 1, e);
	}

	public int solve(int[] A) {
		temp = new int[A.length];
		mergeSort(A, 0, A.length - 1);

		return (int) count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.print(new InversionCount().solve(A));
		s.close();
	}

}
