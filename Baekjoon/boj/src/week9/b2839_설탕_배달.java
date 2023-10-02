package week9;

import java.util.Arrays;
import java.util.Scanner;

public class b2839_설탕_배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 설탕 무게

		int[] dp = new int[N + 1]; // 0번 인덱스부터 사용
		dp[0] = 0; // 0키로그램은 0봉지

		for (int i = 1; i < N + 1; i++) {
			int min = Integer.MAX_VALUE;
			// 3키로그램짜리 시도
			if(i >= 3) {
				min = Math.min(min, dp[i-3]+1);
			}
			if(i >= 5) {
				min = Math.min(min, dp[i-5]+1);
			}
			dp[i]= min;

			//3키로 미만이면
			if(i<3) {dp[i] = 0;}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}