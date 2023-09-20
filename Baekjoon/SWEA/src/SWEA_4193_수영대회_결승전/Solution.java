package SWEA_4193_수영대회_결승전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시뮬레이션, BFS
//소용돌이는 3초마다 주기반복. 0~1초 통과 불가, 1초 가능, 3~4초 불가, 5초 가능
//Queue로 BFS 구현 -> 사이즈만큼 반복하며 인접한 칸 모두 다녀봄
//대기하는 중에는 현재 좌표를 또 Queue에 넣기

public class Solution {
	private static int[] dr = {-1, 1, 0, 0}; //상하좌우
	private static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
			for(int tc = 1; tc < T; tc++) {
				int N = Integer.parseInt(br.readLine()); //수영장의 크기
				int[][] m = new int[N][N]; //웬만하면 배열이 제일 빠름
				boolean[][] visited = new boolean[N][N];
				for(int i = 0; i < N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine(), " ");
					for(int j = 0; j < N; j++) {
						m[i][j] = Integer.parseInt(st.nextToken());
					}
				} //입력받음
				
				//시간을 줄이기 위한 방법
				//1. 배열 바깥의 상하좌우로 1로 만들어진 벽 감싸주기
				//2. 해당 인풋 데이터에서는 쪼갤 필요 없음. 쪼개지 않고 옆으로 두 칸 이동해서 읽으면 더 빠름
				//3. 굳이 숫자로 바꾸지 말고 문자열로 비교하기
				
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int sr = Integer.parseInt(st.nextToken());
				int sc = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine(), " ");
				int er = Integer.parseInt(st.nextToken());
				int ec = Integer.parseInt(st.nextToken());
				//좌표를 하나의 수로 관리하기 => r*N+c => 나누기, % 연산자로 r, c구할 수 있음
				
				Queue<int[]> q = new LinkedList<int[]>();
				q.offer(new int[] {sr, sc});
				visited[sr][sc]= true;
				int result = -1; //도착 못할 경우의 초기값 -1
				int time = 0; //도착했으면 시간을 result에 넣기
				
				out: while(!q.isEmpty()) {
					//한 레벨을 통째로 들어냄
					int size = q.size();
					for(int i = 0; i < size; i++) {
						int[] pos = q.poll();
							for(int j = 0; j < dr.length; j++) {
								int nr = pos[0] + dr[j];
								int nc = pos[1] + dc[j];
								if(nr>=0 && nr<N && nc>=0 && nc<N && m[nr][nc]!=1 && !visited[nr][nc]) { //유효 인덱스 범위 내인지, 장애물이 아닌지, 미방문인지 검사
									if(nr == er && nr == ec) { //도착지점인지 확인
										result = time+1;
										break out;
									}
									if(m[nr][nc] == 2 && time%3 != 2) { //소용돌이면 대기. 즉 현재 좌표 pos를 다시 큐에 넣기
										q.offer(pos);
									} else { //소용돌이가 아니면 인접한 칸의 값을 큐에 넣기
										q.offer(new int[] {nr, nc});
										visited[nr][nc] = true;
									}
								}
							}
					}
					time++; //시간이 1초 지나있음. 이 위의 작업은 모두 시간 변경되기 전 1초 안에 완료
				}
				sb.append("#").append(tc).append(" ").append(result).append("\n");
				
			}
		
	} //main
} //class