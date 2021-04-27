package ib.scaler.day36_Mar11;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutRepeat {

	public int lengthOfLongestSubstring(String A) {
		int max = 1;
		HashMap<Character, Integer> hm = new HashMap<>();
		int s = 0, e = 0, x, n = A.length();

		while (e < n) {
			char c = A.charAt(e);
			if (hm.containsKey(c)) {
				max = Math.max(max, e - s);
				x = hm.get(c);

				while (s <= x) {
					hm.remove(A.charAt(s));
					s++;
				}
			}

			hm.put(c, e);
			e++;
		}
		max = Math.max(max, e - s);
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring(s.next()));
		s.close();
	}

}
