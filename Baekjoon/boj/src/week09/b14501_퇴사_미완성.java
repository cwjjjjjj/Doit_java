package week09;

import java.util.Arrays;
import java.util.Scanner;

public class b14501_퇴사_미완성 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //근무 일수 1~N
		int [] Time = new int[N+1]; //걸리는 기간
		int [] Price = new int[N+1]; //금액
		
		for (int i = 1; i <= N; i++) { //1번 인덱스부터 사용
			Time[i] = sc.nextInt();
			Price[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][N+1];
		
		for (int i = 1; i < N; i++) {
			//i번째 작업까지 고려한 경우가 저장됨

			for (int t = 0; t <= N; t++) {
				if(Time[i] <= N && t-Time[i]>0) {
					//해당 작업 판단
					//현재 남은 일수에서의 최적해는 dp[i-1][t]
					//이번 작업 고려한 최적해는 dp[i-1][t-Time[i]]+Price[i]
					dp[i][t] = Math.max(dp[i-1][t], dp[i-1][t-Time[i]]+Price[i]);
				} else { //현재 고려할 작업의 일수가 임시 일수를 벗어나 고려할 수 없는 경우
					dp[i][t] = dp[i-1][t];
				}
			} //작업을 하나씩 고려
		}
		System.out.println(dp[N][N]);
	}
}