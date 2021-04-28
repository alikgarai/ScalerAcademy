package ib.scaler.day44_Mar20;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyDirectoryPath {

	public String simplifyPath(String A) {

		Stack<String> S = new Stack<String>();
		String X[] = A.split("/");
		int l = X.length;

		for (int i = 0; i < l; i++) {
			if (X[i].equals("..")) {
				if (!S.empty())
					S.pop();
			} else if (!X[i].equals("") && !X[i].equals("."))
				S.push(X[i]);
		}
		A = "";
		while (!S.empty()) {
			A = "/" + S.pop() + A;
		}

		return (A.length() == 0) ? "/" : A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.next();
		SimplifyDirectoryPath sdp = new SimplifyDirectoryPath();
		System.out.print(sdp.simplifyPath(A));
		s.close();
	}

}
