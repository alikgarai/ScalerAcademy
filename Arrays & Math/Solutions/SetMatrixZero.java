import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> a = new ArrayList<>();

		Scanner s = new Scanner(System.in);
		int r, c, v;

		r = s.nextInt();
		c = s.nextInt();

		for (int i = 0; i < r; i++) {
			a.add(i, new ArrayList<Integer>());
			for (int j = 0; j < c; j++) {
				v = s.nextInt();
				a.get(i).add(j, v);
			}
		}
		System.out.println(a);
		System.out.println(a.size());
		System.out.println(a.get(0).size());

		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a.get(i).get(j) == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		Iterator<Integer> it = cols.iterator();
		while (it.hasNext()) {
			int j = it.next();
			for (int i = 0; i < r; i++) {
				a.get(i).set(j, 0);
			}
		}
		it = rows.iterator();
		while (it.hasNext()) {
			int i = it.next();
			a.get(i).replaceAll(e -> 0);
		}

		System.out.println(a);

		s.close();
	}
}
