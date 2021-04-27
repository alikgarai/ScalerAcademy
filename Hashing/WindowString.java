package ib.scaler.day36_Mar11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WindowString {

	boolean compareMaps(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {

		for (Map.Entry<Character, Integer> mapElement : map1.entrySet()) {
			char key = mapElement.getKey();
			int value = mapElement.getValue();

			if (map2.get(key) < value)
				return false;
		}

		return true;
	}

	public String minWindow(String A, String B) {
		int wl, ws, s = 0, e = 0, n;
		char c;
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();

		n = B.length();

		for (int i = 0; i < n; i++) {
			c = B.charAt(i);
			if (map1.containsKey(c))
				map1.replace(c, map1.get(c) + 1);
			else {
				map1.put(c, 1);
				map2.put(c, 0);
			}
		}

		n = A.length();
		wl = 0;
		ws = n + 1;

		for (int i = 0; i < n; i++) {
			if (map1.containsKey(A.charAt(i))) {
				s = i;
				e = i;
				break;
			}
		}

		while (e < n) {
			if (compareMaps(map1, map2)) {
				if (ws > e - s) {
					wl = s;
					ws = e - s;
				}
				c = A.charAt(s);
				map2.replace(c, map2.get(c) - 1);
				c = A.charAt(++s);
				while (s < n - 1 && !map1.containsKey(c))
					c = A.charAt(++s);
			} else {
				c = A.charAt(e);
				if (map1.containsKey(c))
					map2.replace(c, map2.get(c) + 1);
				e++;
			}
		}
		if (compareMaps(map1, map2) && ws > e - s) {
			wl = s;
			ws = e - s;
		}

		if (ws > n)
			return "";
		else
			return A.substring(wl, wl + ws);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new WindowString().minWindow(s.next(), s.next()));
		s.close();
	}

}
