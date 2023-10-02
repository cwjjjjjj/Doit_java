package SWEA_2115_벌꿀채취;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int M;
	private static int C;
	private static int[][] map;
	private static int[][] memo;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 최대 50개 테스트 케이스
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 벌통들의 크기 N, 3 ≤ N ≤ 10
			M = Integer.parseInt(st.nextToken()); // 연속으로 채취해야하는 벌통의 개수 M, 1 ≤ M ≤ 5, M <= N
			C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양 C, 10 ≤ C ≤ 30
			map = new int[N][N]; // 벌통에 담긴 꿀의 양
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = s.charAt(index) - '0'; // 1 <= 꿀의 양 <= 9, 안쪼갤수 있으면 쪼개지 말자
				}
			}
			
			//한 번만 저장해서 계속 쓸 수 있게 저장해놓자
			memo = new int[N][N-M+1]; // 모든 위치에서 M영역을 지정하여, 부분집합으로 얻을 수 있는 최대 수익을 구해서 저장
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					getHoney(r, c, 0, 0, 0);
				}
			}
			
			int max1 = 0;
			int r1=-1, c1=-1; //어차피 갱신될 부분이라 쓰레기값 넣음. 겹치면 안 되기 때문에 좌표 저장
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) { //N-M 뒤의 칸은 어차피 못 씀
					if (max1 < memo[r][c]) {
						max1 = memo[r][c];
						r1 = r;
						c1 = c;
					}
				}
			}
			int max2 = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					//[c1 ~ c1+M-1]
			//[c ~ c+M-1]      [c ~ c+M-1] //영역이 겹치는지 확인하기 위함
					if (r==r1 && ((c<=c1 && c1<=c+M-1) || (c<=c1+M-1 && c1+M-1<=C+M-1))) continue; // 최대이익과 영역이 겹치면 제외
					//r이 r1 최대값과 겹치면, 넘어가
					if (max2 < memo[r][c]) max2 = memo[r][c];
				}
			}
			sb.append("#").append(testCase).append(" ").append(max1+max2).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	
	public static void getHoney(int r, int c, int index, int sum, int val) {
		//r, c == 시작지점
		//여기부터 시작해서 연속된 M칸 영역에서 얻을 수 있는 꿀의 최대 이익을 memo[r][c] 칸에 업데이트하는 메서드
		//index: M칸 영역에서 부분집합을 구할 때 고려할 원소 순서
		//sum : 꿀의 양의 합을 계산한 후에 들고 다님. 매번 계산하면 시간적 효율 떨어지기 때문
		//val : 지금까지 수확한 꿀의 수익의 누적합
		if (sum > C) return; //끝까지 왔어도 C를 넘어가면 못 써
		if (index == M) { //M까지 왔으면, 완성
			if (memo[r][c] < val) memo[r][c] = val; // 추후 C 제한을 여기서 체크해야하는지 확인
			return;
		}
		int temp = map[r][c+index];
		//간접 참조이므로, 여러 번 호출할 때는 변수에 담아놓는 것이 편함
		getHoney(r, c, index+1, sum + temp, val + temp*temp);
		getHoney(r, c, index+1, sum, val);
	}
} // end of class