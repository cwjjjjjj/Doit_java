package SWEA_4008_숫자_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class solution{
	
	static int N;
	static int[] op;
	static int[] num;
	static int max;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); //숫자의 개수 N
			StringTokenizer st = new StringTokenizer(br.readLine()," "); // +-*/의 개수
			op = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			num = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < num.length; i++) {
				num[1] = Integer.parseInt(st.nextToken()); //N 은 3 이상 12 이하의 정수이다. ( 3 ≤ N ≤ 12 )
			}
			max = Integer.MAX_VALUE;
			min = Integer.MIN_VALUE;
			
			dfs(1, num[0]);
			sb.append(false);
		}
		System.out.println();
	}

	//step: 현재 단계, val: 지금까지 결정된 연산자로 계산한 결과를 매개변수로 가지고 다니자
	//연산자의 순서를 바꿔서 순열을 만들어주는 메서드

	private static void dfs(int step, int val) {
		if(step == N) { //종료파트
			//최대, 최소 업데이트
			if(max < val) max = val;
			if(min > val) min = val;
			return;
		}
		
		//재귀파트
		for (int i = 0; i < op.length; i++) {
			if(op[i] > 0) {
				op[i]--;
				switch (i) { //속도는 반복문이 더 느림
				case 0: dfs(step+1, val + num[step]); break;
				case 1: dfs(step+1, val - num[step]); break;
				case 2: dfs(step+1, val * num[step]); break;
				case 3: dfs(step+1, val / num[step]); break;
				} 
				dfs(step+1, val + num[step]); //-
				op[i]++;
			}
		}
		
//		if(op[0]>0) {
//			op[0]--;
//			dfs(step+1, val + num[step]); //+
//			op[0]++; //다른 연산자도 넣어봐야 하니까 마치 사용 안 한 것처럼 다시 빼줌
//		}
//		if(op[1]>0) {
//			op[1]--;
//			dfs(step+1, val - num[step]); //-
//			op[1]++;
//		}
//		if(op[2]>0) {
//			op[2]--;
//			dfs(step+1, val * num[step]); //*
//			op[2]++;
//		}
//		if(op[3]>0) {
//			op[3]--;
//			dfs(step+1, val / num[step]); // /
//			op[3]++;
//		}
	}
}