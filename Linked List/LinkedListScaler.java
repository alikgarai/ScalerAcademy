package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class LinkedListScaler {

	static class Node {
		int value;
		Node next;
	}

	static Node head;
	static int len = 0;

	public static void insert_node(int position, int value) {
		if (position == 1) {
			Node tmp = head;
			Node newNode = new Node();
			newNode.value = value;
			newNode.next = tmp;
			head = newNode;
			len++;
		} else if (position - 1 <= len) {
			Node prev = head, tmp = head;
			while (tmp != null && position > 1) {
				prev = tmp;
				tmp = tmp.next;
				position--;
			}
			Node newNode = new Node();
			newNode.value = value;
			prev.next = newNode;
			newNode.next = tmp;
			len++;
		}
	}

	public static void delete_node(int position) {
		Node tmp = head, prev = head;
		if (position == 1) {
			head = head.next;
			len--;
		} else if (position <= len) {
			while (tmp != null && position > 1) {
				prev = tmp;
				tmp = tmp.next;
				position--;
			}
			prev.next = tmp.next;
			len--;
		}
	}

	public static void print_ll() {
		// Output each element followed by a space
		Node tmp = head;
		while (tmp.next != null) {
			System.out.print(tmp.value + " ");
			tmp = tmp.next;
		}
		System.out.print(tmp.value);

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = 0, position = 0, value = 0;
		cases = s.nextInt();
		for (int i = 0; i < cases; i++) {
			char ch = s.next().charAt(0);
			switch (ch) {
			case 'i':
				position = s.nextInt();
				value = s.nextInt();
				insert_node(position, value);
				break;
			case 'd':
				position = s.nextInt();
				delete_node(position);
				break;
			case 'p':
				print_ll();
				System.out.println();
				break;
			default:
				System.out.println("Check Your Input");
			}
		}
		s.close();
	}
}
