package ib.scaler.day44_Mar20;

import java.util.ArrayList;
import java.util.Scanner;

public class MinStack {
	/**
	 * The commented solution will work if we don't print the pop() value. Because
	 * while pushing, if current value is less than peek element, we add (2*x-peek)
	 * value in stack, thus modifying the stack content.
	 * 
	 **/

//	Stack<Integer> S = new Stack<>();
//	int curr_min;
//
//	public void push(int x) {
//		if (S.empty()) {
//			S.push(x);
//			curr_min = x;
//		} else {
//			if (x < curr_min) {
//				S.push(2 * x - curr_min);
//				curr_min = x;
//			} else
//				S.push(x);
//		}
//	}
//
//	public void pop() {
//		if (!S.empty()) {
//			if (S.peek() < curr_min) {
//				curr_min = 2 * curr_min - S.peek();
//			}
//			S.pop();
//		}
//	}
//
//	public int top() {
//		if (S.empty())
//			return -1;
//		else
//			return S.peek();
//	}
//
//	public int getMin() {
//		if (S.empty())
//			return -1;
//		else
//			return curr_min;
//	}

	ArrayList<Integer> A = new ArrayList<>();
	ArrayList<Integer> minA = new ArrayList<>();

	public void push(int x) {
		int l = minA.size();

		A.add(x);
		if (l == 0) {
			minA.add(x);
		} else if (x < minA.get(l - 1)) {
			minA.add(x);
		}
	}

	public void pop() {
		int l1 = A.size();
		int l2 = minA.size();

		if (l1 != 0) {
			if (minA.get(l2 - 1) == top()) {
				minA.remove(l2 - 1);
			}
			A.remove(l1 - 1);
		}
	}

	public int top() {
		int l = A.size();
		if (l == 0)
			return -1;
		else
			return A.get(l - 1);
	}

	public int getMin() {
		int l = minA.size();
		if (l == 0)
			return -1;
		else
			return minA.get(l - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		MinStack minStack = new MinStack();
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			String c = s.next();
			switch (c) {
			case "P":
				int x = s.nextInt();
				minStack.push(x);
				break;

			case "p":
				minStack.pop();
				break;

			case "t":
				System.out.println(minStack.top());
				break;

			case "g":
				System.out.println(minStack.getMin());
				break;
			}
		}
		s.close();
	}

}
