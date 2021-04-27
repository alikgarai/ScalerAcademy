package ib.scaler.day29_Mar2;

import java.util.Scanner;

public class KthSmallest {
	int temp[];

	void merge(int[] A, int s, int m, int e) {
		int i = s, j = m, k = s;

		while (i < m && j <= e) {
			if (A[i] < A[j]) {
				temp[k] = A[i];
				i++;
			} else {
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
	}

	void mergeSort(int[] A, int s, int e) {
		if (s >= e)
			return;
		int mid = (s + e) / 2;
		mergeSort(A, s, mid);
		mergeSort(A, mid + 1, e);
		merge(A, s, mid + 1, e);
	}

	public int kthsmallest(final int[] A, int B) {
		temp = new int[A.length];
		mergeSort(A, 0, A.length - 1);

		return A[B - 1];
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
		int B = s.nextInt();
		KthSmallest ks = new KthSmallest();
		System.out.print(ks.kthsmallest(A, B));
		s.close();
	}

}
