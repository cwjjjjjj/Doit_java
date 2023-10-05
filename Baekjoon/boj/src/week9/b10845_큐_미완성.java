package week9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b10845_큐_미완성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> q = new ArrayDeque<Integer>();
		
		int N = sc.nextInt(); //명령어 개수
		
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			String order = sc.next();

			switch (order) {

			case "push":
				q.add(sc.nextInt());

			case "pop":
				if(!q.isEmpty())
					System.out.println(q.poll());
				System.out.println(-1);

			case "size":
				System.out.println(q.size());

			case "empty":
				if (!q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}

			case "front":
				if (!q.isEmpty()) {
					System.out.println(q.peekFirst());
				} else {
					System.out.println(-1);
				}

			case "back":
				if (!q.isEmpty()) {
					System.out.println(q.peekLast());
				} else {
					System.out.println(-1);
				}
			default:
				break;
			}
		}
	}
}