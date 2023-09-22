package SWEA_1267_작업순서_스택;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	static int V, E;
	static int[][] adjArr;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> stack;

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1267_작업순서_스택/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#" + tc + " ");
			V = sc.nextInt();
			E = sc.nextInt();

			// 인접행렬
			adjArr = new int[V + 1][V + 1];
			degree = new int[V + 1];
			visited = new boolean[V + 1];

			stack = new Stack<>();

			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				// 유향이므로 A->B로만 저장
				adjArr[A][B] = 1;
				degree[B]++;
			}

			for (int i = 1; i < V+1; i++) {
				if (degree[i] == 0) {
					DFS(i);
				}
			}

			while (!stack.isEmpty()) {
//				if (stack.pop() != 0)
					System.out.printf(stack.pop() + " ");
			}
			System.out.println();
		} // tc
	}// main

	public static void DFS(int v) {
		visited[v] = true; // 현재 정점 방문체크

		for (int i = 0; i < V + 1; i++) {
			if (adjArr[v][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}
		stack.add(v);
	}
}// class
