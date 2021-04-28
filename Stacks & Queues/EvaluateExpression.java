package ib.scaler.day46_Mar23;

import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression {

	public int evalRPN(String[] A) {
		Stack<String> S = new Stack<>();
		int l = A.length;
		int a, b;

		for (int i = 0; i < l; i++) {
			if (A[i].equals("+") || A[i].equals("-") || A[i].equals("*") || A[i].equals("/")) {
				a = Integer.parseInt(S.pop());
				b = Integer.parseInt(S.pop());
				switch (A[i]) {
				case "+":
					a = a + b;
					break;
				case "-":
					a = b - a;
					break;
				case "*":
					a = a * b;
					break;
				case "/":
					a = b / a;
					break;
				}
				S.push("" + a);
			} else {
				S.push(A[i]);
			}
		}
		return Integer.parseInt(S.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String A[] = new String[n];
		for (int i = 0; i < n; i++)
			A[i] = s.next();
		EvaluateExpression ee = new EvaluateExpression();
		System.out.println(ee.evalRPN(A));
		s.close();
	}

}
