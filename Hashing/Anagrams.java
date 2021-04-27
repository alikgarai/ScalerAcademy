package ib.scaler.day42_Mar18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrams {

	public boolean isAnagram(String A, String B) {
		int l1 = A.length();
		int l2 = B.length();

		if (l1 != l2)
			return false;
		else {
			int x[] = new int[26];

			for (int i = 0; i < l1; i++)
				x[A.charAt(i) - 'a']++;

			for (int i = 0; i < l1; i++)
				x[B.charAt(i) - 'a']--;

			for (int i = 0; i < 26; i++) {
				if (x[i] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {

		ArrayList<ArrayList<Integer>> X = new ArrayList<ArrayList<Integer>>();
		X.add(new ArrayList<Integer>());
		X.get(0).add(1);
		int k = 0;
		boolean flg;

		for (int i = 1; i < A.size(); i++) {
			flg = false;
			for (int j = 0; j < X.size(); j++) {
				if (isAnagram(A.get(i), A.get(X.get(j).get(0) - 1))) {
					X.get(j).add(i + 1);
					flg = true;
				}
			}
			if (flg == false) {
				X.add(new ArrayList<Integer>());
				k++;
				X.get(k).add(i + 1);
			}
		}
		return X;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<String> A = new ArrayList<String>();
		for (int i = 0; i < n; i++)
			A.add(s.next());
		Anagrams anagram = new Anagrams();
		System.out.println(anagram.anagrams(A));
		s.close();
	}

}
