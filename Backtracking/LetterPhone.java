package ib.scaler.day25_Feb26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LetterPhone {

	ArrayList<String> ans = new ArrayList<>();
	HashMap<Integer, char[]> map = new HashMap<>();
	int n;

	void compute(String A, String B, int ind) {
		if (ind == n) {
			ans.add(B);
			return;
		}

		char c[] = map.get((int) (A.charAt(ind) - '0'));

		for (int i = 0; i < c.length; i++)
			compute(A, B + c[i], ind + 1);
	}

	public ArrayList<String> letterCombinations(String A) {
		map.put(0, new char[] { '0' });
		map.put(1, new char[] { '1' });
		map.put(2, new char[] { 'a', 'b', 'c' });
		map.put(3, new char[] { 'd', 'e', 'f' });
		map.put(4, new char[] { 'g', 'h', 'i' });
		map.put(5, new char[] { 'j', 'k', 'l' });
		map.put(6, new char[] { 'm', 'n', 'o' });
		map.put(7, new char[] { 'p', 'q', 'r', 's' });
		map.put(8, new char[] { 't', 'u', 'v' });
		map.put(9, new char[] { 'w', 'x', 'y', 'z' });

		n = A.length();
		compute(A, "", 0);

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new LetterPhone().letterCombinations(s.next()));
		s.close();
	}

}
