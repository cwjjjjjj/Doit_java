package SWEA_1226_미로1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static int[][] maze = new int[16][16]; // 16*16 크기의 미로 배열
	public static boolean[][] visited = new boolean[16][16]; // 방문 처리 배열
	// 4방 탐색을 위한 방향 설정. 상 우 하 좌
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static int ans;

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/SWEA_1226_미로1/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) { // tc를 도는 for문
			StringBuilder sb = new StringBuilder();
			ans = 0;
			int r = 0;
			int c = 0;
			tc = sc.nextInt(); // 현재 tc의 번호
			for (int i = 0; i < 16; i++) { // 미로 배열 입력 받음
				String tmp = sc.next();
				int num = 0;
				for (int j = 0; j < 16; j++) {
					maze[i][j] = Character.getNumericValue(tmp.charAt(num++));
					if (maze[i][j] == 2) { // 출발지점 2 찾아서 저장
						r = i;
						c = j;
					}
				}
			}
			visited = new boolean[16][16]; //static은 초기화 꼭 하기!!!!!!!!!!!!!!!!!!!!
			DFS(r, c);
//			for(boolean[] in : visited) {
//				System.out.println(Arrays.toString(in));
//			}
			sb.append("#").append(tc + " ").append(ans);
			System.out.println(sb);
		} // tc
	} // main

	public static void DFS(int r, int c) {
		visited[r][c] = true; // 방문
		if (ans == 1)
			return;

		for (int m = 0; m < 4; m++) { // 4방탐색
			int nr = r + dr[m];
			int nc = c + dc[m];
			if (maze[nr][nc] == 0 && !visited[nr][nc]) { // 보통은 인덱스 유효 범위 체크도 해야 함 //visited 검사 빼먹음
//				r = nr;
//				c = nc; //전체 틀인 r, c를 바꾸면 안 됨
				DFS(nr, nc);
			} else if (maze[nr][nc] == 3) { // 3에 도착할 경우
				ans = 1;
				return;
			}
		}
	}
} // class

// 스택
//	//내가 방문하고 있는 정점 v를 방문처리함
//	public void DFS(int r, int  c) {
//		Stack<int[]> stack = new Stack<>();
//		//간선이 있고 방문하지 않았으면 스택에 넣고 방문처리
//		visited[r][c] = true; //방문 처리
//		stack.push(new int[] {r, c}); //스택  push
//		while(!stack.isEmpty()) { //도착하면 비게 됨 //사전준비
//			int[] now = stack.pop(); //젤 위에
////			if() //m++, 옆자리가 0이면 nr, nc 갱ㅅ니
//			
//		}
//		//뺄 때 방문처리라고 치기
//		//r, c 기준으로 4방 탐색하여 다음좌표가 이동 가능하면 DFS(nr, nc) 호출
//		
//		//maze[r][c] == 3 이면 종료
//	}