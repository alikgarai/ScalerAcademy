package ib.scaler.day56_Apr3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NextPointerBinaryTree {

	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> q = new LinkedList<>();
		TreeLinkNode end, tmp, last;

		q.add(root);
		end = root;
		last = root;

		while (!q.isEmpty()) {
			tmp = q.remove();
			if (tmp.left != null) {
				q.add(tmp.left);
				last = tmp.left;
			}
			if (tmp.right != null) {
				q.add(tmp.right);
				last = tmp.right;
			}
			if (end == tmp) {
				tmp.next = null;
				end = last;
			} else
				tmp.next = q.peek();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Queue<TreeLinkNode> q = new LinkedList<>();
		TreeLinkNode root = null, tmp, left, right;
		int n, val;

		n = s.nextInt();
		while (n > 0) {
			if (q.isEmpty()) {
				tmp = new TreeLinkNode(s.nextInt());
				n--;
				q.add(tmp);
				root = tmp;
			} else {
				tmp = q.remove();
				val = s.nextInt();
				n--;
				left = (val != -1) ? new TreeLinkNode(val) : null;
				if (left != null) {
					q.add(left);
					tmp.left = left;
				}
				val = s.nextInt();
				n--;
				right = (val != -1) ? new TreeLinkNode(val) : null;
				if (right != null) {
					q.add(right);
					tmp.right = right;
				}
			}
		}
		new NextPointerBinaryTree().connect(root);
		s.close();
	}

}
