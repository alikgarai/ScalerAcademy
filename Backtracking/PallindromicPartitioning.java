package ib.scaler.day27_Feb28;

import java.util.ArrayList;
import java.util.Scanner;

public class PallindromicPartitioning {

	ArrayList<ArrayList<String>> ans = new ArrayList<>();
	int n;

	boolean isPallindrome(String A) {
		int e = A.length() - 1;
		int s = 0;

		while (s < e) {
			if (A.charAt(s) != A.charAt(e))
				return false;
			s++;
			e--;
		}
		return true;
	}

	void createPartition(String A, ArrayList<String> partitions, int start) {
		if (start == n) {
			ArrayList<String> tmp = new ArrayList<>();
			tmp.addAll(partitions);
			ans.add(tmp);
		}

		for (int i = start; i < n; i++) {
			String str = A.substring(start, i + 1);
			if (isPallindrome(str)) {
				partitions.add(str);
				createPartition(A, partitions, i + 1);
				partitions.remove(partitions.size() - 1);
			}
		}
	}

	public ArrayList<ArrayList<String>> partition(String a) {
		ArrayList<String> partitions = new ArrayList<>();
		n = a.length();
		createPartition(a, partitions, 0);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new PallindromicPartitioning().partition(s.next()));
		s.close();
	}

}
