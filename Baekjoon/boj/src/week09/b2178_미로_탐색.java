package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b2178_미로_탐색 {
	
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	static int N, M, ans;
	static boolean[][] visited = new boolean[N][M];
	static int[][] maze;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M]; //출발: 0,0 도착: N-1, M-1
		visited = new boolean[N][M];
		ans = 0; //도착했으면 1로 바꾸기
		
		for (int i = 0; i < N; i++) {
			 String str = br.readLine();
			 for (int j = 0; j < M; j++) {
				maze[i][j] = Character.getNumericValue(str.charAt(j)); 
			}
		}
		visited = new boolean[N][M];
		BFS(0, 0);
		System.out.println(ans);
	}
	
	public static void BFS(int r, int c) {
		
		queue.add(null);
		
//		visited[r][c] = true; //방문처리
//		if(ans==1) return;
//		
//		for (int m = 0; m < 4; m++) {
//			int nr = r + dr[m];
//			int nc = c + dc[m];
//			if(nr>=0&& nr<N-1&&nc>=0&& nc<M-1 && maze[nr][nc]==0&&!visited[nr][nc]) {
//				BFS(nr, nc);
//			} else if(nr==N&&nc==M) {
//				ans = 1;
//				return;
//			}
//		}
		
		
	}
}