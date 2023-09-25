package SWEA_1486_장훈이의_높은_선반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	//부분집합. 시간 복잡도 = O(2^N)

	static int N;
	static int B;
	static int minB;
	static int[] h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 점원 수
			B = Integer.parseInt(st.nextToken()); // 탑 높이

			h = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				h[i] = Integer.parseInt(st.nextToken()); // 점원의 키
			}
			minB = Integer.MAX_VALUE; // 초기값을 왕창 크게. 부분집합의 원소의 합이 B 이상인 최소값
			subset(0, 0);
			sb.append("#").append(tc).append(" ").append(0).append("\n");

		}
	}

	// 부분집합을 구해서 원소의 합이 B 이상인 최소값 구하는 메서드
	// idx: 각 단계 depth
	// sumH: 지금까지 선택된 직원의 키의 합
	private static void subset(int idx, int sumH) {
		// 기저파트
		if (idx == N) {
			if (B <= sumH && sumH < minB) {
				minB = sumH;
			}
			return; // 여기까지 왔다는 건 if문에 걸렸다는 것. else 블럭을 꺼내는 방법이 되기도 함
		}
		// 재귀파트
		subset(idx+1, sumH); //선택을 안 함
		subset(idx+1, sumH+h[idx]); //선택을 함
		//선택 안하는 경우도 해보고.. 다녀와서 선택하는 경우도 해보고...
	}
}