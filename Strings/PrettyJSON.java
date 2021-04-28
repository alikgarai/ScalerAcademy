package ib.scaler.day40_Mar16;

import java.util.ArrayList;
import java.util.Scanner;

public class PrettyJSON {

	public String[] prettyJSON(String A) {

		int l;
		char x;
		String y = "", z = "", tabs = "";
		ArrayList<String> C = new ArrayList<>();

		for (int i = 0; i < A.length(); i++) {
			x = A.charAt(i);
			y = (i == A.length() - 1) ? "" : "" + A.charAt(i + 1);

			if ((x + y).equals("},") || (x + y).equals("],")) {
				if (z != "") {
					C.add(tabs + z);
					z = "";
				}
				tabs = tabs.length() <= 1 ? "" : tabs.substring(1);
				C.add(tabs + x + y);
				i++;

			} else if (x == '{' || x == '[') {
				if (z != "") {
					C.add(tabs + z);
					z = "";
				}
				C.add(tabs + x);
				tabs += "\t";

			} else if (x == '}' || x == ']') {
				if (z != "") {
					C.add(tabs + z);
					z = "";
				}
				tabs = tabs.length() <= 1 ? "" : tabs.substring(1);
				C.add(tabs + x);

			} else if (x == ',') {
				C.add(tabs + z + x);
				z = "";
			} else {
				z += x;
			}
		}
		l = C.size();
		String B[] = new String[l];
		C.toArray(B);

		return B;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A;

		A = s.nextLine();
		PrettyJSON pj = new PrettyJSON();
		String X[] = pj.prettyJSON(A);
		for (int i = 0; i < X.length; i++)
			System.out.println(X[i]);
		System.out.println();
		s.close();
	}

}

// {"attributes":[{"nm":"ACCOUNT","lv":[{"v":{"Id":null,"State":null},"vt":"java.util.Map","cn":1}],"vt":"java.util.Map","status":"SUCCESS","lmd":13585},{"nm":"PROFILE","lv":[{"v":{"Party":null,"Ads":null},"vt":"java.util.Map","cn":2}],"vt":"java.util.Map","status":"SUCCESS","lmd":41962}]}
// {"a":[{"b":2},{"c":3}],"z":"26"}