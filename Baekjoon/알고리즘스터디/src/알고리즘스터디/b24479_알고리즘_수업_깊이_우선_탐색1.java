package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b24479_알고리즘_수업_깊이_우선_탐색1 {

	static boolean[] visited;
	static int N;
	static int[][] adj;
	static StringBuilder sb = new StringBuilder();
	static int[] order;
	static List<Integer>[] adjList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer toke = new StringTokenizer(br.readLine());

		N = Integer.parseInt(toke.nextToken());
		int M = Integer.parseInt(toke.nextToken());
		int R = Integer.parseInt(toke.nextToken());
		visited = new boolean[N + 1];
		adj = new int[N + 1][N + 1];
		order = new int[N + 1];

		for (int i = 0; i < M; i++) {
			toke = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(toke.nextToken());
			int ed = Integer.parseInt(toke.nextToken());
			adj[st][ed] = adj[ed][st] = 1; // 무향그래프
		}
		DFS(R);
		for (int i = 1; i < N + 1; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb);
	}

	static int num = 1; // 방문 순서를 세기 위한 수

	private static void DFS(int v) {
		visited[v] = true;
		order[v] = num++;

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && adj[v][i] == 1)
				DFS(i);
		}
	}
}