package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b24479_알고리즘_수업_깊이_우선_탐색1 {

	static boolean[] visited; //방문처리
	static int N; //정점의 수
	static int[][] adj;
	static StringBuilder sb = new StringBuilder();
	static int[] order; //방문 순서
	static List<Integer>[] adjList = new ArrayList[N+1]; //인접리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer toke = new StringTokenizer(br.readLine());

		N = Integer.parseInt(toke.nextToken());
		int M = Integer.parseInt(toke.nextToken()); //간선의 수
		int R = Integer.parseInt(toke.nextToken()); //시작 정점
		visited = new boolean[N + 1];
		adj = new int[N + 1][N + 1];
		order = new int[N + 1];

		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//M개의 간선 정보 입력
		for (int i = 0; i < M; i++) {
			toke = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(toke.nextToken());
			int B = Integer.parseInt(toke.nextToken());
			//모든 가중치 1
			
			adjList[A].add(B);
			adjList[B].add(A); //무향그래프
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